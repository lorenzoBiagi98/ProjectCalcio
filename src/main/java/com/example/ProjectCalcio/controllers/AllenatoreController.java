package com.example.ProjectCalcio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;
import com.example.ProjectCalcio.services.PersonaService;
import com.example.ProjectCalcio.services.SquadraService;
import jakarta.servlet.http.HttpSession;

@Controller
public class AllenatoreController {

    @Autowired
    PersonaService personaService;

    @Autowired
    SquadraService squadraService;

    @Autowired
    SimulazioniPartiteController sm;

    @GetMapping("/areaFormazione/{idAllenatore}")
    public String areaFormazione(@PathVariable int idAllenatore, HttpSession session, Model model){
         //int idAllenatore1 = Integer.parseInt(session.getAttribute("idAllenatore").toString());
         List<Giocatore> listaGiocatori = squadraService.findSquadraCalciatoriA(idAllenatore);
        model.addAttribute("listaCalciatori", listaGiocatori);
        return "formazione.html";
   }

    @GetMapping("/areaAllenatore")
    public String areaAllenatore(HttpSession session, Model model) {
        if (session.getAttribute("login") != null) {
            if ("OK".equals(session.getAttribute("login").toString())) {
                if (!"allenatore".equals(session.getAttribute("ruolo").toString())
                        || session.getAttribute("login") == null
                        || !"OK".equals(session.getAttribute("login").toString())) {
                    return "redirect:/loginpage";
                }
                int idAllenatore = Integer.parseInt(session.getAttribute("id").toString());
                Allenatore a = personaService.findAllenatoreById(idAllenatore);
                model.addAttribute("allenatore", a);
                Squadra s = squadraService.findSquadraByIdAllenatore(a.getId());
                model.addAttribute("squadra", s);
                List<Giocatore> listaGiocatori = squadraService.findSquadraCalciatoriA(idAllenatore);
                model.addAttribute("listaCalciatori", listaGiocatori);
                session.setAttribute("idAllenatore", a.getId());
                return "allenatore.html";
            }
        }

        return "home.html";

    }


    
}
