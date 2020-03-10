/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Registroingresos;
import persistencia.RegistroingresosJpaController;

/**
 *
 * @author Jhon
 */
public class RegistroIngresoLogica {
    RegistroingresosJpaController registroIngresosDAO;
    
    public RegistroIngresoLogica() {
        registroIngresosDAO = new RegistroingresosJpaController();
    }
    
    public List<Registroingresos> listarRegistrosIngresos(){
        return registroIngresosDAO.findRegistroingresosEntities();
    }
    
}
