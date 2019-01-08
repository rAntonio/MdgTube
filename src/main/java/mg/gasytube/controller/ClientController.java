/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.controller;

import java.util.List;
import mg.gasytube.model.Chanson;
import mg.gasytube.service.ChansonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/recherche/")
public class ClientController {
   @Autowired
   ChansonService chansonService;
  /* @RequestMapping(value="/",method = RequestMethod.GET)
   public ModelAndView redirection(ModelMap model) {
      return new ModelAndView("welcome", "message", "wawa");
   }*/
   
   @RequestMapping(value="/",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
       System.out.println("Hello");
      return "recherche";
   }
   @RequestMapping(value="traitement" , method=RequestMethod.GET)
   public ModelAndView authentification(@RequestParam("recherche") String mot,@RequestParam(name="indice",defaultValue = "0")int indice){
       List<Chanson> resultat  = chansonService.giveResult(mot,indice,(indice+5));
       Long nbLigne = chansonService.giveNbLigne(mot);
       ModelAndView model = new ModelAndView("recherche");
       model.addObject("nbligne",nbLigne);
       model.addObject("resultat",resultat);
       model.addObject("mot",mot);
       return model;
   }
}
