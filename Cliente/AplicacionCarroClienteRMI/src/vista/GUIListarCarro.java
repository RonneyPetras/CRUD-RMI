package vista;

import controlador.IServicioCarro;
import java.rmi.RemoteException;
import modelo.Carro;
import modelo.IActualizableCarro;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUIListarCarro extends javax.swing.JFrame implements IActualizableCarro{
    
    private IServicioCarro servCarro;
    
    public GUIListarCarro(IServicioCarro controladorCarro) {
        initComponents();
        this.servCarro = controladorCarro;
        this.cambio();
    }

    public void cambio() {
  
        try {
            ArrayList<Carro>  carros = this.servCarro.getCarros();
            String matriz [][] = new String[carros.size()] [3];
            for(int i=0; i<carros.size(); i++){
                matriz[i][0] = carros.get(i).getPlaca();
                matriz[i][1] = carros.get(i).getModelo();
                matriz[i][2] = carros.get(i).getColor();
            }
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String [] {
                    "Placa", "Modelo", "Color"
                }
            ));
        } catch (RemoteException ex) {
            Logger.getLogger(GUIListarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables


}
