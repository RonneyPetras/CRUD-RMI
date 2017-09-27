package controlador;

import javax.swing.JOptionPane;
import java.util.*;
import java.rmi.server.*;
import java.rmi.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

public class ServicioCarro extends UnicastRemoteObject implements IServicioCarro {

    private static ArrayList<Carro> carros = new ArrayList<Carro>();
    private ArrayList<IActualizableCarro> ventanas;

    public ServicioCarro() throws RemoteException {
        this.ventanas = new ArrayList<IActualizableCarro>();
    }

    @Override
    public ArrayList<Carro> getCarros() throws RemoteException {
        return this.carros;
    }

    @Override
    public void addVista(IActualizableCarro gui) throws RemoteException {
        this.ventanas.add(gui);
    }

    /*Llama os metodos que inserta o carro en lo BD y en la ArrayList*/
    @Override
    public void insertarCarro(Carro carro) {
        try {
            if (carro == null || !(this.hayEseCarro(carro.getPlaca()))) {
                ServicioCarro.carros.add(carro);
                this.cambio();
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un carro con esa placa");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServicioCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean hayEseCarro(String placa) throws RemoteException {
        for (Carro carro : ServicioCarro.carros) {
            if (carro.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Carro buscarCarroPorPlaca(String placa) throws RemoteException {
        for (Carro carro : this.carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    @Override
    public void editarCarro(Carro carroP) throws RemoteException {
        String placa = carroP.getPlaca();

        if (this.hayEseCarro(placa)) {
            String modelo = carroP.getModelo();
            String color = carroP.getColor();

            for (Carro carro : ServicioCarro.carros) {
                if (carro.getPlaca().equals(placa)) {
                    carro.setColor(color);
                    carro.setModelo(modelo);
                    carro.setPlaca(placa);
                }
            }
            this.cambio();
        } else {
            JOptionPane.showMessageDialog(null, "Carro no existe!");
        }

    }

    @Override
    public void removerCarroPorPlaca(String placa) throws RemoteException {

        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getPlaca().equals(placa)) {
                carros.remove(i);
            }else{
                JOptionPane.showMessageDialog(null, "Carro no existe");
            }
        }

        this.cambio();
    }

    public void cambio() {
        System.out.println("cambiou");
        for (IActualizableCarro ventana : ventanas) {
            if (ventana instanceof IActualizableCarro) {
                try {
                    ventana.cambio();
                } catch (RemoteException ex) {
                    Logger.getLogger(ServicioCarro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
