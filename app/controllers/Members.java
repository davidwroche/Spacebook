package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Members extends Controller
{
  public static void index()
  {
	  String userId = session.get("logged_in_userid");
	  
	  if(userId==null)
	    {
	    	Accounts.login();
	    }
	    else
	    {
	    	User rm = User.findById(Long.parseLong(userId));
	  	  List<User> users = User.findAll();
	  	  users.remove(rm);
	  	  
	  	  render(users);
	  	  
	    }
	  
	  
  }
 
  public static void follow(Long id)
  {
    User friend = User.findById(id);

    String userId = session.get("logged_in_userid");
    User me = User.findById(Long.parseLong(userId));
    me.befriend(friend);
    Home.index();
  }
}