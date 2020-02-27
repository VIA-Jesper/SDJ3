import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Objects;

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
    moms.put("Joseph", "A Very Fancy Car");
  }

  public String findMoM(String key) throws RemoteException
  {
    String mom = moms.get(key);
    return Objects.requireNonNullElse(mom, "Name not found");
  }
}
