/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JPanel;
import modelo.Puc;

/**
 *
 * @author Jhon
 */
public class vistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    JPanel panels[] = new JPanel[16]; // ir incrementando el valor de este arreglo en la medida que se van creando los paneles
    private int ingresosPorVenta = 0;
    private int costoProduccion = 0;
    private int utilidadBruta = 0;
    private String fechaInicial = "";
    private String fechaFinal = "";
    private Puc puc;
    private registroIngresoPanel panelRegistroIngresoAux;
    private registroCostoPanel panelRegistroCostoAux;
    private registroGastoPanel panelRegistroGastoAux;
    
    public vistaPrincipal() {
        
        opcionesPanel panelOpciones = new opcionesPanel(this); 
        panelOpciones.setBounds(0, 0, 900, 650);
        setResizable(false); // esto evita que el frame cambie de tamaño
        agregarPanel(0,panelOpciones); // Panel 0 - Panel Registro de ingresos
        panelOpciones.setVisible(true);
        ////////////////////
        
        registroIngresoPanel panelRegistroIngreso = new registroIngresoPanel(this); 
        panelRegistroIngreso.setBounds(0, 0, 900, 650);
        agregarPanel(1,panelRegistroIngreso); // Panel 1 - Panel Registro de ingresos
        panelRegistroIngreso.setVisible(false);
        panelRegistroIngresoAux = panelRegistroIngreso;
        ////////////////////
        
        registroCostoPanel panelRegistroCosto = new registroCostoPanel(this); 
        panelRegistroCosto.setBounds(0, 0, 900, 650);
        agregarPanel(2,panelRegistroCosto); // Panel 2 - Panel Registro de costo
        panelRegistroCosto.setVisible(false);
        panelRegistroCostoAux = panelRegistroCosto;
        ////////////////////
        
        registroGastoPanel panelRegistroGasto = new registroGastoPanel(this); 
        panelRegistroGasto.setBounds(0, 0, 900, 650);
        agregarPanel(3,panelRegistroGasto); // Panel 3 - Panel Registro de gastos
        panelRegistroGasto.setVisible(false);
        panelRegistroGastoAux = panelRegistroGasto;
        ////////////////////
        
        entradaSalidaPanel panelESInventario = new entradaSalidaPanel(this); 
        panelESInventario.setBounds(0, 0, 900, 650);
        agregarPanel(4,panelESInventario); // Panel 4 - Panel Entrada/Salida Inventarios
        panelESInventario.setVisible(false);
        ////////////////////
        
        consultasPanel panelConsultas = new consultasPanel(this); 
        panelConsultas.setBounds(0, 0, 900, 650);
        agregarPanel(5,panelConsultas); // Panel 5 - Panel Consultas
        panelConsultas.setVisible(false);
        ////////////////////
        
        consultaCuentasPUCPanel panelConsultaCuentasPUCPanel = new consultaCuentasPUCPanel(this); 
        panelConsultaCuentasPUCPanel.setBounds(0, 0, 900, 650);
        agregarPanel(6,panelConsultaCuentasPUCPanel); // Panel 6 - Panel Consultas
        panelConsultaCuentasPUCPanel.setVisible(false);
        ////////////////////
        consultaCentroCostoPanel panelConsultaCentroCosto = new consultaCentroCostoPanel(this); 
        panelConsultaCentroCosto.setBounds(0, 0, 900, 650);
        agregarPanel(7,panelConsultaCentroCosto); // Panel 7 - Panel Consultas
        panelConsultaCentroCosto.setVisible(false);
        ////////////////////
        consultaReporteEstadoResultados panelResporteEstadoResultados = new consultaReporteEstadoResultados(this); 
        panelResporteEstadoResultados.setBounds(0, 0, 900, 650);
        agregarPanel(8,panelResporteEstadoResultados); // Panel 8 - Panel Reporte Estados de Resultados
        panelResporteEstadoResultados.setVisible(false);
        
        reporteERPanel panelGeneraER = new reporteERPanel(this); 
        panelGeneraER.setBounds(0, 0, 900, 650);
        agregarPanel(9,panelGeneraER); // Panel 9 - Panel de calcular el estado de resultados
        panelGeneraER.setVisible(false);
        
        consultaTercerosPanel panelConsultaTerceros = new consultaTercerosPanel(this); 
        panelConsultaTerceros.setBounds(0, 0, 900, 650);
        agregarPanel(10,panelConsultaTerceros); // Panel 10 - Panel de consulta de terceros
        panelConsultaTerceros.setVisible(false);
        
        consultaInventariosPanel panelConsultaInventarios = new consultaInventariosPanel(this); 
        panelConsultaInventarios.setBounds(0, 0, 900, 650);
        agregarPanel(11,panelConsultaInventarios); // Panel 11 - Panel de consulta de inventarios
        panelConsultaInventarios.setVisible(false);
        
        selectPUCPanel panelSelectPUC = new selectPUCPanel(this); 
        panelSelectPUC.setBounds(0, 0, 900, 650);
        agregarPanel(12,panelSelectPUC); // Panel 12 - Panel de consulta de inventarios
        panelSelectPUC.setVisible(false);
        
        selectPUCPanelCosto panelSelectPUCCosto = new selectPUCPanelCosto(this); 
        panelSelectPUCCosto.setBounds(0, 0, 900, 650);
        agregarPanel(13,panelSelectPUCCosto); // Panel 13 - Panel de consulta de inventarios
        panelSelectPUC.setVisible(false);
        
        selectPUCGasto panelSelectPUCGasto = new selectPUCGasto(this); 
        panelSelectPUCGasto.setBounds(0, 0, 900, 650);
        agregarPanel(14,panelSelectPUCGasto); // Panel 14 - Panel de consulta de inventarios
        panelSelectPUC.setVisible(false);
        
        selectTerceroIngresoPanel panelSelectTerceroIngreso = new selectTerceroIngresoPanel(this); 
        panelSelectTerceroIngreso.setBounds(0, 0, 900, 650);
        agregarPanel(15,panelSelectTerceroIngreso); // Panel 15 - Panel de consulta de inventarios
        panelSelectTerceroIngreso.setVisible(false);
        
        this.add(panelOpciones);
        this.add(panelRegistroIngreso);
        this.add(panelRegistroCosto);
        this.add(panelRegistroGasto);
        this.add(panelESInventario);
        this.add(panelConsultas);
        this.add(panelConsultaCuentasPUCPanel);
        this.add(panelConsultaCentroCosto);
        this.add(panelResporteEstadoResultados);
        this.add(panelGeneraER);
        this.add(panelConsultaTerceros);
        this.add(panelConsultaInventarios);
        this.add(panelSelectPUC);
        this.add(panelSelectPUCCosto);
        this.add(panelSelectPUCGasto);
         this.add(panelSelectTerceroIngreso);
        initComponents();
        //hollaaaaaaaaa
    }
    
    public void setPucSelectIngresos(Puc unpuc){
        puc = unpuc;
        panelRegistroIngresoAux.setCampoPucSelectIngreso(puc.getCodigo(),puc.getNombre());
        
    }
    
    public void setPucSelectCostos(Puc unpuc){
        puc = unpuc;
        panelRegistroCostoAux.setCampoPucSelectCosto(puc.getCodigo(),puc.getNombre());
    }
    
    public void setPucSelectGasto(Puc unpuc){
        puc = unpuc;
        panelRegistroGastoAux.setCampoPucSelectGasto(puc.getCodigo(),puc.getNombre());
    }
    
    
    public Puc getPucSelectIngresos(){
        return puc;
    }
    
    public void setIngresosPorVenta(int ingresosPV){ 
        ingresosPorVenta = ingresosPV;
    }
    
    public int getIngresosPorVenta(){
        return ingresosPorVenta;
    }
    
    public void setCostosProduccion(int cp){
        costoProduccion = cp;
    }
    
    public int getCostosProduccion(){
        return costoProduccion;
    }
    
    public void setUtilidadBruta(int ub){
        utilidadBruta = ub;
    }
    
    public int getUtilidadBruta(){
        return utilidadBruta;
    }
    
    public void setFechaInicial(int dI,int mI,int aI){
        fechaInicial = String.valueOf(aI)+"-"+String.valueOf(mI)+"-"+String.valueOf(dI);
    }
    
    public String getFechaInicial(){
        return fechaInicial;
    }
    
    public void setFechaFinal(int dF,int mF,int aF){
        fechaFinal = String.valueOf(aF)+"-"+String.valueOf(mF)+"-"+String.valueOf(dF);
    }
    
    public String getFechaFinal(){
        return fechaFinal;
    }
     
    //En este metodo realizo el intercambio de paneles dejanso visible el panel de interes
    // indicado por el entero n, y ocultando los demas paneles que no son de interes
    public void swap(int n){
        for(int i=0; i < panels.length; i++){
            panels[i].setVisible(false);
        }
        panels[n].setVisible(true);
    } 
    
    // Agrego los paneles que he creado a un arreglo de paneles, con esto es posible
    // hacer de manera facil el intercambio entre paneles, con el metodo swap 
    // se realiza el intercambio de paneles depues de haberlo agrado al arreglo
    public void agregarPanel(int n, JPanel panel){
        panels[n] = panel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE GESTION CONTABLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
