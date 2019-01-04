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
@Table (name="genre")
public class Genre extends BaseModele {
    @Column
    String designation;
    public Genre(){}
    public Genre(Long id,String designation) {
        this.id = id;
        this.designation = designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
