/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.service;

import org.springframework.stereotype.Service;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author HP
 */
@Service
public class GenreService {
    @Autowired
    HibernateDAO hibernateDAO;

    boolean hasGenre(String genreDescription) {
       return hibernateDAO.findAll(new Genre(null,genreDescription)).isEmpty();
    }

    Long getIdGenre(String genreDescription) {
        return ((Genre)hibernateDAO.findAll(new Genre(null,genreDescription)).get(0)).getId();
    }

    Long add(String genreDescription) {
        hibernateDAO.create(new Genre(null,genreDescription));
        return ((Genre)hibernateDAO.findAll(new Genre(null,genreDescription)).get(0)).getId();
    }
}
