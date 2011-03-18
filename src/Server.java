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

  public void joinRoom(String clientName,String r) throws RemoteException{
    Room room = rooms.get(r);
    if(room == null){
      room = new Room(r);
      rooms.put(r,room); 
    }
    try{
      room.addClient((ClientInterface)Naming.lookup("//statham.ca/"+clientName));
    } catch(Exception e){
      System.out.println("Client could not join room: " + e);
    }
  }

  public void leaveRoom(String c,String r) throws RemoteException{
    Room room = rooms.get(r);
    if(room == null) return;
    room.removeClient(c);
  }

  public void list(Message m){
    try{
    Room room = rooms.get(m.getTo());
    Message msg = new Message("User List:","wisper",m.getFrom(),"Server");
    room.getClient(m.getFrom()).recvMsg(msg);
    for(ClientInterface c : room.users.values()){
      msg = new Message(c.getName(),"wisper",m.getFrom(),"Server");
      room.getClient(m.getFrom()).recvMsg(msg);
    }
    } catch(Exception e){

    }
  }

  public void sendMsg(Message m) throws RemoteException{
    if(m.getType().equals("wisper")){
      wisper(m);
    } else if(m.getType().equals("broadcast")){
      broadcast(m);
    } else if(m.getType().equals("list")){
      list(m);
    }else{ 
      rooms.get(m.getTo()).sendMessage(m);    
    }
  }

  public void wisper(Message m){
    for(Room r: rooms.values()){
      if((r.getClient(m.getTo())) != null){
	try{
        r.getClient(m.getTo()).recvMsg(m);
	}catch(RemoteException e){

        }
      }
    } 
  }

  public void broadcast(Message m){
    for(Room r: rooms.values()){
      r.sendMessage(m); 
    }
  }
}
