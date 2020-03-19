/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import modelo.Listadoterceros;
import persistencia.ListadotercerosJpaController;

/**
 *
 * @author Usuario
 */
public class ListadoTercerosLogica {
    ListadotercerosJpaController listadoTercerosDAO;
    
    private List<Listadoterceros> listadoTerceros;
    private Listadoterceros unTercero;
    
    public ListadoTercerosLogica() {
        listadoTercerosDAO = new ListadotercerosJpaController();
    }
    
    public List<Listadoterceros> listarTerceros(){
        return listadoTercerosDAO.findListadotercerosEntities(); // retorna todo el listado de las puc 
    }    
    
    public Listadoterceros buscarTerceroxcodigo(String codigo){
        listadoTerceros = this.listarTerceros();
        unTercero = new Listadoterceros();
        
        return unTercero; 
    }
    
}
