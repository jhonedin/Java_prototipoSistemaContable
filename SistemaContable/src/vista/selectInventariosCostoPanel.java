/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import logica.MaestroinventariocompletoLogica;
import modelo.Maestroinventariocompleto;

/**
 *
 * @author Jhon
 */
public class selectInventariosCostoPanel extends javax.swing.JPanel {

    /**
     * Creates new form consultaInventariosPanel
     */
    vistaPrincipal frame; // instancia frame del frame principal
    DefaultTableModel modelo;
    private Maestroinventariocompleto maestroInventarioCompleto;
    private MaestroinventariocompletoLogica maestroInventarioCompletoLogica;
    private List<Maestroinventariocompleto> listaMaestroinventariocompleto;
    private List<Maestroinventariocompleto> listaMaestroinventariocompletoAux;
    private List<Maestroinventariocompleto> listaMaestroinventariocompletoSeleccionable;
    
    public selectInventariosCostoPanel(vistaPrincipal frame) {
        this.frame = frame; // la instancia del frame principal la paso a una instancia en esta clase para poder usar los metodos del frame principal
        listaMaestroinventariocompleto = new ArrayList<Maestroinventariocompleto>();
        maestroInventarioCompleto = new Maestroinventariocompleto(); 
        maestroInventarioCompletoLogica = new MaestroinventariocompletoLogica();
        listaMaestroinventariocompletoSeleccionable = new ArrayList<Maestroinventariocompleto>();
        
        initComponents();
        setBackground(Color.white);
        listaMaestroinventariocompleto = maestroInventarioCompletoLogica.listarMaestroInventarioCompleto();
        llenarTablaIngresos(listaMaestroinventariocompleto);
    }
    
    public void llenarTablaIngresos(List<Maestroinventariocompleto> puc){
        List<Maestroinventariocompleto> lista;
        lista = puc;
        setTabla(lista);
    }
    
    public void setTabla(List<Maestroinventariocompleto> micLista){
        modelo =  (DefaultTableModel) tableMIC.getModel();
        
        int size = modelo.getRowCount();
        for(int i=0; i < size; i++){
            modelo.removeRow(0);
        }
        String aux[];
        for(int j=0;j< micLista.size();j++){
            aux = new String[2];
            aux[0] = micLista.get(j).getCodigo();
            aux[1] = micLista.get(j).getDescripcion();
            modelo.addRow(aux);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBusquedaCodigo = new javax.swing.JTextField();
        txtBusquedaDescripcion = new javax.swing.JTextField();
        btnBusquedaCodigo = new javax.swing.JButton();
        btnBusquedaDescripcion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMIC = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Consulta de inventario");

        jLabel2.setText("Buscar codigos que comiencen por: ");

        jLabel3.setText("Buscar descripción que comience por:");

        btnBusquedaCodigo.setText("Buscar");
        btnBusquedaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaCodigoActionPerformed(evt);
            }
        });

        btnBusquedaDescripcion.setText("Buscar");
        btnBusquedaDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaDescripcionActionPerformed(evt);
            }
        });

        tableMIC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMIC);

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusquedaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBusquedaDescripcion)
                            .addComponent(btnBusquedaCodigo)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSeleccionar)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusquedaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaCodigo))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBusquedaDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaDescripcion))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeleccionar)
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        listaMaestroinventariocompleto = new ArrayList<Maestroinventariocompleto>();
        listaMaestroinventariocompletoAux = new ArrayList<Maestroinventariocompleto>();
        maestroInventarioCompleto = new Maestroinventariocompleto(); 
        maestroInventarioCompletoLogica = new MaestroinventariocompletoLogica();
        listaMaestroinventariocompleto = maestroInventarioCompletoLogica.listarMaestroInventarioCompleto();
        if(listaMaestroinventariocompletoSeleccionable.isEmpty()){ // esta es para cuando no se hayan filtrado la lista
            int filaSelect = 0; 
            filaSelect = tableMIC.getSelectedRow();
            String idSelect;
            idSelect = listaMaestroinventariocompleto.get(filaSelect).getCodigo();
            maestroInventarioCompleto = maestroInventarioCompletoLogica.buscarInventarioxcodigo(idSelect);
            frame.setInventarioIngreso(maestroInventarioCompleto);
            frame.swap(2);       
        }
        else{
            int filaSelect = 0; 
            filaSelect = tableMIC.getSelectedRow();
            String idSelect;
            idSelect = listaMaestroinventariocompletoSeleccionable.get(filaSelect).getCodigo();
            maestroInventarioCompleto = maestroInventarioCompletoLogica.buscarInventarioxcodigo(idSelect);
            frame.setInventarioIngreso(maestroInventarioCompleto);
            frame.swap(2);
        }
        
        frame.swap(2); // hace el llamado al panel de registro de costo
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBusquedaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaCodigoActionPerformed
        // TODO add your handling code here:
        listaMaestroinventariocompleto = new ArrayList<Maestroinventariocompleto>();
        listaMaestroinventariocompletoAux = new ArrayList<Maestroinventariocompleto>();
        maestroInventarioCompleto = new Maestroinventariocompleto(); 
        maestroInventarioCompletoLogica = new MaestroinventariocompletoLogica();
        listaMaestroinventariocompleto = maestroInventarioCompletoLogica.listarMaestroInventarioCompleto();
        if(txtBusquedaCodigo.getText()==""){
          listaMaestroinventariocompletoAux = listaMaestroinventariocompleto;
        }
        else{
            for(int i=0;i<=listaMaestroinventariocompleto.size()-1;i++){
                maestroInventarioCompleto = listaMaestroinventariocompleto.get(i);
                if(maestroInventarioCompleto.getCodigo().startsWith(txtBusquedaCodigo.getText())){
                    listaMaestroinventariocompletoAux.add(maestroInventarioCompleto);
                }
            }
        }
        listaMaestroinventariocompletoSeleccionable = listaMaestroinventariocompletoAux;
        llenarTablaIngresos(listaMaestroinventariocompletoAux);
    }//GEN-LAST:event_btnBusquedaCodigoActionPerformed

    private void btnBusquedaDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaDescripcionActionPerformed
        // TODO add your handling code here:
        listaMaestroinventariocompleto = new ArrayList<Maestroinventariocompleto>();
        listaMaestroinventariocompletoAux = new ArrayList<Maestroinventariocompleto>();
        maestroInventarioCompleto = new Maestroinventariocompleto(); 
        maestroInventarioCompletoLogica = new MaestroinventariocompletoLogica();
        listaMaestroinventariocompleto = maestroInventarioCompletoLogica.listarMaestroInventarioCompleto();
        if(txtBusquedaDescripcion.getText()==""){
          listaMaestroinventariocompletoAux = listaMaestroinventariocompleto;
        }
        else{
            for(int i=0;i<=listaMaestroinventariocompleto.size()-1;i++){
                maestroInventarioCompleto = listaMaestroinventariocompleto.get(i);
                if(maestroInventarioCompleto.getDescripcion().startsWith(txtBusquedaDescripcion.getText())){
                    listaMaestroinventariocompletoAux.add(maestroInventarioCompleto);
                }
            }
        }
        listaMaestroinventariocompletoSeleccionable = listaMaestroinventariocompletoAux;
        llenarTablaIngresos(listaMaestroinventariocompletoAux);
        
    }//GEN-LAST:event_btnBusquedaDescripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaCodigo;
    private javax.swing.JButton btnBusquedaDescripcion;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMIC;
    private javax.swing.JTextField txtBusquedaCodigo;
    private javax.swing.JTextField txtBusquedaDescripcion;
    // End of variables declaration//GEN-END:variables
}