package multiplebridges.server;

import multiplebridges.server.torandomcase.ToRandomCase;
import multiplebridges.server.touppercase.ToUpperCase;
import multiplebridges.shared.IStringChangingServer;
import multiplebridges.shared.IToRandomCase;
import multiplebridges.shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer
{
  public StringChangingServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public IToUpperCase getUpperCase() throws RemoteException
  {
    return new ToUpperCase();
  }

  @Override public IToRandomCase getToRandomCase() throws RemoteException
  {
    return new ToRandomCase();
  }
}
