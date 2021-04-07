package printingmessages.client;

import printingmessages.shared.TextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TextClient
{
  private TextServer server;
  public TextClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (TextServer) registry.lookup("Server");
  }

  public void sendText(String text) throws RemoteException
  {
    server.printText(text);
  }
}
