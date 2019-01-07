/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.service;

import java.util.List;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Administrateur;
import mg.gasytube.model.BaseModele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class AdministrateurService {
    @Autowired
    HibernateDAO hibernateDAO;
    
    public Administrateur login(String username,String password){
        List<BaseModele> list=hibernateDAO.findAll(new Administrateur(new Long(0),null,password,username));
        if(list.isEmpty()){
            return null;
        }else{
            return (Administrateur) list.get(0);
        }
    }
}
