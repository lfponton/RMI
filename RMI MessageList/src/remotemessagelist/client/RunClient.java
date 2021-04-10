package remotemessagelist.client;

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

    while (true)
    {

      System.out.println("Enter 5 messages:");
      Scanner keyboard = new Scanner(System.in);
      for (int i = 0; i < 5; i++)
      {
        System.out.print("> ");
        client.addMessage(keyboard.nextLine());
      }
      System.out.println(client.getMessageList());
      System.out.println("Done!");
    }
  }
}
