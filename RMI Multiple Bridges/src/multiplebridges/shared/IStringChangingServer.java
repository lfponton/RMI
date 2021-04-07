package multiplebridges.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStringChangingServer extends Remote
{
  IToUpperCase getUpperCase() throws RemoteException;
  IToRandomCase getToRandomCase() throws RemoteException;
}
