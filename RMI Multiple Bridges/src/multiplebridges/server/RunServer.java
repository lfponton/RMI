package multiplebridges.server;

import multiplebridges.shared.IStringChangingServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    IStringChangingServer server = new StringChangingServer();
    registry.bind("Server", server);
    System.out.println("Server started.");
  }
}
