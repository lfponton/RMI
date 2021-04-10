package multiplebridges.server.torandomcase;

import multiplebridges.shared.IToRandomCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToRandomCase implements IToRandomCase
{
  public ToRandomCase() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toRandomCase(String arg)
  {
    String result  = "";
    char[] charArray = arg.toCharArray();
    for (char c : charArray)
    {
      result +=
          Math.random() < 0.5 ? (c + "").toUpperCase() : (c + "").toLowerCase();
    }
    return result;
  }
}
