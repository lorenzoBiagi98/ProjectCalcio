package com.example.ProjectCalcio.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Entity;

public class AllenatoreDao implements IDao {

    @Autowired
    private Database db;

    @Autowired
    private ApplicationContext context;

    @Override
    public boolean create(Entity e) {
        String query = "insert into persone(nome, cognome, eta) values(?, ?, ?)";
        boolean ris = false;
        ris = db.eseguiUpdate(query,
                ((Allenatore) e).getNome(),
                ((Allenatore) e).getCognome(),
                ((Allenatore) e).getEta() + "");

        query = "insert into allenatori(id) values((select max(id) from persone))";
        ris &= db.eseguiUpdate(query);

        return ris;
    }

    @Override
    public Map<Integer, Entity> read() {
        String query = "select * from persone p inner join allenatori a on p.id = a.id";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

        // Set<Entry<Integer, Map<String, String>>> listaCoppie = result.entrySet();

        Map<Integer, Entity> ris = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
            Entity e = context.getBean(Allenatore.class, entry.getValue());
            ris.put(entry.getKey(), e);
        }
        return ris;
    }

    public Entity readOne(int idAllenatore) {
        String query = "select * from persone p inner join allenatori a on p.id = a.id where p.id=?";
        Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idAllenatore + "");

        if (result.values().size() == 1) {
            Entity e = context.getBean(Allenatore.class, new ArrayList<>(result.values()).get(0));
            return e;
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Entity e) {
        String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
        boolean ris = false;
        ris = db.eseguiUpdate(query, ((Allenatore) e).getNome(), ((Allenatore) e).getCognome(),
                ((Allenatore) e).getEta() + "", ((Allenatore) e).getId() + "");
        return ris;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from persone where id=?";
        return db.eseguiUpdate(query, id + "");
    }

}
