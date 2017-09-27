package modelo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IActualizableCarro extends Remote{
    public void cambio() throws RemoteException;
}
