package upperandlowercase.client;

import upperandlowercase.shared.Server;
import upperandlowercase.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient
{
  private Server server;

  public RMIClient() {}

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (Server) registry.lookup("Server");
  }

  public String toUpperCase(String argument)
  {
    try
    {
      return server.getUpperCaseServer().toUpperCase(argument);
      // another possibility is to create a field upperCaseServer and initialized
      // in startClient.
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server.");
    }
  }
  public String toLowerCase(String argument)
  {
    try
    {
      return server.getLowerCaseServer().toLowerCase(argument);
      // another possibility is to create a field upperCaseServer and initialized
      // in startClient.
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server.");
    }
  }

}
