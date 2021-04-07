package printingmessages.server;

import printingmessages.shared.TextServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITextServer implements TextServer
{
  public RMITextServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }
  @Override public void printText(String text)
  {
    System.out.println(text);
  }
}
