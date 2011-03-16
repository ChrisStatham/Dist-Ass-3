import java.rmi.*;
public class Client{
  public static void main(String[] argv){
    try{
      MessageInterface msg =
        (MessageInterface) Naming.lookup("Message");
      System.out.println(msg.to() + " Says: " + msg.say());
    } catch (Exception e){
      System.out.println("Couldnt call Say:" + e);
    }
  }
}
