import java.util.Hashtable;

public class Room{
	String name;
	Hashtable<String,User> users;

	public Room(){
		name = new String("default");
		users = new Hashtable();
	}

	public Room(String name){
		this.name = new String(name);
		users = new Hashtable();
	}
	
	public User getUser(String name){
		return users.get(name);
	}
	
	public void addUser(String name){
		users.put(name,new User(name));
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
