/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.service;

import org.springframework.stereotype.Service;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Album;
import mg.gasytube.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author HP
 */
@Service
public class AlbumService {
    @Autowired
    HibernateDAO hibernateDAO;
    
    @Autowired
    ArtisteService artisteService;

    boolean hasAlbum(String genreDescription,String artist) {
       return hibernateDAO.findAll(new Album(null,artisteService.getIdArtiste(artist).intValue(),null,null,genreDescription)).isEmpty();
    }

    Long getIdAlbum(String genreDescription,String artist) {
        return ((Album)hibernateDAO.findAll(new Album(null,artisteService.getIdArtiste(artist).intValue(),genreDescription,null,null)).get(0)).getId();
    }

    Long add(String genreDescription, String artist) {
        hibernateDAO.create(new Genre(null,genreDescription));
        return ((Album)hibernateDAO.findAll(new Album(null,artisteService.getIdArtiste(artist).intValue(),genreDescription,null,null)).get(0)).getId();
    }
}
