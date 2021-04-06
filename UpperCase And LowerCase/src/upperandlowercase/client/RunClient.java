package upperandlowercase.client;

import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    System.setProperty("java.security.policy", "all.policy");
    if (System.getSecurityManager() == null)
    {
      System.setSecurityManager(new SecurityManager());
    }
    RMIClient client = new RMIClient();
    client.startClient();

    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.println("Request? > ");
      String request = in.nextLine();
      if (request.equalsIgnoreCase("exit"))
      {
        break;
      }
      System.out.print("Input > ");
      String line = in.nextLine();

      try
      {
        String result;
        if (request.equalsIgnoreCase("lowercase"))
        {
          result = client.toLowerCase(line);
        }
        else if (request.equalsIgnoreCase("uppercase"))
        {
          result = client.toUpperCase(line);
        }
        else
        {
          result = "Could not understand the request. Please, try again.";
        }
        System.out.println("Result > " + result);
      }
      catch (Exception e)
      {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
