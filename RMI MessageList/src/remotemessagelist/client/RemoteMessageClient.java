package remotemessagelist.client;

import remotemessagelist.shared.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageClient
{
  private RemoteMessageList server;

  public RemoteMessageClient()
  {}

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RemoteMessageList) registry.lookup("Server");
  }

  public void addMessage(String msg) {
    try
    {
      server.addMessage(msg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not connect to the server");
    }
  }

  public String getMessageList() {
    String list = null;
    try
    {
      list =  server.getMessageList();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not connect to the server");
    }
    return list;
  }

  public int size() {
    int size = 0;
    try
    {
      size = server.size();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not connect to the server");
    }
    return size;
  }
}
