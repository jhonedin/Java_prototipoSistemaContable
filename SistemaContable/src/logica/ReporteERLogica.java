/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Registroingresos;

/**
 *
 * @author Jhon
 */
public class ReporteERLogica {
    
    private RegistroIngresoLogica registroIngresoLogica;

    public ReporteERLogica(){
        
    }
    
    public int ingresosPorVenta(int dI,int mI,int aI,int dF,int mF,int aF){
        registroIngresoLogica = new RegistroIngresoLogica();
        List<Registroingresos> listaRegistrosIngresos = registroIngresoLogica.listarRegistrosIngresos();
        int aux = 0;
        for(int i=0;i<=listaRegistrosIngresos.size()-1;i++){
            aux += listaRegistrosIngresos.get(i).getValor();
        }
        //int ingreso = 446000;
        int ingreso = aux;
        return ingreso;
    }
    
    public int calculoCVCostosProduccion(){
        int costoProduccion = 88853;
        return costoProduccion;
    }
}
