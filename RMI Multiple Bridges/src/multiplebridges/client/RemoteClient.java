package multiplebridges.client;

import multiplebridges.shared.IStringChangingServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient
{
  private IStringChangingServer stringChangingServer;

  public RemoteClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost",  1099);
    stringChangingServer = (IStringChangingServer) registry.lookup("Server");
    System.out.println("Server started.");
  }

  public String changeToUpperCase(String arg) throws RemoteException
  {
    return stringChangingServer.getUpperCase().toUpperCase(arg);
  }

  public String changeToRandom(String arg) throws RemoteException
  {
    return stringChangingServer.getToRandomCase().toRandomCase(arg);
  }
}
