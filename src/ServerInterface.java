import java.rmi.*;

public interface ServerInterface extends Remote{

public void joinRoom(String u, String room) throws RemoteException;

public void sendMsg(Message m) throws RemoteException;

public void leaveRoom(String u, String room) throws RemoteException;

} 
