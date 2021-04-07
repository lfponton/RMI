package multiplebridges.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RemoteClient client = new RemoteClient();
    System.out.println("Hello");
    System.out.println(client.changeToRandom("Hello"));
    System.out.println(client.changeToRandom("Hello"));
    System.out.println(client.changeToRandom("Hello"));
    System.out.println(client.changeToRandom("Hello"));
    System.out.println(client.changeToUpperCase("End"));
  }
}
