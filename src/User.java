public class User{
	String name;
	public User(){
		name = new String("default");
	}
	
	public User(String name){
		this.name = new String("name");
	}
	
	public String getName(){
		return name;
	}

	public setName(String name){
		this.name = new String(name);
	}
}
