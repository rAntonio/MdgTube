/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.service;

import org.springframework.stereotype.Service;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Album;
import mg.gasytube.model.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author HP
 */
@Service
public class ArtisteService {
    @Autowired
    HibernateDAO hibernateDAO;

    Long getIdArtiste(String artist) {
        return ((Album)hibernateDAO.findAll(new Artiste(null,artist,null)).get(0)).getId();
    }
}
