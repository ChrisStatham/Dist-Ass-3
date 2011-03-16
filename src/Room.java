import java.util.Hashtable;

public class Room{
	String name;
	LinkedList<String,User> users;

	public Room(){
		name = new String("default");
	}

	public Room(String name){
		this.name = new String(name);
	}
	
	public User getUser(String name){
		return users.get(name);
	}
	
	public void addUser(String name){
		return users.put(name,new User(name));
	}

	public User removeUser(String name){
		return users.remove(name); 
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = new String(name);
	}
}
