package com.example.ProjectCalcio.configutations;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.entities.Campionato;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Giocatore;
import com.example.ProjectCalcio.entities.Squadra;

@Configuration
public class EntitiesContext {

    @Bean
    @Scope("prototype")
    public Allenatore newAllenatore(Map<String, String> params) {
        return (Allenatore) new Allenatore().fromMap(params);
    }

    @Bean
    @Scope("prototype")
    public Dirigente newDirigente(Map<String, String> params) {
        return (Dirigente) new Dirigente().fromMap(params);
    }

    @Bean
    @Scope("prototype")
    public Giocatore newGiocatore(Map<String, String> params) {
        return (Giocatore) new Giocatore().fromMap(params);
    }

    @Bean
    @Scope("prototype")
    public Squadra newSquadra(Map<String, String> params) {
        return (Squadra) new Squadra().fromMap(params);
    }

    @Bean
    @Scope("prototype")
    public Campionato newCampionato(Map<String, String> params) {
        return (Campionato) new Campionato().fromMap(params);
    }

}
