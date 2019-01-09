/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import Config.HibernateUtil;
import java.util.List;
import mg.gasytube.model.Chanson;
import mg.gasytube.model.Genre;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MIORA
 */
public class GenreDAO {
   @Autowired
   HibernateDAO hibebenrateDAO;
   
   public List<Genre> getAllGenre()
   {
        List<Genre> reponse  = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        reponse = s.createCriteria(Genre.class).list();
        s.getTransaction().commit();    
        return reponse;
   
   }
}
