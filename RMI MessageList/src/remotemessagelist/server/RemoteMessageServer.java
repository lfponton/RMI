package remotemessagelist.server;

import remotemessagelist.shared.RemoteMessageList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList
{
  private ArrayList<String> list = new ArrayList<>();

  public RemoteMessageServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public synchronized void addMessage(String msg) throws RemoteException
  {
    list.add(msg);
  }

  @Override public String getMessageList() throws RemoteException
  {
    String str = "";
    for (String msg : list)
    {
      str += msg + "\n";
    }
    return str;
  }

  @Override public int size() throws RemoteException
  {
    return list.size();
  }
}
