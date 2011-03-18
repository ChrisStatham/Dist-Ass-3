import java.rmi.*;
import java.rmi.server.*;
import java.io.Serializable;

public class Client extends UnicastRemoteObject implements Serializable,ClientInterface{
  String me;
  String room;
  ServerInterface serv;
  GUI g;

  public Client(String name) throws RemoteException{
    me = new String(name);
    try{
      Naming.rebind(name,this);
      serv = (ServerInterface) Naming.lookup("//statham.ca/Server");
    } catch (Exception e){
      System.out.println("An unexpected error has occured: " + e);
    }
  }

  public Client(String name,String room,GUI g) throws RemoteException{
    me = new String(name);
    this.room = new String(room);
    this.g = g;
    try{
      Naming.rebind(name,this);
      serv = (ServerInterface) Naming.lookup("Server");
    } catch (Exception e){
      System.out.println("An unexpected error has occured: " + e);
    }
    this.joinRoom(room);
  }

  public void recvMsg(Message m) throws RemoteException{
    if(m.getType().equals("wisper")){
      System.out.println("WISPER " + m.getFrom() + ":" + m.say());
      g.updateText("WISPER " + m.getFrom() + ":" + m.say());
    } else if(m.getType().equals("broadcast")){
      System.out.println("BROADCAST " + m.getFrom() + ":" + m.say());
      g.updateText("BROADCAST " + m.getFrom() + ":" + m.say());
    } else{
      System.out.println(m.getFrom() + ":" + m.say());
      g.updateText(m.getFrom() + ":" + m.say());
    }
  }

  public String getName() throws RemoteException{
    return me;
  }

  public void joinRoom(String room){
    try{
      serv.joinRoom(this.me,room);
      this.room = new String(room);
    }catch (Exception e){
      System.out.println("Exception: " + e);
    }
  }

  public String getRoom(){
    return room;
  }

  public void leaveRoom(String room){
    try{
      serv.leaveRoom(this.getName(),room);
    }catch (Exception e){
      System.out.println("Exception: " + e);
    }
  }

  public void sendMsg(Message m) {
    try{
      serv.sendMsg(m);
    }catch (Exception e){
      System.out.println("Exception: " + e);
    }
  }

  public static void main(String[] argv){
    GUI g = new GUI(); 
    NameGUI name = new NameGUI(g);
    name.buildGUI();
    /*try{
      System.out.println("Creating Client");
      Client c = new Client("chris","room1");
      System.out.println("Creating Message");
      Message m = new Message("Hey ya!","normal","room1",c.getName());
      System.out.println("Joining Room1");
      c.joinRoom("chris","room1");
      System.out.println("Sending Message");
      c.sendMsg(m);
      Thread.currentThread().sleep(1000);
      System.out.println("Leaving Room");
      c.leaveRoom("room1");
      System.exit(1);
   }catch(Exception e){
      System.out.println("Exception: " + e);
   }*/
  }
}
