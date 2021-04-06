package uppercasecallback.client;

import uppercasecallback.shared.UpperCaseClient;
import uppercasecallback.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UpperCaseClient
{
  private UpperCaseServer server;

  public RMIClient() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (UpperCaseServer) registry.lookup("Server");
  }

  public void toUpperCase(String argument)
  {
    try
    {
      server.toUpperCase(argument, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server.");
      // The RunTimeException is standard unlike the RemoteException, which is
      // specific to RMI. This way the exception will not "bleed" through the
      // system (e.g. through a MVVM).
    }
  }

  @Override public void upperCaseResult(String result)
  {
    System.out.println("Result > " + result);
  }
}
