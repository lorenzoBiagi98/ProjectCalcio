package com.example.ProjectCalcio.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ProjectCalcio.entities.Entity;
import com.example.ProjectCalcio.entities.Giocatore;

public class GiocatoreDao implements IDao {

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into persone(nome, cognome, eta) values(?, ?, ?)";
        boolean ris = false;
        ris = db.eseguiUpdate(query,
                ((Giocatore) e).getNome(),
                ((Giocatore) e).getCognome(),
                ((Giocatore) e).getEta() + "");

        query = "insert into giocatori(id) values((select max(id) from persone))";
        ris = db.eseguiUpdate(query);

        return ris;
    }


    @Override
    public Map<Integer, Entity> read() {
        String query = "select * from persone p inner join giocatori d on p.id = d.id";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        // Set<Entry<Integer, Map<String, String>>> listaCoppie = result.entrySet();

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Entity e = context.getBean(Giocatore.class, entry.getValue());
            ris.put(entry.getKey(), e);
        }
        return ris;
    }

    public Entity readOne(int idGiocatori) {
        String query = "select * from persone p inner join giocatori d on p.id = d.id where p.id=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idGiocatori + "");

        if (result.values().size() == 1) {
            Entity e = context.getBean(Giocatore.class, new ArrayList<>(result.values()).get(0));
            return e;
        } else {
            return null;
        }
    }

    public Map<Integer, Entity> readFromIdSquadra(int idSquadra) {
        String query = "select * from giocatori g inner join squadre s on g.id = s.id where g.id_squadra=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idSquadra + "");

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Giocatore g = context.getBean(Giocatore.class, entry.getValue());
            // s.setClasse((Classe) classeDAO.readOne(s.getClasse().getId()));
            ris.put(entry.getKey(), g);
        }
        return ris;
    }


    public Map<Integer, Entity> readFromPrezzo(double prezzo) {
        String query = "select * from giocatori g inner join squadre s on g.id = s.id where g.prezzo < ?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, prezzo+ "");

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Giocatore g = context.getBean(Giocatore.class, entry.getValue());
            // s.setClasse((Classe) classeDAO.readOne(s.getClasse().getId()));
            ris.put(entry.getKey(), g);
        }
        return ris;
    }

    public Map<Integer, Entity> readFromCognome(String cognome) {
        String query = "select * from giocatori g inner join persone p on g.id = p.id where p.cognome = ?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, cognome + "");

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Giocatore g = context.getBean(Giocatore.class, entry.getValue());
            // s.setClasse((Classe) classeDAO.readOne(s.getClasse().getId()));
            ris.put(entry.getKey(), g);
        }
        return ris;
    }

    public boolean trasferimento(){
       return false;
    }

    @Override
    public boolean update(Entity e) {
        String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
        boolean ris = false;
        ris = db.eseguiUpdate(query, ((Giocatore) e).getNome(), ((Giocatore) e).getCognome(),
                ((Giocatore) e).getEta() + "", ((Giocatore) e).getId() + "");
        return ris;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from persone where id=?";
        return db.eseguiUpdate(query, id + "");
    }
}