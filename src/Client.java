import java.rmi.*;
public class Client{
  User me;
  ServerInterface serv;

  public Client(String name){
    me = new User(name);
    try{
      serv = (ServerInterface) Naming.lookup("Server");
    } catch (Exception e){
      System.out.println("An unexpected error has occured");
    }
  }

  public void joinRoom(String room){

  }

  public void sendMsg(User u, Message m){

  }

  public static void main(String[] argv){
    /*try{
      MessageInterface msg =
        (MessageInterface) Naming.lookup("Message");
      System.out.println(msg.to() + " Says: " + msg.say());
    } catch (Exception e){
      System.out.println("Couldnt call Say:" + e);
    }*/
  }
}
