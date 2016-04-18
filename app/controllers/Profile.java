package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;
import play.db.jpa.Blob;


public class Profile extends Controller
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
	    User user = User.findById(Long.parseLong(userId));
	    render(user);
	    }
	  }
  
	  public static void changeStatus(String profiletext)
	  {
	    String userId = session.get("logged_in_userid");
	    User user = User.findById(Long.parseLong(userId));
	    user.statusText = profiletext;
	    user.save();
	    Logger.info("Status changed to " + profiletext);
	    index();
	  } 
	  
		public static void editdetails(String firstName, String lastName, String email, String password, String age, String nationality)
		{
			Logger.info(firstName + "" + lastName + "" + email + "" + password + "" + age + "" + nationality);
			
			User puser = User.findByEmail(email);
			String userId = session.get("logged_in_userid");
			User user = User.findById(Long.parseLong(userId));
			if(puser!=null)
			{
				Logger.info("Email change failed,it already exists");
				user.email = email;
				System.out.print("That email already exists");
				index();
			}
			else
			{
			user.firstName = firstName;
			user.lastName = lastName;
			user.email = email;
			user.password = password;
			user.age = age;
			user.nationality = nationality;
			user.save();
			Logger.info("Personal information updated to" + firstName + "" + lastName + "" + email + "" + password + "" + age + "" + nationality);
			index();
			}
		}
		
	  
	  public static void getPicture(Long id) 
	  {
	    User user = User.findById(id);
	    Blob picture = user.profilePicture;
	    if (picture.exists())
	    {
	      response.setContentTypeIfNotSet(picture.type());
	      renderBinary(picture.get());
	    }
	  }

	  public static void uploadPicture(Long id, Blob picture)
	  {
	    User user = User.findById(id);
	    user.profilePicture = picture;
	    user.save();
	    index();
	  }
	  
}