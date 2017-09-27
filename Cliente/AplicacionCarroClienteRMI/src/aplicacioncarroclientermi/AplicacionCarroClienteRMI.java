
package aplicacioncarroclientermi;

import controlador.IServicioCarro;
import java.rmi.Naming;
import vista.GUIPrincipal;

public class AplicacionCarroClienteRMI {

    public static void main(String[] args) {
        String rmiRegistryHost = "127.0.0.1";
        try {
            if (args.length > 0) {
                rmiRegistryHost = args[0];
            }

            IServicioCarro model = (IServicioCarro) Naming.lookup("//"
                    + rmiRegistryHost + "/AplicacionEstudiante");
            if (model == null) {
                System.out.println("Error... Cliente ");
                return;
            }
            GUIPrincipal gui = new GUIPrincipal(model);
            gui.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error... " + e);
        }
    }

}
