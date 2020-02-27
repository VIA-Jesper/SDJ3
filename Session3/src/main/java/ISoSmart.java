import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISoSmart extends Remote
{
  String findMoM(String key) throws RemoteException;
}
