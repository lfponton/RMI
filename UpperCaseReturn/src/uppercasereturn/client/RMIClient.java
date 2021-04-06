package uppercasereturn.client;

import uppercasereturn.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient
{
  private UpperCaseServer server;

  public RMIClient() {}

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (UpperCaseServer) registry.lookup("Server");
  }

  public String toUpperCase(String argument)
  {
    String result = null;

    try
    {
      result = server.toUpperCase(argument);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server.");
      // The RunTimeException is standard unlike the RemoteException, which is
      // specific to RMI. This way the exception will not "bleed" through the
      // system (e.g. through a MVVM).
    }
    return result;
  }
}
