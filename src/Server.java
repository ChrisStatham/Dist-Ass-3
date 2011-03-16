import java.rmi.*;
import java.rmi.server.*;
import java.util.Hashtable;

public class Server{
  Hashtable<String,Room> rooms;
  public Server(){
    rooms = new Hashtable();
  }	

  public static void main(String[] argv){
    try{
      Naming.rebind("Message",new Message ("Our Message","Chris"));
      System.out.println("Message Server is ready.");
    } catch (Exception e) {
      System.out.println("Message Server failed: " + e);
    }
  }

  public boolean joinRoom(User u,String r){
	
  }
}
