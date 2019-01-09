/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import Config.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import mg.gasytube.model.Artiste;
import mg.gasytube.model.Chanson;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MIORA
 */
public class ArtisteDAO {
   @Autowired
   HibernateDAO hibebenrateDAO;
   
   public Artiste getArtiste(String nom)
   {
        Artiste reponse  = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        reponse = (Artiste) s.createCriteria(Artiste.class).add(Restrictions.like("designation",nom)).list().get(0);
        s.getTransaction().commit();    
        return reponse;
   }
   public List<Artiste> getAllArtiste()
   {
       List<Artiste> reponse = new ArrayList<Artiste>();
       Session s = HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       reponse = s.createCriteria(Artiste.class).list();
       s.getTransaction().commit();    
       return reponse;
   }
   
 
}
