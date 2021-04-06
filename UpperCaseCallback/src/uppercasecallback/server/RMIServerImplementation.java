package uppercasecallback.server;

import uppercasecallback.shared.UpperCaseClient;
import uppercasecallback.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImplementation implements UpperCaseServer
{
  public RMIServerImplementation() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void toUpperCase(String str, UpperCaseClient client)
      throws RemoteException
  {
    String result = str.toUpperCase();
    // assume heavy calculation
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException ignored)
    {
    }
    try
    {
      client.upperCaseResult(result);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
