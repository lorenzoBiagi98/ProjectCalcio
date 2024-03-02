package com.example.ProjectCalcio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.ProjectCalcio.entities.Squadra;
import com.example.ProjectCalcio.services.SquadraService;
import com.example.statics.Controlli;
import jakarta.servlet.http.HttpSession;

@Controller
public class SimulazioniPartiteController {

    @Autowired
    SquadraService squadraService;

    @Autowired
    ApplicationContext context;

    @Autowired
    Controlli controlli;

        @GetMapping("/incontricasuali/{idAllenatore}")
            public String simulaIncontro(@PathVariable int idAllenatore, HttpSession session, Model model){
                System.out.println("--------------------");
                Squadra squadraCasa = squadraService.findSquadraByIdAllenatore(idAllenatore);
                model.addAttribute("squadraCasa", squadraCasa);
                Squadra squadraOspite = controlli.controlloSquadraOspite(idAllenatore);
                model.addAttribute("squadraOspite", squadraOspite);
                String risultato = controlli.controlloRisultato(idAllenatore);
                model.addAttribute("risultato", risultato);
                return "simula.html";
            }

           
    /* 
    private Squadra determinaVincitore(Squadra squadra1, Squadra squadra2) {
        // Simula una determinazione casuale del vincitore
        Random random = new Random();
        int vincitore = random.nextInt(3); // 0 = squadra1, 1 = squadra2, 2 = pareggio

        if (vincitore == 0) {
            squadra1.setPunti(squadra1.getPunti() + 3);
            return squadra1;
        } else if (vincitore == 1) {
            squadra2.setPunti(squadra2.getPunti() + 3);
            return squadra2;
        } else {
            squadra1.setPunti(squadra1.getPunti() + 1);
            squadra2.setPunti(squadra2.getPunti() + 1);
            return null; // Pareggio
        }
    }

    private void aggiornaPunteggi(Squadra squadra1, Squadra squadra2, Squadra squadraVincente) {

        squadra1.setPunti(squadra1.getPunti() + 1);

        squadra2.setPunti(squadra2.getPunti() + 1);

        if (squadraVincente != null) {
            squadraVincente.setPunti(squadraVincente.getPunti() + 3);
        }
    }
    */

}
