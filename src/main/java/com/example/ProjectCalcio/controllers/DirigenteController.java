package com.example.ProjectCalcio.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;
import com.example.ProjectCalcio.services.PersonaService;
import com.example.ProjectCalcio.services.SquadraService;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;


@Controller
public class DirigenteController {

    @Autowired
    SquadraService squadraService;

    @Autowired
    PersonaService personaService;

   /* 
@PostMapping("/transfer/{idSquadra}/{idCalciatore}")
public String Acquisto(@PathVariable("idSquadra") int idSquadra, @PathVariable("idCalciatore") int idCalciatore){
    System.out.println("s----------");
    boolean ris = squadraService.addAcquisto(idSquadra, idCalciatore);
    System.out.println(ris);
    return "redirect:/areaDirigente";
}
*/
/* 
@PostMapping("/transfer/{idSquadra}/{idCalciatore}")
public String Acquisto(@PathVariable("idSquadra") String idSquadra, @PathVariable("idCalciatore") String idGiocatore, 
HttpSession session, Model model){
    System.out.println(idSquadra + " idSquadra");
    System.out.println(idGiocatore + " idSquadra");
//int idSquadra1 = Integer.parseInt(session.getAttribute("idSquadra")+"");
//int idGiocatore1 = Integer.parseInt(session.getAttribute("idCalciatore")+"");
model.addAttribute("idSquadra", idSquadra);
model.addAttribute("idCalciatore", idGiocatore);
squadraService.addAcquisto(Integer.parseInt(idGiocatore), Integer.parseInt(idSquadra));
    return "redirect:/areaDirigente";
}
*/
@PostMapping("/transfer/{idDirigente}")
public String Acquisto(HttpSession session, Model model){
    System.out.println(session.getAttribute("idCalciatore"));
    List<Integer> listaId = squadraService.findIdSvincolati();
    model.addAttribute("listaId", listaId);
    int idDirigenteF = Integer.parseInt(session.getAttribute("idDirigente").toString());
    Squadra squadra = squadraService.findSquadraByIdDirigente(idDirigenteF);
    model.addAttribute("idSquadra", squadra.getId()); // Sostituisci con il valore reale
    System.out.println(squadra.getId());
    return "redirect:/areaDirigente";

}
/* 
@PostMapping("/transfer/{idSquadra}/{idCalciatore}")
public String Acquisto(@RequestParam Map<String, String> params, 
HttpSession session, Model model){
System.out.println(params);
//int idSquadra1 = Integer.parseInt(session.getAttribute("idSquadra")+"");
//int idGiocatore1 = Integer.parseInt(session.getAttribute("idCalciatore")+"");
    return "redirect:/areaDirigente";
}
*/
     @GetMapping("/areaDirigente")
    public String areaDirigente(HttpSession session, Model model){
        if(session.getAttribute("login") != null){
            if("OK".equals(session.getAttribute("login").toString())){
                if(!"dirigente".equals(session.getAttribute("ruolo").toString()) || session.getAttribute("login") == null 
                || !"OK".equals(session.getAttribute("login").toString()) ){
                    return "redirect:/loginpage";
                }
        int idDirigente = Integer.parseInt(session.getAttribute("id").toString());
        Dirigente d = personaService.findDirigenteById(idDirigente);
       model.addAttribute("dirigente", d);
       session.setAttribute("idDirigente", d.getId());
       List<Giocatore> listaTotale = squadraService.findSquadraCalciatori();
       model.addAttribute("listaTotale", listaTotale);
       session.setAttribute("idCalciatore", listaTotale);
       Squadra s = squadraService.findSquadraByIdDirigente(d.getId());
       model.addAttribute("squadra", s);
        List<Giocatore> listaGiocatori = squadraService.findSquadraCalciatori(idDirigente);
        model.addAttribute("listaCalciatori", listaGiocatori);
        return "dirigente.html";
            }
        }

        return "home.html";
        
    }
    
}
