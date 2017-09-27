package vista;

import controlador.IServicioCarro;
import modelo.Carro;
import modelo.IActualizableCarro;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUIConsultarCarro extends javax.swing.JFrame implements IActualizableCarro{

    IServicioCarro controladorCarro;
    
    public GUIConsultarCarro(IServicioCarro controladorCarro) {
        initComponents();
        this.controladorCarro = controladorCarro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbPlaca = new javax.swing.JLabel();
        lbModelo = new javax.swing.JLabel();
        lbColor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar");

        jLabel1.setText("Placa:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Color:");

        lbPlaca.setText("   ");

        lbModelo.setText("    ");

        lbColor.setText("    ");

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(27, 27, 27))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbColor)
                            .addComponent(lbModelo)
                            .addComponent(lbPlaca))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbPlaca))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbModelo)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbColor))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.consultarCarro();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void consultarCarro() {
        String placa = txtBuscar.getText();
        if(placa.equals("")){
            JOptionPane.showMessageDialog(null, "Nombre vazio");
            this.borrarCampos();
        }else try {
            if(controladorCarro.hayEseCarro(placa)){
                Carro carro = controladorCarro.buscarCarroPorPlaca(txtBuscar.getText());
                this.lbPlaca.setText(carro.getPlaca());
                this.lbModelo.setText(carro.getModelo());
                this.lbColor.setText(carro.getColor());
            }else{
                JOptionPane.showMessageDialog(null, "Carro no encuentrado!");
                this.borrarCampos();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(GUIConsultarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarCampos(){
        this.lbPlaca.setText("");
        this.lbModelo.setText("");
        this.lbColor.setText("");
    }
    
    @Override
    public void cambio() {
        try {
            Carro carro = controladorCarro.buscarCarroPorPlaca(txtBuscar.getText());
            this.lbPlaca.setText(carro.getPlaca());
            this.lbModelo.setText(carro.getModelo());
            this.lbColor.setText(carro.getColor());
        } catch (RemoteException ex) {
            Logger.getLogger(GUIConsultarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JLabel lbPlaca;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    
}
