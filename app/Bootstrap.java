import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import play.*;
import play.jobs.*;
import play.libs.MimeTypes;
import play.test.*;
import play.db.jpa.Blob;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job 
{ 
  public void doJob()
  {
    Fixtures.deleteDatabase();
    Fixtures.loadModels("data.yml");
    
    String photoName = "public/images/homer.gif";
    Blob blob = new Blob();
    try {
		blob.set(new FileInputStream(photoName), MimeTypes.getContentType(photoName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User homer = User.findByEmail("homer@simpson.com");
    homer.profilePicture = blob;
    homer.save();
    //Section
    
    
    
    String photoName1 = "public/images/dav.png";
    Blob blob1 = new Blob();
    try {
		blob1.set(new FileInputStream(photoName1), MimeTypes.getContentType(photoName1));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User david = User.findByEmail("davidwroche@yahoo.co.uk");
    david.profilePicture = blob1;
    david.save();
    
//Section
    
    
    
    String photoName2 = "public/images/deb.png";
    Blob blob2 = new Blob();
    try {
		blob2.set(new FileInputStream(photoName2), MimeTypes.getContentType(photoName2));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User deb = User.findByEmail("deb@yahoo.co.uk");
    deb.profilePicture = blob2;
    deb.save();
    
    
//Section
    
    String photoName3 = "public/images/cr.png";
    Blob blob3 = new Blob();
    try {
		blob3.set(new FileInputStream(photoName3), MimeTypes.getContentType(photoName3));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User mark = User.findByEmail("markrnroche@yahoo.co.uk");
    mark.profilePicture = blob3;
    mark.save();
    
//Section
    
    String photoName4 = "public/images/bart.gif";
    Blob blob4 = new Blob();
    try {
    	blob4.set(new FileInputStream(photoName4), MimeTypes.getContentType(photoName4));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User bart = User.findByEmail("bart@simpson.com");
    bart.profilePicture = blob4;
    bart.save();
    
//Section
    
    String photoName5 = "public/images/moe.jpg";
    Blob blob5 = new Blob();
    try {
    	blob5.set(new FileInputStream(photoName5), MimeTypes.getContentType(photoName5));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User moe = User.findByEmail("moe@syzlack.com");
    moe.profilePicture = blob5;
    moe.save();

//Section
    
    String photoName6 = "public/images/maggie.gif";
    Blob blob6 = new Blob();
    try {
    	blob6.set(new FileInputStream(photoName6), MimeTypes.getContentType(photoName6));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User maggie = User.findByEmail("maggie@simpson.com");
    maggie.profilePicture = blob6;
    maggie.save();
    
//Section
    
    String photoName7 = "public/images/marge.gif";
    Blob blob7 = new Blob();
    try {
    	blob7.set(new FileInputStream(photoName7), MimeTypes.getContentType(photoName7));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User marge = User.findByEmail("marge@simpson.com");
    marge.profilePicture = blob7;
    marge.save();
    
//Section
    
    String photoName8 = "public/images/Herb.png";
    Blob blob8 = new Blob();
    try {
    	blob8.set(new FileInputStream(photoName8), MimeTypes.getContentType(photoName8));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User herb = User.findByEmail("herb@simpson.com");
    herb.profilePicture = blob8;
    herb.save();
 
//Section
    
    String photoName9 = "public/images/Barney.png";
    Blob blob9 = new Blob();
    try {
    	blob9.set(new FileInputStream(photoName9), MimeTypes.getContentType(photoName9));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    User barney = User.findByEmail("barney@rubble.com");
    barney.profilePicture = blob9;
    barney.save();
    
  }
 
}