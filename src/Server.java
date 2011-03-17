import java.rmi.*;
import java.rmi.server.*;
import java.util.Hashtable;

public class Server extends UnicastRemoteObject implements ServerInterface{
  private Hashtable<String,Room> rooms;

  public Server() throws RemoteException{
    rooms = new Hashtable();
  }	

  public static void main(String[] argv){
    try{
      Naming.rebind("Server",new Server ());
      System.out.println("Message Server is ready.");
    } catch (Exception e) {
      System.out.println("Message Server failed: " + e);
    }
  }

  public void joinRoom(Client c,String r) throws RemoteException{
    Room room= rooms.get(r);
    if(room == null){
      rooms.put(r,new Room(r)); 
    }

    //room.addUser(u);
  }

  public void leaveRoom(Client c,String r) throws RemoteException{
    Room room = rooms.get(r);
    if(room == null) return;
    //room.removeUser(u);
  }

  public void sendMessage(Client c,Message m) throws RemoteException{

   }

  public void wisper(Client c, String userName,String room,String msg){
  
  }

  public void broadcast(Client c, String msg){

  }
}
