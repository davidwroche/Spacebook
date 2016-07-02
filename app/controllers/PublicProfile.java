package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import java.util.Date;

import models.*;

public class PublicProfile extends Controller {
	public static void index() {
		render();
	}

	public static void visit(Long id) {

		String userId = session.get("logged_in_userid");
		if (userId == null) {
			Accounts.login();
		} else {
			User user = User.findById(id);
			Logger.info("Just visiting the page for " + user.firstName + ' ' + user.lastName);
			render(user);
		}
	}

	public static void sendMessage(Long id, String subject, String messageText, Date date) {
		String userId = session.get("logged_in_userid");
		User fromUser = User.findById(Long.parseLong(userId));
		User toUser = User.findById(id);

		Logger.info("Message from user " + fromUser.firstName + ' ' + fromUser.lastName + " to " + toUser.firstName
				+ ' ' + toUser.lastName + ": " +subject+ ' '+ messageText + ' ' + date);

		fromUser.sendMessage(toUser, subject, messageText, date);
		visit(id);
	}
}