/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import Config.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import mg.gasytube.model.Album;
import mg.gasytube.model.Artiste;
import mg.gasytube.model.Genre;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author MIORA
 */
public class AlbumDAO {
    @Autowired
    HibernateDAO hibebenrateDAO;
    
    @Autowired
    ArtisteDAO album;
    
    public Album getAlbum(String nom)
    {
        Artiste artiste  = album.getArtiste(nom);
        Album reponse  = null;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        reponse = (Album) s.createCriteria(Artiste.class).add(Restrictions.like("refartiste",artiste.getId())).list().get(0);
        s.getTransaction().commit();    
        return reponse;
    }
    public List<Album> getAllAlbum()
    {
        List<Album> reponse = new ArrayList<Album>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        reponse = s.createCriteria(Album.class).list();
        s.getTransaction().commit();    
        return reponse;
    }
}
