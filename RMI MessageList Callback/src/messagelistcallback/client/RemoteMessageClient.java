package messagelistcallback.client;

import messagelistcallback.shared.RemoteMessageList;
import messagelistcallback.shared.ReplyTo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient implements ReplyTo
{
  private RemoteMessageList server;

  public RemoteMessageClient() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RemoteMessageList) registry.lookup("Server");
  }

  @Override public void replyMessage(String msg) throws RemoteException
  {
    System.out.println(msg);
  }

  public void toServer(String msg) throws RemoteException
  {
    server.addMessage(msg, this);
  }
}
