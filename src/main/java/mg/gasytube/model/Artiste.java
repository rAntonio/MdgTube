/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author MIORA
 */
@Entity
@Table (name ="artiste")
public class Artiste extends BaseModele{
    
    
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
}
