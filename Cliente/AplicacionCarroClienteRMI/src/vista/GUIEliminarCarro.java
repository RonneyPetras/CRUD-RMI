
package vista;

import controlador.IServicioCarro;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carro;
import javax.swing.JOptionPane;


public class GUIEliminarCarro extends javax.swing.JFrame {

    private IServicioCarro controladorCarro;
    
    public GUIEliminarCarro() {
        initComponents();
    }
    
    public GUIEliminarCarro(IServicioCarro controladorCarro) {
        initComponents();
        this.controladorCarro = controladorCarro;
    }

    public void preencheCamposPelaMarca(){
        if(!txtPlaca.getText().equals("")){
            try {
                Carro carro = controladorCarro.buscarCarroPorPlaca(txtPlaca.getText());
                this.txtPlaca.setText(carro.getPlaca());
                this.lbModelo.setText(carro.getModelo());
                this.lbColor.setText(carro.getColor());
            } catch (RemoteException ex) {
                Logger.getLogger(GUIEliminarCarro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPlaca = new javax.swing.JTextField();
        lbModelo = new javax.swing.JLabel();
        lbColor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar");

        lbModelo.setText(" ");

        lbColor.setText(" ");

        jLabel3.setText("Placa");

        jLabel4.setText("Modelo");

        jLabel5.setText("Color");

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbModelo)
                            .addComponent(lbColor))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbModelo)
                    .addComponent(jLabel4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbColor)
                        .addComponent(jLabel5))
                    .addComponent(btnEliminar))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.preencheCamposPelaMarca();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            if(this.controladorCarro.hayEseCarro(txtPlaca.getText())){
                this.controladorCarro.removerCarroPorPlaca(this.txtPlaca.getText());
                txtPlaca.setText("");
                lbModelo.setText("");
                lbColor.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "Carro no existe!", "Erro",3);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GUIEliminarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables


}
