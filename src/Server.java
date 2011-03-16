import java.rmi.*;
import java.rmi.server.*;
import java.util.LinkedList;

public class Server{
  public static void main(String[] argv){
    try{
      Naming.rebind("Message",new Message ("Our Message","Chris"));
      System.out.println("Message Server is ready.");
    } catch (Exception e) {
      System.out.println("Message Server failed: " + e);
    }
  }
}
