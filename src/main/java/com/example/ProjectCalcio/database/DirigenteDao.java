package com.example.ProjectCalcio.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Entity;

public class DirigenteDao implements IDao {

	@Autowired
	private Database db;

	@Autowired
	private ApplicationContext context;

	@Override
	public boolean create(Entity e) {
		String query = "insert into persone(nome, cognome, eta) values(?, ?, ?)";
		boolean ris = false;
		ris = db.eseguiUpdate(query,
				((Dirigente) e).getNome(),
				((Dirigente) e).getCognome(),
				((Dirigente) e).getEta() + "");

		query = "insert into dirigenti(id) values((select max(id) from persone))";
		ris &= db.eseguiUpdate(query);

		return ris;
	}

	//Comprare
	 public boolean Acquisto(int idSvincolato, int idSquadra){

		boolean ris1 = false;
		boolean ris2= false;
		
		String query1 = "update giocatori set id_squadra = ? where giocatori.id = ?;";
		ris1 = db.eseguiUpdate(query1, idSquadra+"", idSvincolato+"" );
		String query2 = "update squadre set budget =((select budget where id = ?)-" +
		"(select costo from giocatori where giocatori.id = ?)) where squadre.id =?";
		ris2 = db.eseguiUpdate(query2, idSquadra + "", idSvincolato +"", idSquadra + "");
		

        return ris1 && ris2;

    }
	//Vendere
	public boolean Vendi(int idGiocatore, int idSquadra){
		Boolean ris;
		Boolean ris1;

		String query = "update giocatori set id_squadra = null where id =?";
		ris = db.eseguiUpdate(query, idGiocatore+"");
		String query1 = "update squadre set budget = ((select budget where id = ?) +" + 
		"(select costo from giocatori where giocatori.id = ?)) where squadre.id = ?;";
		ris1 = db.eseguiUpdate(query1, idSquadra+"", idGiocatore+"", idSquadra + "");

		return ris && ris1;
	}



	@Override
	public Map<Integer, Entity> read() {
		String query = "select * from persone p inner join dirigenti d on p.id = d.id";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query);

		// Set<Entry<Integer, Map<String, String>>> listaCoppie = result.entrySet();

		Map<Integer, Entity> ris = new HashMap<>();
		for (Entry<Integer, Map<String, String>> entry : result.entrySet()) {
			Entity e = context.getBean(Dirigente.class, entry.getValue());
			ris.put(entry.getKey(), e);
		}
		return ris;
	}

	public Entity readOne(int idDirigente) {
		String query = "select * from persone p inner join dirigenti d on p.id = d.id where p.id=?";
		Map<Integer, Map<String, String>> result = db.eseguiQuery(query, idDirigente + "");

		if (result.values().size() == 1) {
			Entity e = context.getBean(Dirigente.class, new ArrayList<>(result.values()).get(0));
			return e;
		} else {
			return null;
		}
	}



	@Override
	public boolean update(Entity e) {
		String query = "update persone set nome=?, cognome=?, data_nascita=? where id=?";
		boolean ris = false;
		ris = db.eseguiUpdate(query, ((Dirigente) e).getNome(), ((Dirigente) e).getCognome(),
				((Dirigente) e).getEta() + "", ((Dirigente) e).getId() + "");
		return ris;
	}
	
	@Override
	public boolean delete(int id) {
		String query = "delete from persone where id=?";
		return db.eseguiUpdate(query, id + "");
	}
}