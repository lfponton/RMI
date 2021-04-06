package uppercasecallback.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RMIClient client = new RMIClient();
    client.startClient();

    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.print("Input > ");
      String line = in.nextLine();


      if (line.equalsIgnoreCase("exit"))
      {
        break;
      }
      String result = null;
      try
      {
        client.toUpperCase(line);
      }
      catch (Exception e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
