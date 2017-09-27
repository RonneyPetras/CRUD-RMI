package vista;

import controlador.IServicioCarro;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import modelo.IActualizableCarro;

public class ViewActualizarCarro extends UnicastRemoteObject implements IActualizableCarro, Serializable{

    private IServicioCarro model;
    private transient GUIActualizarCarro gui;
   
    public ViewActualizarCarro(IServicioCarro ser) throws RemoteException{
        this.model = ser;
        this.model.addVista(this);
        this.gui = new GUIActualizarCarro(model);
        this.gui.setVisible(true);
        
    }

    @Override
    public void cambio() throws RemoteException {
        gui.cambio();
    }
    
}
