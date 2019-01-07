/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping("/")
public class ClientController {
   @RequestMapping(value="/",method = RequestMethod.GET)
   public ModelAndView redirection(ModelMap model) {
      return new ModelAndView("welcome", "message", "wawa");
   }
}
