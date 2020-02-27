import java.rmi.RemoteException;
import java.util.HashMap;

public class SoSmartImpl implements ISoSmart
{
  private HashMap<String, String> moms;

  public SoSmartImpl() {
    initMoms();
  }

  private void initMoms()
  {
    moms = new HashMap<String, String>();
    moms.put("Jesper", "Ducati");
  }

  public String findMoM(String key) throws RemoteException
  {
    return moms.get(key);
  }
}
