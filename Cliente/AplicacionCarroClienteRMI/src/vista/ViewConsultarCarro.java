
package vista;

import controlador.IServicioCarro;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import modelo.IActualizableCarro;

public class ViewConsultarCarro extends UnicastRemoteObject implements IActualizableCarro, Serializable{
    private IServicioCarro model;
    private transient GUIConsultarCarro gui;

    public ViewConsultarCarro(IServicioCarro ser) throws RemoteException{
        this.model = ser;
        this.model.addVista(this);
        this.gui = new GUIConsultarCarro(model);
        this.gui.setVisible(true);
    }

    @Override
    public void cambio() throws RemoteException {
        gui.cambio();
    }
    
    
}
