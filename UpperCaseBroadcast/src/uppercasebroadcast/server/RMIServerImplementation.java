package uppercasebroadcast.server;

import uppercasebroadcast.shared.UpperCaseClient;
import uppercasebroadcast.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImplementation implements UpperCaseServer
{

  private List<UpperCaseClient> clientsForBroadcast;

  public RMIServerImplementation() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
    clientsForBroadcast = new ArrayList<>();
  }

  @Override public String toUpperCase(String str, UpperCaseClient client)
  {
    String result = str.toUpperCase();
    // assume heavy calculation
    try
    {
      Thread.sleep(1000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    updateClients(result, client);

    return result;
  }

  private void updateClients(String result, UpperCaseClient clientNotToBroadcastTo)
  {
    for(UpperCaseClient client : clientsForBroadcast)
    {
      if (client.equals(clientNotToBroadcastTo)) continue;

      try
      {
        client.update(result);
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void registerClient(UpperCaseClient clientToRegister)
  {
    clientsForBroadcast.add(clientToRegister);
  }
}
