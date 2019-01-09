/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music;

import java.sql.Date;
import java.util.List;
import mg.gasytube.dao.ArtisteDAO;
import mg.gasytube.dao.ChansonDAO;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Administrateur;
import mg.gasytube.model.Album;
import mg.gasytube.model.Artiste;
import mg.gasytube.model.Chanson;
import mg.gasytube.service.ChansonService;
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
       a.setPassword("Tony");
       a.setUsername("Tony");
       h.create(a);
    }
    
}
