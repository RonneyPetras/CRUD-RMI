
package vista;

import controlador.IServicioCarro;
import java.rmi.RemoteException;
import modelo.Carro;
import modelo.IActualizableCarro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GUIActualizarCarro extends javax.swing.JFrame implements IActualizableCarro{

    IServicioCarro controladorCarro;
    Carro carro;
    
    public GUIActualizarCarro(IServicioCarro controladorCarro) {
        initComponents();
        this.controladorCarro = controladorCarro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jButton1 = new javax.swing.JButton();
        txtPlaca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Actualizar"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Placa:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("Color:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtColor)
                                    .addComponent(txtModelo)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.editarCarro();
    }//GEN-LAST:event_jButton2ActionPerformed
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultaCarro();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void cambio() {
        try {
            this.carro = controladorCarro.buscarCarroPorPlaca(txtPlaca.getText());
        } catch (RemoteException ex) {
            Logger.getLogger(GUIActualizarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.txtPlaca.setText(this.carro.getPlaca());
        this.txtPlaca.setText(this.carro.getPlaca());
        this.txtModelo.setText(this.carro.getModelo());
        this.txtColor.setText(this.carro.getColor());
    }
    
    public void consultaCarro(){
       if(txtPlaca.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nombre vazio");
            borrarCampos();
        }else try {
            if(this.controladorCarro.buscarCarroPorPlaca(txtPlaca.getText()) == null){
                JOptionPane.showMessageDialog(null, "Carro no encuentrado!");
                borrarCampos();
            }else{
                try {
                    this.carro = this.controladorCarro.buscarCarroPorPlaca(txtPlaca.getText());
                } catch (RemoteException ex) {
                    Logger.getLogger(GUIActualizarCarro.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.txtPlaca.setText(this.carro.getPlaca());
                this.txtPlaca.setText(this.carro.getPlaca());
                this.txtModelo.setText(this.carro.getModelo());
                this.txtColor.setText(this.carro.getColor());
            }
       } catch (RemoteException ex) {
           Logger.getLogger(GUIActualizarCarro.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public void editarCarro(){
        String placa = this.txtPlaca.getText();
        String modelo = this.txtModelo.getText();
        String color = this.txtColor.getText();

        try {
            this.controladorCarro.editarCarro(new Carro(placa, modelo, color));
        } catch (RemoteException ex) {
            Logger.getLogger(GUIActualizarCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarCampos(){
        this.txtPlaca.setText("");
        this.txtModelo.setText("");
        this.txtColor.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
