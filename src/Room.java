import java.util.LinkedList;

public class Room{
	String name;
	LinkedList users;

	public Room(){
		name = new String("default");
	}

	public Room(String name){
		this.name = new String(name);
	}
	
	public addUser(){
		
	}
	
	public String getName(){
		return name;
	}

	public String setName(String name){
		this.name = new String(name);
	}
}
