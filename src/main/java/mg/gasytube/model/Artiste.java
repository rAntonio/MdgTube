/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author MIORA
 */
@Entity
@Table (name ="artiste")
public class Artiste extends BaseModele{
 
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "refartiste",unique=true,nullable = false)
    private Long id;
    
    @Column
    String designation;
    @Column
    String image;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesignation() {
        return designation;
    }

    public String getImage() {
        return image;
    }
    public Artiste(Long id ,String designation, String image) {
        this.id = id;
        this.designation = designation;
        this.image = image;
    }
    public Artiste(){}
     /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
