/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author MIORA
 */
@MappedSuperclass
public abstract class BaseModele {

    /**
     * @return the id
     */
   
   /* @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true,nullable = false)
    private Long id;*/
    /* public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    /*public void setId(Long id) {
        this.id = id;
    }*/
}
