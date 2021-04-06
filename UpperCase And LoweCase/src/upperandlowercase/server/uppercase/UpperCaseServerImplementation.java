package upperandlowercase.server.uppercase;

import upperandlowercase.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpperCaseServerImplementation implements UpperCaseServer
{
  public UpperCaseServerImplementation() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }
  @Override public String toUpperCase(String str) throws RemoteException
  {
    return str.toUpperCase();
  }
}
