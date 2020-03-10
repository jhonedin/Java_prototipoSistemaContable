/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Registrogastos;
import persistencia.RegistrogastosJpaController;

/**
 *
 * @author Jhon
 */
public class RegistroGastoLogica {
    RegistrogastosJpaController registroGastosDAO;
    
    public RegistroGastoLogica() {
        registroGastosDAO = new RegistrogastosJpaController();
    }
    
    public List<Registrogastos> listarRegistrosIngresos(){
        return registroGastosDAO.findRegistrogastosEntities();
    }
}
