/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import Config.HibernateUtil;
import java.util.List;
import mg.gasytube.model.Chanson;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MIORA
 */
public class ChansonDAO {
   @Autowired
   HibernateDAO hibebenrateDAO;
   
   /*Chanson ch =  new Chanson();
        ch.setTitre(title);*/
        /*Example example = Example.create(ch)
                .excludeProperty("refchanson")
                .excludeProperty("refgenre")
                .excludeProperty("refalbum")
                .excludeProperty("datesortie")
                .excludeProperty("comment")
                .excludeProperty("composer")
                .excludeProperty("publisher")
                .excludeProperty("copyrigth")
                .excludeProperty("url")
                .ignoreCase();*/
  public List<Chanson> findByTitle(String title,int limit,int offset)
  {
        List<Chanson> reponse  = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        reponse = s.createCriteria(Chanson.class).add(Restrictions.like("titre", "%"+title+"%")).setFirstResult(limit).setMaxResults(offset).list();
        s.getTransaction().commit();    
        return reponse;
  }
  public Long getNombreLigne(String title)
  {
       Long reponse = null;
       Session s = HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       String hql = "select count(*) from Chanson where titre like '%"+title+"%'";
       System.out.println(hql);
       Query query = s.createQuery(hql);
       reponse = (Long) query.list().get(0);
       s.getTransaction().commit();
       return reponse;
  }
}
