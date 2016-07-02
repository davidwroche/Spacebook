package models;

import javax.persistence.*;
import play.db.jpa.*;
import java.util.Date;
import java.util.List;
import java.util.Collections;


@Entity
public class Message extends Model
{
  public String messageText;
  public String subject;
  public Date date;
  @ManyToOne
  public User from;

  @ManyToOne
  public User to;

  public Message(User from, User to, String subject, String messageText, Date date)
  {
    this.from = from;
    this.to = to;
    this.messageText = messageText;
    this.subject = subject;
    this.date = date;
  }
  
  public Date getDate()
  {
	  return date;
  }
}