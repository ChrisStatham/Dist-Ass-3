import java.rmi.*;

public interface ServerInterface extends Remote{

public void joinRoom(Client u, String room) throws RemoteException;

public void sendMessage(Client u,Message m) throws RemoteException;

public void leaveRoom(Client u, String room) throws RemoteException;

} 
