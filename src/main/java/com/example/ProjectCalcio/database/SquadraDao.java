package com.example.ProjectCalcio.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Campionato;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Entity;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;

public class SquadraDao implements IDao {

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    // Create
    @Override
    public boolean create(Entity e) {
        String query = "insert into squadre(nome, budget, punti, id_campionato, id_dirigente, id_allenatore) values(?, ?, ?, ?, ?)";
        boolean ris = false;
        Campionato c = (Campionato) e;
        Dirigente d = (Dirigente) e;
        Allenatore a = (Allenatore) e;

        ris = db.eseguiUpdate(query,
                ((Squadra) e).getNome(),
                ((Squadra) e).getBudget() + "",
                ((Squadra) e).getPunti() + "",
                c.getId() + "",
                d.getId() + "",
                a.getId() + "");

        return ris;
    }

    // Mi ritorna una mappa con tutte le squadre
    @Override
    public Map<Integer, Entity> read() {
        String query = "select * from squadre";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Squadra s = context.getBean(Squadra.class, entry.getValue());

            ris.put(entry.getKey(), s);
        }
        return ris;
    }

    // Mi ritorna una mappa con tutte le squadre per allenatore
    public Map<Integer, Entity> readAllenatoriPerSquadra() {
        String query = "select * from ALLENATORI_SQUADRE";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Squadra s = context.getBean(Squadra.class, entry.getValue());
            ris.put(entry.getKey(), s);
        }
        return ris;
    }

    //Mi ritorna una squadra in base al suo id
     public Entity readOne(int idSquadra) {
        String query = "select * squadre where id = ?;";
            Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idSquadra+"");

        if (result.values().size() == 1) {
            Entity e = context.getBean(Giocatore.class, new ArrayList<>(result.values()).get(0));
            return e;
        } else {
            return null;
        }
    }

    // Mi ritorna una mappa con tutte le squadre per dirigenti
    public Map<Integer, Entity> readDirigentiPerSquadra() {
        String query = "select * from DIRIGENTI_SQUADRE";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Squadra s = context.getBean(Squadra.class, entry.getValue());
            ris.put(entry.getKey(), s);
        }
        return ris;
    }
    
    //Ritorna una squadra in base a id del dirigente
    public Entity readOneSquadra(int idDirigente) {
        String query = "select squadre.id,squadre.nome,squadre.budget from squadre where id_dirigente = ?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idDirigente+ "");
        if (result.values().size() == 1) {
            Entity e = context.getBean(Squadra.class, new ArrayList<>(result.values()).get(0));
            return e;
        } else {
            return null;
        }
    }

     public Entity readOneSquadraAllenatore(int idAllenatore) {
        String query = "select squadre.id,squadre.nome,squadre.budget from squadre where id_allenatore = ?;";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idAllenatore+ "");
        if (result.values().size() == 1) {
            Entity e = context.getBean(Squadra.class, new ArrayList<>(result.values()).get(0));
            return e;
        } else {
            return null;
        }
    }

    // Mi ritorna una mappa con tutte le squadre per calciatori(svincolati)
    public Map<Integer, Entity> readCalciatoriPerSquadra() {
        String query = "select * from GIOCATORI_noSQUADRA";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            //Squadra s = context.getBean(Squadra.class, entry.getValue());   
            Giocatore c = context.getBean(Giocatore.class, entry.getValue());
            ris.put(entry.getKey(), c);
        }
        return ris;
    }
 
// Mi ritorna una mappa con tutte le squadre per calciatori

     public Map<Integer, Entity> readCalciatoriPerSquadra(int idDirigente) {
        String query = "select g.nome, g.cognome, g.eta, g.costo, d.id, g.id as idGioc from squadre s left join GIOCATORI_P g on s.id = g.id_squadra left join DIRIGENTI_P d on s.id = d.id_squadra where d.id = ?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery1(query, idDirigente+ "");
        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            //Squadra s = context.getBean(Squadra.class, entry.getValue());   
            Entity c = context.getBean(Giocatore.class, entry.getValue());
            ris.put(entry.getKey(), c);
        }
        return ris;
    }

       public Map<Integer, Entity> readCalciatoriPerSquadraA(int idAllenatore) {
        String query = "select g.nome, g.cognome, g.eta, g.costo, a.id, g.id as idGioc from squadre s left join GIOCATORI_P g on s.id = g.id_squadra left join ALLENATORI_P a on s.id = a.id_squadra where a.id = ?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery1(query, idAllenatore+ "");
        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            //Squadra s = context.getBean(Squadra.class, entry.getValue());   
            Entity c = context.getBean(Giocatore.class, entry.getValue());
            ris.put(entry.getKey(), c);
        }
        return ris;
    }
    

    // Update
    @Override
    public boolean update(Entity e) {
        String query = "update squadre set nome=?, budget=?, punti=?, id_campionato=?, id_dirigente, id_allenatore where id=?";
        boolean ris = false;
        Campionato c = (Campionato) e;
        Dirigente d = (Dirigente) e;
        Allenatore a = (Allenatore) e;

        ris = db.eseguiUpdate(query, ((Squadra) e).getNome(), ((Squadra) e).getBudget() + "",
                ((Squadra) e).getPunti() + "", c.getId() + "", d.getId() + "", a.getId() + "",
                ((Squadra) e).getId() + "");
        return ris;
    }

    // Delete
    @Override
    public boolean delete(int id) {
        String query = "delete from squadre where id=?";
        return db.eseguiUpdate(query, id + "");
    }
}