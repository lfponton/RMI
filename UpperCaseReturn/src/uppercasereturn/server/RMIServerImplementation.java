package uppercasereturn.server;

import uppercasereturn.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImplementation implements UpperCaseServer
{
  public RMIServerImplementation() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
  }
  @Override public String toUpperCase(String str) throws RemoteException
  {
    return str.toUpperCase();
  }
}
