import java.rmi.*;

public interface ClientInterface extends Remote{

void recvMsg(Message m) throws RemoteException;

String getName() throws RemoteException;

}
