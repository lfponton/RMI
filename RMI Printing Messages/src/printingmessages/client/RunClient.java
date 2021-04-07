package printingmessages.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    TextClient client = new TextClient();
    Scanner in = new Scanner(System.in);
    System.out.print("Enter some text > ");
    String text = in.nextLine();
    client.sendText(text);
  }
}
