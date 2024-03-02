package com.example.ProjectCalcio.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Giocatore extends Persona {
    private int costo;
    private Squadra squadra;

    public void setIdSquadra(int idSquadra) {
        if (squadra == null) {
            squadra = new Squadra();
            squadra.setId(idSquadra);
        }
    }

    public int setIdGiocatore(int idGiocatore){
        return idGiocatore;
    }
}
