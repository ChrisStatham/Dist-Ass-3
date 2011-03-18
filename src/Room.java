import java.util.Hashtable;
import java.rmi.*;

public class Room{
	String name;
	public Hashtable<String,ClientInterface> users;
        Hashtable<ClientInterface,String> userNames;

	public Room(){
		name = new String("default");
		users = new Hashtable();
                userNames = new Hashtable();
	}

	public Room(String name){
		this.name = new String(name);
		users = new Hashtable();
                userNames = new Hashtable();
	}

	public void sendMessage(Message m){
		for(ClientInterface c : users.values()){
			try{ c.recvMsg(m);
                        } catch(RemoteException e){
                           this.removeClient(userNames.get(c));
                        }
		} 
        }
	
	public ClientInterface getClient(String name){
		return users.get(name);
	}
	
	public void addClient(ClientInterface c){
		try{
		users.put(c.getName(),c);
		userNames.put(c,c.getName());
		}catch(RemoteException e){
			
		}	
	}

	public ClientInterface removeClient(String name){
		userNames.remove(users.get(name));
		return users.remove(name); 
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = new String(name);
	}
}
