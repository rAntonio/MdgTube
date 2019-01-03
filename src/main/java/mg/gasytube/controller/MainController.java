/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.controller;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/admin/")
public class MainController { 
   @RequestMapping(value="/",method = RequestMethod.GET)
   public ModelAndView printHello(ModelMap model) {
      return new ModelAndView("login", "message", "wawa");
   }
   
   @RequestMapping(value="authentification" , method=RequestMethod.POST)
   public ModelAndView authentification(@RequestParam("username") String username,
           @RequestParam("password") String password){
    System.out.println("Login : "+username+" Pass :"+password);
    ModelAndView mv=null;
    
    mv=new ModelAndView("main", "message", "wawa");
    
    return mv;
   }
   
   @RequestMapping(value="add",method = RequestMethod.POST)
   public ModelAndView add(@RequestParam("file") MultipartFile file,RedirectAttributes redirect) {
       System.out.println("Nom : "+file.getOriginalFilename());
       String name=file.getOriginalFilename();
       String message=new String();
       if(file.isEmpty()){
           redirect.addFlashAttribute("message", "Please select a file");
           return new ModelAndView("redirect:main","message", "wawa");
       }
       
       try {
            byte[] bytes = file.getBytes();

            // Creating the directory to store file
            String rootPath = System.getProperty("catalina.home");
            File dir = new File(rootPath + File.separator + "tmpFiles");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath()+ File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            
            Mp3File mp3file = new Mp3File(serverFile.getAbsolutePath());
            if (mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                System.out.println("Track: " + id3v2Tag.getTrack());
                System.out.println("Artist: " + id3v2Tag.getArtist());
                System.out.println("Title: " + id3v2Tag.getTitle());
                System.out.println("Album: " + id3v2Tag.getAlbum());
                System.out.println("Year: " + Date.valueOf(id3v2Tag.getDate()));
                System.out.println("Genre: " + id3v2Tag.getGenre() + " (" + id3v2Tag.getGenreDescription() + ")");
                System.out.println("Comment: " + id3v2Tag.getComment());
                System.out.println("Composer: " + id3v2Tag.getComposer());
                System.out.println("Publisher: " + id3v2Tag.getPublisher());
                System.out.println("Original artist: " + id3v2Tag.getOriginalArtist());
                System.out.println("Album artist: " + id3v2Tag.getAlbumArtist());
                System.out.println("Copyright: " + id3v2Tag.getCopyright());
                System.out.println("URL: " + id3v2Tag.getUrl());
                System.out.println("Encoder: " + id3v2Tag.getEncoder());
                byte[] albumImageData = id3v2Tag.getAlbumImage();
                if (albumImageData != null) {
                    RandomAccessFile image=new RandomAccessFile ("H:\\Download\\ionicTemplate\\Couverture"+id3v2Tag.getAlbum()+".jpg","rw");
                    /*BufferedOutputStream imgstream = new BufferedOutputStream(new FileOutputStream(image));
                    imgstream.write(albumImageData);
                    imgstream.close();*/
                    image.write(albumImageData);
                    image.close();
                    
                  System.out.println("Have album image data, length: " + albumImageData.length + " bytes");
                  System.out.println("Album image mime type: " + id3v2Tag.getAlbumImageMimeType());
                }
              }
            message="You successfully uploaded file="+name+" ,path is :"+serverFile.getAbsolutePath();
            System.out.println(message);
    } catch (Exception e) {
            message="You failed to upload " + name + " => " + e.getMessage();
            e.printStackTrace();
    }
       return new ModelAndView("main","message", message);
   }
}
