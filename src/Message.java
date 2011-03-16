import java.rmi.*;
import java.rmi.server.*;

public class Message extends UnicastRemoteObject implements MessageInterface {
  private String message;
  private String recepient;

  public Message (String msg,String recv) throws RemoteException{
    message = msg;
    recepient = recv;
  }

  public String to() throws RemoteException {
    return recepient;
  }

  public String say() throws RemoteException {
    return message;
  }
}
