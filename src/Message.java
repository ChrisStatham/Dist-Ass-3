import java.rmi.*;
import java.rmi.server.*;

public class Message {
  private String message;
  private String type;
  private String to;

  public Message (String msg,String type) throws RemoteException{
    message = msg;
    this.type = type;
  }
	
  public void setTo(String usr){
    to = new String(usr); 
  }

  public String getTo(){
    return to;
  }

  public String type() throws RemoteException {
    return type;
  }

  public String say() throws RemoteException {
    return message;
  }
}
