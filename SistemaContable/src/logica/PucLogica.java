/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import modelo.Puc;
import persistencia.PucJpaController;

/**
 *
 * @author Jhon
 */
public class PucLogica {
    PucJpaController pucDAO;
    
    public PucLogica() {
        pucDAO = new PucJpaController();
    }
    
    public List<Puc> listarPuc(){
        return pucDAO.findPucEntities(); // retorna todo el listado de las puc 
    }
    
    public Puc buscarPucxcodigo(String codigo){
        Puc unpuc;
        return unpuc = pucDAO.findPuc(codigo); 
    }
    
}
