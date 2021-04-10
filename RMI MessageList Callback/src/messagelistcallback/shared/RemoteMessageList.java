package messagelistcallback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
  void addMessage(String msg, ReplyTo who) throws RemoteException;
}
