/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name ="administrateur")
public class Administrateur extends BaseModele implements java.io.Serializable{

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
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroot",unique=true,nullable = false)
    private Long id;
    
    @Column
    String mail;
    @Column
    String password;
    @Column
    String username;

    public Administrateur(Long id,String mail, String password, String username) {
        this.id = id;
        this.mail = mail;
        this.password = password;
        this.username = username;
    }
    public Administrateur(){}
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    public boolean isValide(){
        return (getId()!=null && username!=null && password!=null && mail !=null);
    }
    
}
