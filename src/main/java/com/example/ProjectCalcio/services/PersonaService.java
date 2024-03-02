package com.example.ProjectCalcio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ProjectCalcio.database.AllenatoreDao;
import com.example.ProjectCalcio.database.DirigenteDao;
import com.example.ProjectCalcio.database.GiocatoreDao;
import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Giocatore;

public class PersonaService {

    @Autowired
    AllenatoreDao allenatoreDao;

    @Autowired
    DirigenteDao dirigenteDao;

    @Autowired
    GiocatoreDao giocatoreDao;

    // Ritorna un ALLENATORE by ID
    public Allenatore findAllenatoreById(int idAllenatore) {
        return (Allenatore) allenatoreDao.readOne(idAllenatore);
    }

    // Ritorna una LISTA di ALLENATORI
    public List<Allenatore> findAllAllenatori() {
        return allenatoreDao.read().values().stream().map(e -> (Allenatore) e).toList();
    }

    // Ritorna una LISTA di DIRIGENTI
    public List<Dirigente> findAllDirigenti() {
        return dirigenteDao.read().values().stream().map(e -> (Dirigente) e).toList();
    }

    // Ritorna un DIRIGENTE by ID
    public Dirigente findDirigenteById(int idDirigente) {
        return (Dirigente) dirigenteDao.readOne(idDirigente);
    }

    // Ritorna un GIOCATORE by ID
    public Giocatore findGiocatoreById(int idGiocatore) {
        return (Giocatore) giocatoreDao.readOne(idGiocatore);
    }

    // Ritorna un GIOCATORE by ID_SQUADRA !!!!
    public List<Giocatore> findGiocatoreByIdSquadra(int idSquadra) {
        return (List<Giocatore>) giocatoreDao.readFromIdSquadra(idSquadra).values().stream().map(e -> (Giocatore) e)
                .toList();
    }

    // Ritorna una LISTA di GIOCATORI by ID_SQUADRA
    public List<Giocatore> findGiocatoriByPrezzo(double prezzo) {
        return giocatoreDao.read().values().stream().map(e -> (Giocatore) e).toList();
    }

    // Ritorna una LISTA di GIOCATORI by ETA'
    public List<Giocatore> findGiocatoriByEta(int eta) {
        return giocatoreDao.read().values().stream().map(e -> (Giocatore) e).toList();
    }

    // Ritorna una LISTA di GIOCATORI by COGNOME
    public List<Giocatore> findGiocatoriByCognome(String cognome) {
        return giocatoreDao.read().values().stream().map(e -> (Giocatore) e).toList();
    }

    // Ritorna una LISTA con tutti i GIOCATORI
    public List<Giocatore> findAllGiocatori() {
        return giocatoreDao.read().values().stream().map(e -> (Giocatore) e).toList();
    }

}
