/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="album")
public class Album extends BaseModele {
    
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "refalbum",unique=true,nullable = false)
    Long id;
    
    @Column
    int refartiste;
    @Column
    String designation;
    @Column
    Date dateSortie;
    @Column
    String image;
    public Album(Long id,int refartiste, String designation, Date dateSortie, String image) {
        this.id = id;
        this.refartiste = refartiste;
        this.designation = designation;
        this.dateSortie = dateSortie;
        this.image = image;
    }
    public Album(){}
    public void setRefartiste(int refartiste) {
        this.refartiste = refartiste;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRefartiste() {
        return refartiste;
    }

    public String getDesignation() {
        return designation;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public String getImage() {
        return image;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
