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
import logica.ListadoTercerosLogica;
import modelo.Listadoterceros;

/**
 *
 * @author Usuario
 */
public class consultaTercerosPanel extends javax.swing.JPanel {

    /**
     * Creates new form consultaTercerosPanel
     */
    vistaPrincipal frame; // instancia frame del frame principal
    DefaultTableModel modelo;
    private Listadoterceros listadoTerceros;
    private ListadoTercerosLogica listadoTercerosLogica;
    private List<Listadoterceros> listaTerceros;
    private List<Listadoterceros> listaTercerosAux;
    public consultaTercerosPanel(vistaPrincipal frame) {
        this.frame = frame; // la instancia del frame principal la paso a una instancia en esta clase para poder usar los metodos del frame principal
        listaTerceros = new ArrayList<Listadoterceros>();
        listadoTercerosLogica = new ListadoTercerosLogica();
        initComponents();
        setBackground(Color.white);
        ComboBoxBuscarTipo.removeAllItems();
        ComboBoxBuscarTipo.addItem("Todos");
        ComboBoxBuscarTipo.addItem("Cliente");
        ComboBoxBuscarTipo.addItem("Proveedor");
        ComboBoxBuscarTipo.addItem("Otros");
        listaTerceros = listadoTercerosLogica.listarTerceros();
        llenarTablaTerceros(listaTerceros);
    }
    
    public void llenarTablaTerceros(List<Listadoterceros> terceros){
        List<Listadoterceros> lista;
        lista = terceros;
        setTabla(lista);
    }
    
    public void setTabla(List<Listadoterceros> tercerosLista){
        modelo =  (DefaultTableModel) tableTerceros.getModel();
        
        int size = modelo.getRowCount();
        for(int i=0; i < size; i++){
            modelo.removeRow(0);
        }
        String aux[];
        for(int j=0;j< tercerosLista.size();j++){
            aux = new String[6];
            aux[0] = String.valueOf(tercerosLista.get(j).getId());
            aux[1] = tercerosLista.get(j).getTipo();
            aux[2] = tercerosLista.get(j).getCconit();
            aux[3] = tercerosLista.get(j).getNombre();
            aux[4] = tercerosLista.get(j).getDireccion();
            aux[5] = tercerosLista.get(j).getTelefono();
            
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
        labelTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBusquedaID = new javax.swing.JTextField();
        txtBusquedaIdentificacion = new javax.swing.JTextField();
        btnBusquedaID = new javax.swing.JButton();
        btnBusquedaIdentificacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTerceros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBusquedaNombre = new javax.swing.JTextField();
        btnBusquedaNombre = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxBuscarTipo = new javax.swing.JComboBox<>();
        btnBuscarTipo = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTitulo.setText("Consulta listado de terceros");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar ID que comiencen por:");

        jLabel4.setText("Buscar N° Identificación que comience por:");

        btnBusquedaID.setText("Buscar");
        btnBusquedaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaIDActionPerformed(evt);
            }
        });

        btnBusquedaIdentificacion.setText("Buscar");
        btnBusquedaIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaIdentificacionActionPerformed(evt);
            }
        });

        tableTerceros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "N° Identificación", "Nombre", "Direccion", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableTerceros);

        jLabel5.setText("Buscar Nombre que comience por:");

        txtBusquedaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaNombreActionPerformed(evt);
            }
        });

        btnBusquedaNombre.setText("Buscar");
        btnBusquedaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaNombreActionPerformed(evt);
            }
        });

        jLabel6.setText("Buscar por tipo:");

        ComboBoxBuscarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscarTipo.setText("Buscar");
        btnBuscarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnVolver)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelTitulo)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusquedaIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusquedaIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBusquedaID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBusquedaID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ComboBoxBuscarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(labelTitulo)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBusquedaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaID)
                    .addComponent(jLabel6)
                    .addComponent(ComboBoxBuscarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarTipo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBusquedaIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaIdentificacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBusquedaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusquedaNombre))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        frame.swap(5); // hace el llamado al panel de consultas
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBusquedaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaIDActionPerformed
        // TODO add your handling code here:
        listaTerceros = new ArrayList<Listadoterceros>();
        listaTercerosAux = new ArrayList<Listadoterceros>();
        listadoTercerosLogica = new ListadoTercerosLogica();
        listaTerceros = listadoTercerosLogica.listarTerceros();
        if(txtBusquedaID.getText()==""){
          listaTercerosAux = listaTerceros;
        }
        else{
            for(int i=0;i<=listaTerceros.size()-1;i++){
                if(String.valueOf(listaTerceros.get(i).getId()).startsWith(txtBusquedaID.getText())){
                    listaTercerosAux.add(listaTerceros.get(i));
                }
            }
        }
        llenarTablaTerceros(listaTercerosAux);
    }//GEN-LAST:event_btnBusquedaIDActionPerformed

    private void btnBusquedaIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaIdentificacionActionPerformed
        // TODO add your handling code here:
        listaTerceros = new ArrayList<Listadoterceros>();
        listaTercerosAux = new ArrayList<Listadoterceros>();
        listadoTercerosLogica = new ListadoTercerosLogica();
        listaTerceros = listadoTercerosLogica.listarTerceros();
        String identificacionObj = "";
        String identificacionCampo = "";
        if(txtBusquedaIdentificacion.getText()==""){
          listaTercerosAux = listaTerceros;
        }
        else{
            for(int i=0;i<=listaTerceros.size()-1;i++){
                identificacionObj = listaTerceros.get(i).getCconit();
                identificacionCampo = txtBusquedaIdentificacion.getText();
                //System.out.println("texto del objeto: "+identificacionObj+" --- "+"Texto del campo:" +identificacionCampo);
                if(identificacionObj.startsWith(identificacionCampo)){
                    listaTercerosAux.add(listaTerceros.get(i));
                }
                else{
                    //System.out.println("No cumplio con busqueda por identificacion");               
                }
            }
        }
        llenarTablaTerceros(listaTercerosAux);
    }//GEN-LAST:event_btnBusquedaIdentificacionActionPerformed

    private void txtBusquedaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaNombreActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtBusquedaNombreActionPerformed

    private void btnBusquedaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaNombreActionPerformed
        // TODO add your handling code here:
        listaTerceros = new ArrayList<Listadoterceros>();
        listaTercerosAux = new ArrayList<Listadoterceros>();
        listadoTercerosLogica = new ListadoTercerosLogica();
        listaTerceros = listadoTercerosLogica.listarTerceros();
       
        if(txtBusquedaNombre.getText()==""){
          listaTercerosAux = listaTerceros;
        }
        else{
            for(int i=0;i<=listaTerceros.size()-1;i++){
                if(listaTerceros.get(i).getNombre().startsWith(txtBusquedaNombre.getText())){
                    listaTercerosAux.add(listaTerceros.get(i));
                }
                else{
                    //System.out.println("No cumplio con busqueda por nombre");
                    //listaTercerosAux = listaTerceros;
                }
            }
        }
        llenarTablaTerceros(listaTercerosAux);
    }//GEN-LAST:event_btnBusquedaNombreActionPerformed

    private void btnBuscarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTipoActionPerformed
        // TODO add your handling code here:
        listaTerceros = new ArrayList<Listadoterceros>();
        listaTercerosAux = new ArrayList<Listadoterceros>();
        listadoTercerosLogica = new ListadoTercerosLogica();
        listaTerceros = listadoTercerosLogica.listarTerceros();
        String tipocombox = ComboBoxBuscarTipo.getSelectedItem().toString();
        System.out.println("Combox tipo: "+tipocombox);
        String tipobj = "";
        int Nocumplio = 0;
        for(int i=0;i<=listaTerceros.size()-1;i++){
            tipobj = listaTerceros.get(i).getTipo();
            System.out.println("tipo del objeto: "+tipobj);
            if(tipobj.startsWith(tipocombox)) {
                listaTercerosAux.add(listaTerceros.get(i));
            }
            else{
                 //System.out.println("No cumplio con busqueda por tipo");
                 Nocumplio += 1;
                 
            }
        }
        if( Nocumplio == listaTerceros.size() ){
            listaTercerosAux = listaTerceros;
        }
        Nocumplio = 0;
        llenarTablaTerceros(listaTercerosAux);
        
    }//GEN-LAST:event_btnBuscarTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxBuscarTipo;
    private javax.swing.JButton btnBuscarTipo;
    private javax.swing.JButton btnBusquedaID;
    private javax.swing.JButton btnBusquedaIdentificacion;
    private javax.swing.JButton btnBusquedaNombre;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JTable tableTerceros;
    private javax.swing.JTextField txtBusquedaID;
    private javax.swing.JTextField txtBusquedaIdentificacion;
    private javax.swing.JTextField txtBusquedaNombre;
    // End of variables declaration//GEN-END:variables
}
