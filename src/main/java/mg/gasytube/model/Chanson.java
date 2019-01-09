/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.model;

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
@Table(name="chanson")
public class Chanson extends BaseModele{
    
    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "refchanson",unique=true,nullable = false)
    Long id;
    
    @Column
    int refgenre;
    @Column
    int refalbum;
    @Column
    String titre;
    @Column
    String dateSortie;
    @Column
    String comment;
    @Column
    String composer;
    @Column
    String publisher;
    @Column
    String copyright;
    @Column
    String url;

    public Chanson(Long id,int refgenre, int refalbum, String titre, String dateSortie, String comment, String composer, String publisher, String copyright, String url) {
        this.id = id;
        this.refgenre = refgenre;
        this.refalbum = refalbum;
        this.titre = titre;
        this.dateSortie = dateSortie;
        this.comment = comment;
        this.composer = composer;
        this.publisher = publisher;
        this.copyright = copyright;
        this.url = url;
    }
    public Chanson(){}
    public void setRefgenre(int refgenre) {
        this.refgenre = refgenre;
    }

    public void setRefalbum(int refalbum) {
        this.refalbum = refalbum;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateSortie(String dateSortie) {
        this.dateSortie = dateSortie;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRefgenre() {
        return refgenre;
    }

    public int getRefalbum() {
        return refalbum;
    }

    public String getTitre() {
        return titre;
    }

    public String getDateSortie() {
        return dateSortie;
    }

    public String getComment() {
        return comment;
    }

    public String getComposer() {
        return composer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getUrl() {
        return url;
    }
    
}
