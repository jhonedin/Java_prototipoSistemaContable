/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Registrocostos;
import persistencia.RegistrocostosJpaController;
import persistencia.RegistrogastosJpaController;

/**
 *
 * @author Jhon
 */
public class RegistroCostoLogica {
    RegistrocostosJpaController registroCostoDAO;
    
    public RegistroCostoLogica() {
        registroCostoDAO = new RegistrocostosJpaController();
    }
    
    public List<Registrocostos> listarRegistrosCostos(){
        return registroCostoDAO.findRegistrocostosEntities();
    }
    
    
}
