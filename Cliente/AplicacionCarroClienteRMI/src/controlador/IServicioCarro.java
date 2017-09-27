
package controlador;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import modelo.Carro;
import modelo.IActualizableCarro;


public interface IServicioCarro extends Remote{
    
    public ArrayList<Carro> getCarros() throws RemoteException;
    public void addVista(IActualizableCarro gui) throws RemoteException;
    public boolean hayEseCarro(String placa) throws RemoteException;       
    public Carro buscarCarroPorPlaca(String placa) throws RemoteException;
    public void editarCarro(Carro carroP) throws RemoteException;
    public void removerCarroPorPlaca(String placa) throws RemoteException;
    public void insertarCarro(Carro carro) throws RemoteException;
    
}
