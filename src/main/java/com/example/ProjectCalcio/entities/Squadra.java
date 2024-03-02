package com.example.ProjectCalcio.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Squadra extends Campionato {
    private String nome;
    private double budget;
    private int punti;
    private Allenatore allenatore;
    private Dirigente dirigente;
    private Campionato campionato;
    private List<Giocatore> listaCalciatori;

    public void setIdDirigente(int idDirigente) {
        if (dirigente == null) {
            dirigente = new Dirigente();
            dirigente.setId(idDirigente);
        }
    }

    public void setIdAllenatore(int idAllenatore) {
        if (allenatore == null) {
            allenatore = new Allenatore();
            allenatore.setId(idAllenatore);
        }
    }

    public void setIdCampionato(int idCampionato) {
        if (campionato == null) {
            campionato = new Campionato();
            campionato.setId(idCampionato);
        }
    }

    public int setIdSquadre(int idSquadra){
        return idSquadra;
    }
}
