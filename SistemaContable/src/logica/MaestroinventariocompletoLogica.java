/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Maestroinventariocompleto;
import persistencia.MaestroinventariocompletoJpaController;

/**
 *
 * @author Jhon
 */
public class MaestroinventariocompletoLogica {
    MaestroinventariocompletoJpaController maestroInventarioCompletoDAO;
    
    public MaestroinventariocompletoLogica() {
        maestroInventarioCompletoDAO = new  MaestroinventariocompletoJpaController();
    }
    
    public List<Maestroinventariocompleto> listarMaestroInventarioCompleto(){
        return maestroInventarioCompletoDAO.findMaestroinventariocompletoEntities(); // retorna todo el listado del maestro de inventario 
    }
    
    public Maestroinventariocompleto buscarInventarioxcodigo(String codigo){
        return maestroInventarioCompletoDAO.findMaestroinventariocompleto(codigo);
    }
}
