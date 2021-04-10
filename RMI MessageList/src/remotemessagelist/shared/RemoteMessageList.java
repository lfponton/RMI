package remotemessagelist.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote
{
  void addMessage(String msg) throws RemoteException;
  String getMessageList() throws RemoteException;
  int size() throws RemoteException;
}
