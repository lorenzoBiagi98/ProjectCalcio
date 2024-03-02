package com.example.ProjectCalcio.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Persona;
import java.util.*;

public class UserDao {
    @Autowired
    private Database db;

    @Autowired
    ApplicationContext context;

    @Autowired
    AllenatoreDao allenatoreDao;

    @Autowired
    DirigenteDao dirigenteDao;

    // Questo metodo mi ritorna un oggetto di tipo DIRIGENTE, in base a USERNAME E
    // PASSWORD corretti
    public Dirigente readUsernameAndPasswordDirigente(String username, String password) {
        String query = "select * from dirigenti where username=? and password=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, username, password);

        if (result.values().size() == 1) {
            int idDirigente = Integer.parseInt(new ArrayList<>(result.values()).get(0).get("id"));
            Dirigente d = (Dirigente) dirigenteDao.readOne(idDirigente);
            if (d != null) {
                return d;
            } else {
                System.err.println("ERRORE LETTURA UTENZA");
                return null;
            }
        } else {

            return null;
        }

    }

    // Questo metodo mi ritorna un oggetto di tipo ALLENATORE, in base a USERNAME E
    // PASSWORD corretti
    public Allenatore readUsernameAndPasswordAllenatore(String username, String password) {
        String query = "select * from allenatori where username=? and password=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, username, password);

        if (result.values().size() == 1) {
            int idAllenatore = Integer.parseInt(new ArrayList<>(result.values()).get(0).get("id"));
            Allenatore a = (Allenatore) allenatoreDao.readOne(idAllenatore);

            if (a != null) {
                return a;
            } else {
                System.err.println("ERRORE LETTURA UTENZA");
                return null;
            }

        } else {

            return null;
        }

    }

    // METODO NON FUNZIONANTE, DA RIVEDERE!
    // Tramite una persona p non riesco a utilizzare username e password,
    // momentaneamente ho lasciato
    // Dirigente d = new Dirigente();
    public boolean creaUtenza(Persona p) {

        boolean ris = false;
        if (p instanceof Dirigente) {
            Dirigente d = new Dirigente();

            String query = "update dirigenti set username=?, password=? where id=?";
            ris = db.eseguiUpdate(query, d.getUsername(), d.getPassword(), d.getId() + "");
        } else if (p instanceof Allenatore) {
            Allenatore a = new Allenatore();
            String query = "update allenatori set username=?, password=? where id=?";
            ris = db.eseguiUpdate(query, a.getUsername(), a.getPassword(), a.getId() + "");
        }

        return ris;
    }
}
