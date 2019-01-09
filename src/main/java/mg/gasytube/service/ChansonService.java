/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.service;

import Config.HibernateUtil;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.File;
import java.util.List;
import java.util.Vector;
import javax.persistence.Query;
import mg.gasytube.dao.ChansonDAO;
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Chanson;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class ChansonService {
    @Autowired
    HibernateDAO hibernateDAO;
    
    @Autowired
    GenreService genreService;
    
    @Autowired
    ArtisteService artisteService;
    
    @Autowired
    AlbumService albumService;
    
    @Autowired
    ChansonDAO chanson;
    
    public List<Chanson> giveResult(String title,int limit,int offset)
    {      
        List<Chanson> reponse  =  chanson.findByTitle(title, limit, offset);
        return reponse;
    }
    public Long giveNbLigne(String title)
    {
        Long reponse = chanson.getNombreLigne(title);
        return reponse;
    }
    public void insert(File mp3)throws Exception{
        Mp3File mp3file = new Mp3File(mp3.getAbsolutePath());
            if (mp3file.hasId3v2Tag()) {
                ID3v2 tag = mp3file.getId3v2Tag();
                
                Chanson c=new Chanson();
                c.setTitre(tag.getTitle());
                c.setComment(tag.getComment());
                c.setComposer(tag.getComposer());
                c.setDateSortie(tag.getDate());
                c.setPublisher(tag.getPublisher());
                c.setUrl(mp3.getAbsolutePath());
                
                int idGenre=0;
                    if(genreService.hasGenre(tag.getGenreDescription())){
                        idGenre=genreService.getIdGenre(tag.getGenreDescription()).intValue();
                    }else{
                        idGenre=genreService.add(tag.getGenreDescription()).intValue();
                    }
                c.setRefgenre(0);
                
                int idAlbum=0;
                    if(albumService.hasAlbum(tag.getAlbum(),tag.getAlbumArtist())){
                        idAlbum=albumService.getIdAlbum(tag.getGenreDescription(),tag.getAlbumArtist()).intValue();
                    }else{
                        idAlbum=albumService.add(tag.getGenreDescription(),tag.getAlbumArtist()).intValue();
                    }
                c.setRefalbum(0);
                
            }else if(mp3file.hasId3v1Tag()){
                ID3v1 tag = mp3file.getId3v1Tag();
            }else{
                throw new Exception("MP3 encode not found");
            }
          }
    }


//System.out.println("Track: " + id3v2Tag.getTrack());
//            System.out.println("Artist: " + id3v2Tag.getArtist());
//            System.out.println("Title: " + id3v2Tag.getTitle());
//            System.out.println("Album: " + id3v2Tag.getAlbum());
//            System.out.println("Year: " + id3v2Tag.getDate());
//            System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
//            System.out.println("Comment: " + id3v2Tag.getComment());
//            System.out.println("Composer: " + id3v2Tag.getComposer());
//            System.out.println("Publisher: " + id3v2Tag.getPublisher());
//            System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
//            System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
//            System.out.println("Copyright: " + id3v2Tag.getCopyright());
//            System.out.println("URL: " + id3v2Tag.getUrl());
//            System.out.println("Encoder: " + id3v2Tag.getEncoder());
//            byte[] albumImageData = id3v2Tag.getAlbumImage();
//            if (albumImageData != null) {
//                RandomAccessFile image=new RandomAccessFile ("H:\\Download\\ionicTemplate\\Couverture"+id3v2Tag.getAlbum()+".jpg","rw");
//                    /*BufferedOutputStream imgstream = new BufferedOutputStream(new FileOutputStream(image));
//                    imgstream.write(albumImageData);
//                    imgstream.close();*/
//                image.write(albumImageData);
//                image.close();
//
//              System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
//              System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
//}
 