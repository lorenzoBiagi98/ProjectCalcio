package com.example.statics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;
import com.example.ProjectCalcio.services.LoginService;
import com.example.ProjectCalcio.services.SquadraService;

public class Controlli {

    @Autowired
    LoginService loginService;

    @Autowired
    SquadraService squadraService;

    public static boolean ControlloBudget(Squadra s, Giocatore g) {
        if (s.getBudget() >= g.getCosto() && isVendita(g) == true) {
            return true;
        }
        return false;
    }

    public static boolean isVendita(Giocatore g) {
        if (g.getSquadra() == null) {
            return true;
        } else {

            return false;
        }
    }

    public boolean controlloLoginAllenatore(String username, String password) {
        List<Map<String, String>> listaCredenzialiA = loginService.listaCredenzialiAllenatori();
        for (int i = 0; i < listaCredenzialiA.size(); i++) {
            Map<String, String> listaCredenziali = listaCredenzialiA.get(i);
            if (username.equals(listaCredenziali.get("username"))) {
                if (password.equals(listaCredenziali.get("password"))) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean controlloLoginDirigente(String username, String password) {
        List<Map<String, String>> listaCredenzialiD = loginService.listaCredenzialiDirigenti();
        for (int i = 0; i < listaCredenzialiD.size(); i++) {
            Map<String, String> listaCredenziali = listaCredenzialiD.get(i);
            if (username.equals(listaCredenziali.get("username"))) {
                if (password.equals(listaCredenziali.get("password"))) {
                    return true;
                }
            }
        }
        return false;

    }

    public Squadra controlloSquadraOspite(int idAllenatore) {
        List<Squadra> squadre = new ArrayList<>(squadraService.findAllSquadre());
        Squadra squadraCasa = squadraService.findSquadraByIdAllenatore(idAllenatore);
        Squadra squadraOspite = null;

        do {
            if (!squadre.isEmpty()) {
                Collections.shuffle(squadre);
                squadraOspite = squadre.get(0);
            }
            if (squadraOspite.getNome().equals(squadraCasa.getNome())) {

                squadraOspite = null;
            }
        } while (squadraOspite == null);

        return squadraOspite;
    }

    public int goalFatti() {
        int goalFatti = (int) (Math.random() * 5) + 1;
        return goalFatti;
    }

    public String controlloRisultato(int idAllenatore) {
        return goalFatti() + " : " + goalFatti();
    }

}
