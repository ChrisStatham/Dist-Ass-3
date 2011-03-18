import java.rmi.*;
import java.rmi.server.*;
import java.io.Serializable;

public class Message implements Serializable{
  private String from;
  private String to;
  private String message;
  private String type;

  public Message (String msg,String type,String room,String from){
    this.to = new String(room);
    message = new String(msg);
    this.type = new String(type);
    this.from = new String(from);
  }

  public String getFrom(){
    return from;
  }
	
  public void setTo(String usr){
    to = new String(usr); 
  }

  public String getTo(){
    return to;
  }

  public String getType() {
    return type;
  }

  public String say() {
    return message;
  }
}
