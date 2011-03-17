public class User{
	private String name;
	public User(Client c){
		name = new String("default");
	}
	
	public User(String name){
		this.name = new String("name");
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = new String(name);
	}
}
