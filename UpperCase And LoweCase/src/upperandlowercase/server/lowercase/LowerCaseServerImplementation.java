package upperandlowercase.server.lowercase;

import upperandlowercase.shared.LowerCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LowerCaseServerImplementation implements LowerCaseServer
{
  public LowerCaseServerImplementation() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toLowerCase(String str)
  {
    return str.toLowerCase();
  }
}
