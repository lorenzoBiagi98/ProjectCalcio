package com.example.ProjectCalcio.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ProjectCalcio.database.UserDao;
import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Dirigente;


public class LoginService {

    @Autowired
    UserDao userDao;

    @Autowired
    PersonaService personaService;

    //Metodo che mi inserisce in una lista di mappe le credenziali di tutti gli allenatori
    public List<Map<String,String>> listaCredenzialiAllenatori(){
        List<Map<String,String>> lista = new ArrayList<>();
        List<Allenatore> listaAllenatori = personaService.findAllAllenatori();       
        for(Allenatore a : listaAllenatori){
            Map<String,String> listaCredenziali = new HashMap<>();
            listaCredenziali.put("username", a.getUsername());
            listaCredenziali.put("password", a.getPassword());
            lista.add(listaCredenziali);
        }
        return lista;
    }

       //Metodo che mi inserisce in una lista di mappe le credenziali di tutti i dirigenti
    public List<Map<String,String>> listaCredenzialiDirigenti(){
        List<Map<String,String>> lista = new ArrayList<>();
        List<Dirigente> listaDirigenti = personaService.findAllDirigenti();
        for(Dirigente d : listaDirigenti){
            Map<String,String> listaCredenziali = new HashMap<>();
            listaCredenziali.put("username", d.getUsername());
            listaCredenziali.put("password", d.getPassword());
            lista.add(listaCredenziali);
        }
        return lista;
    }

    // Metodo che mi ritorna una PERSONA(ALLENATORE) in base all' username e alla
    // password
    public Allenatore checkAndReturnLoginAllenatore(String username, String password) {
        return userDao.readUsernameAndPasswordAllenatore(username, password);
    }

    // Metodo che mi ritorna una PERSONA(DIRIGENTE) in base all' username e alla
    // password
    public Dirigente checkAndReturnLoginDirigente(String username, String password) {
        return userDao.readUsernameAndPasswordDirigente(username, password);
    }

}
