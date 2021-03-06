package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;

public class Accounts extends Controller
{
	public static void signup()
	{
		render();
	}
	
	public static void login()
	{
		render();
	}
	
	public static void logout()
	  {
	    session.clear();
	    Logger.info("You have been logged out");
	    index();
	  }
	
	public static void index()
	{
		render();
	}
	
	public static void register(String firstName, String lastName, String email, String password, String age, String nationality)
	{
		Logger.info(firstName + "" + lastName + "" + email + "" + password + "" + age + "" + nationality);
		User puser = User.findByEmail(email);
		if(puser!=null)
		{
			Logger.info("Authentication failed");
			System.out.println("The email has to be unique");
			signup();
		}
		else
		{
		User user = new User(firstName, lastName, email, password, age, nationality);
		user.save();
		index();
		}
	}
	
	public static void authenticate(String email, String password)
	  {
	    Logger.info("Attempting to authenticate with " + email + ":" +  password);

	    User user = User.findByEmail(email);
	    if ((user != null) && (user.checkPassword(password) == true))
	    {
	      Logger.info("Authentication successful");
	      session.put("logged_in_userid", user.id);
	      Home.index();
	    }
	    else
	    {
	      Logger.info("Authentication failed");
	      login();  
	    }
	  }
	
}