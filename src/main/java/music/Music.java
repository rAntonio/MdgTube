/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music;

import java.sql.Date;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Administrateur;
;

/**
 *
 * @author MIORA
 */
public class Music {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HibernateDAO h = new HibernateDAO();
       Administrateur a = new Administrateur();
       a.setMail("hajatianarabekoto@gmail.com");
       a.setPassword("root");
       a.setUsername("root");
       h.create(a);
       //System.out.println(h.findAll(a).size());
    }
    
}
