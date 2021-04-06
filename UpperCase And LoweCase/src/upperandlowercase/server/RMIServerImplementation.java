package upperandlowercase.server;

import upperandlowercase.server.lowercase.LowerCaseServerImplementation;
import upperandlowercase.server.uppercase.UpperCaseServerImplementation;
import upperandlowercase.shared.LowerCaseServer;
import upperandlowercase.shared.Server;
import upperandlowercase.shared.UpperCaseServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImplementation implements Server
{
  public RMIServerImplementation() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public UpperCaseServer getUpperCaseServer() throws RemoteException
  {
    return new UpperCaseServerImplementation();
  }

  @Override public LowerCaseServer getLowerCaseServer() throws RemoteException
  {
    return new LowerCaseServerImplementation();
  }
}
