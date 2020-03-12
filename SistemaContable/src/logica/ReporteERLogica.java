/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.swing.JOptionPane;
import modelo.Registroingresos;

/**
 *
 * @author Jhon
 */
public class ReporteERLogica {
    
    private RegistroIngresoLogica registroIngresoLogica;
    private ListadoCostoUnitarioLogica listadoCULogica;
    public ReporteERLogica(){
        
    }
    
    public int ingresosPorVenta(int dI,int mI,int aI,int dF,int mF,int aF){
        registroIngresoLogica = new RegistroIngresoLogica();
        List<Registroingresos> listaRegistrosIngresos = registroIngresoLogica.listarRegistrosIngresos();
        int aux = 0;
        int ingreso = 0;
        for(int i=0;i<=listaRegistrosIngresos.size()-1;i++){
            if(listaRegistrosIngresos.get(i).getAnioreg()>=aI && listaRegistrosIngresos.get(i).getAnioreg()<=aF ){
                if(listaRegistrosIngresos.get(i).getMesreg()>=mI && listaRegistrosIngresos.get(i).getMesreg()<=mF){
                    if(listaRegistrosIngresos.get(i).getDiareg()>=dI && listaRegistrosIngresos.get(i).getDiareg()<=dF){
                        aux += listaRegistrosIngresos.get(i).getValor();
                    }
                }
            }  
        }
        if(aux!=0){
           ingreso = aux;
        }
        else{
           JOptionPane.showMessageDialog(null, "No se encontraron registros de ventas los rangos de fechas especificados"); 
        }
        
        return ingreso;
    }
    
    public int calculoCVCostosProduccion(int dI,int mI,int aI,int dF,int mF,int aF){
        registroIngresoLogica = new RegistroIngresoLogica();
        listadoCULogica = new ListadoCostoUnitarioLogica();
        List<Registroingresos> listaRegistrosIngresos = registroIngresoLogica.listarRegistrosIngresos();
        int costoProduccion = 0;
        int aux = 0;
        String auxKardex = "";
        for(int i=0;i<=listaRegistrosIngresos.size()-1;i++){
            if(listaRegistrosIngresos.get(i).getAnioreg()>=aI && listaRegistrosIngresos.get(i).getAnioreg()<=aF ){
                if(listaRegistrosIngresos.get(i).getMesreg()>=mI && listaRegistrosIngresos.get(i).getMesreg()<=mF){
                    if(listaRegistrosIngresos.get(i).getDiareg()>=dI && listaRegistrosIngresos.get(i).getDiareg()<=dF){
                        
                    }
                }
            }  
        }
        
        return costoProduccion;
    }
}
