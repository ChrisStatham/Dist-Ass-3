import java.rmi.*;

public interface MessageInterface extends Remote {

public String say() throws RemoteException;

public String to() throws RemoteException;

}
