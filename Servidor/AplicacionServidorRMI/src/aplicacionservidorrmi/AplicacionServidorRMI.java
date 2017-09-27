/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionservidorrmi;

import controlador.ServicioCarro;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import controlador.IServicioCarro;

public class AplicacionServidorRMI {

    public static void main(String[] args) {
        //Direccion IP del equipo doonde se ejecute esta aplicacion Servidor
        String dbHost = "127.0.0.1";
        try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            //puerto donde recide el servidor (model)
            LocateRegistry.createRegistry(1099);
            
            IServicioCarro model = new ServicioCarro();
            
            Naming.rebind("//"+dbHost+"/AplicacionEstudiante", model);
            
            System.out.println("Objeto Model en el servidor...");
            
        }catch (Exception e) {
                System.out.println("Eror: " + e.getMessage());
        }
    }
    
}
