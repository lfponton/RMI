package messagelistcallback.server;

import messagelistcallback.shared.RemoteMessageList;
import messagelistcallback.shared.ReplyTo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList
{
  private ArrayList<String> list = new ArrayList<>();

  public RemoteMessageServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
  }
  @Override public void addMessage(String msg, ReplyTo client)
      throws RemoteException
  {
    list.add(msg);
    client.replyMessage(msg);
    client.replyMessage("Thank You");
  }
}
