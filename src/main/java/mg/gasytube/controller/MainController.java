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
import mg.gasytube.dao.HibernateDAO;
import mg.gasytube.model.Administrateur;
import mg.gasytube.service.AdministrateurService;
import mg.gasytube.service.ChansonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    AdministrateurService adminService;
    
    @Autowired
    ChansonService songService;
    
    @Autowired
    Administrateur admin;
    
   @RequestMapping(value="/",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      if(admin.isValide())
          return "main";
      return "login";
   }
   
   @RequestMapping(value="authentification" , method=RequestMethod.POST)
   public String authentification(@RequestParam("username") String username,
           @RequestParam("password") String password){
           System.out.println("Login : "+username+" Pass :"+password);
           
           admin=adminService.login(username, password);
//           System.out.print(admin.getMail());
    
    return "redirect:";
   }
   
   @RequestMapping(value="add",method = RequestMethod.POST)
   public ModelAndView add(@RequestParam("file") MultipartFile file,RedirectAttributes redirect) {
       String message=new String();
       String name=file.getOriginalFilename();
       
       if(file.isEmpty()){
           return new ModelAndView("redirect:main","message", "Please select a file");
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
            
            //insertion
            songService.insert(serverFile);
            
            message="You successfully uploaded file="+name+" ,path is :"+serverFile.getAbsolutePath();
    } catch (Exception e) {
            message="You failed to upload " + name + " => " + e.getMessage();
            e.printStackTrace();
    }
       return new ModelAndView("redirect:","message", message);
   }
}
