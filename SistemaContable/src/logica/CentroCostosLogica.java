/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Centrodecostos;
import persistencia.CentrodecostosJpaController;

/**
 *
 * @author Usuario
 */
public class CentroCostosLogica {
    CentrodecostosJpaController centroCostoDAO;
    
    public CentroCostosLogica() {
        centroCostoDAO = new CentrodecostosJpaController();
    }
    
    public List<Centrodecostos> listarCentroCostos(){
        return centroCostoDAO.findCentrodecostosEntities(); // retorna todo el listado de los centros de costos
    }
    
    public Centrodecostos buscarCentroCostos(String codigo){
        return centroCostoDAO.findCentrodecostos(codigo);
    }
    

}

