package messagelistcallback.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RemoteMessageClient client = new RemoteMessageClient();
    client.startClient();
    Scanner keyboard = new Scanner(System.in);

    while (true)
    {
      System.out.print("Enter a message > ");
      client.toServer(keyboard.nextLine());
    }
  }
}
