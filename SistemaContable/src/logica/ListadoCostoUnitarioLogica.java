/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Listadocostounitario;
import persistencia.ListadocostounitarioJpaController;

/**
 *
 * @author Jhon
 */
public class ListadoCostoUnitarioLogica {
    ListadocostounitarioJpaController listadoCostoUnitarioDAO;
    
    public ListadoCostoUnitarioLogica() {
        listadoCostoUnitarioDAO = new ListadocostounitarioJpaController();
    }
    
    public List<Listadocostounitario> listarRegistrosIngresos(){
        return listadoCostoUnitarioDAO.findListadocostounitarioEntities();
    }
    
    public Listadocostounitario llamarPorKardex(String kardex){
        return listadoCostoUnitarioDAO.findListadocostounitario(kardex);
    }
    
    
}
