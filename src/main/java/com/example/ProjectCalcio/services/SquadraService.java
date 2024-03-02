package com.example.ProjectCalcio.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ProjectCalcio.database.AllenatoreDao;
import com.example.ProjectCalcio.database.DirigenteDao;
import com.example.ProjectCalcio.database.GiocatoreDao;
import com.example.ProjectCalcio.database.SquadraDao;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;
import java.util.*;

public class SquadraService {

    @Autowired
    SquadraDao squadraDao;

    @Autowired
    DirigenteDao dirigenteDao;

    @Autowired
    GiocatoreDao giocatoreDao;

    @Autowired
    AllenatoreDao allenatoreDao;


    // Ritorna la lista di tutte le squadre
    public List<Squadra> findAllSquadre() {
        return squadraDao.read().values().stream().map(e -> (Squadra) e).toList();
    }

    // Ritorna la lista delle squadre per allenatore
    public List<Squadra> findSquadraByAllenatore() {
        return squadraDao.readAllenatoriPerSquadra().values().stream().map(e -> (Squadra) e).toList();
    }
    

    // Ritorna la lista delle squadre per dirigente
    public List<Squadra> findSquadreByDirigente() {
        return squadraDao.readDirigentiPerSquadra().values().stream().map(e -> (Squadra) e).toList();
    }
    //Ritorna la squadra per dirigente
    public Squadra findSquadraByIdDirigente(int idDirigente) {
        return (Squadra) squadraDao.readOneSquadra(idDirigente);
    }

    public Squadra findSquadraByIdAllenatore(int idAllenatore) {
        return (Squadra) squadraDao.readOneSquadraAllenatore(idAllenatore);
    }

     // Ritorna la lista delle squadre per giocatore(svincolati)
    public List<Giocatore> findSquadraCalciatori() {
        return squadraDao.readCalciatoriPerSquadra().values().stream().map(e -> (Giocatore) e).toList();
    }

      // Ritorna la lista dei giocatori per squadre in base ad idDirigente
    public List<Giocatore> findSquadraCalciatori(int idDirigente) {
        return squadraDao.readCalciatoriPerSquadra(idDirigente).values().stream().map(e -> (Giocatore) e).toList();
    }

    //Ritorna la lista dei calciatori per squadre in base ad idAllenatore
    public List<Giocatore> findSquadraCalciatoriA(int idAllenatore) {
        return squadraDao.readCalciatoriPerSquadraA(idAllenatore).values().stream().map(e -> (Giocatore) e).toList();
    }

    //Metodo per aquistare un calciatore
    public boolean addAcquisto(int idSvincolato, int idSquadra){
        System.out.println(idSvincolato + "id2");
        return dirigenteDao.Acquisto(idSvincolato, idSquadra);
    }

    public List<Integer> findIdSvincolati(){
        List<Integer> ris = new ArrayList<>();
        for(Giocatore g: findSquadraCalciatori()){
            ris.add(g.getId());
        }
        System.out.println(ris + "id svincolati");
        return ris;
    }

    // PS Verificare se un allenatore/dirigente possa avere più di una squadra, in
    // caso cambiare ritorno degli ultimi due metodi

}
