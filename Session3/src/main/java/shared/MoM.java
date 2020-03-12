package shared;

import java.io.Serializable;

public class MoM implements Serializable
{

  private String name;
  private String mom;

  public MoM(String name, String MoM) {
    this.name = name;
    this.mom = MoM;
  }

  public String getName()
  {
    return name;
  }

  public String getMom()
  {
    return mom;
  }
}
