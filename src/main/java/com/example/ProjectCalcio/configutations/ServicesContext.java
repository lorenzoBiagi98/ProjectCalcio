package com.example.ProjectCalcio.configutations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ProjectCalcio.services.LoginService;
import com.example.ProjectCalcio.services.PersonaService;
import com.example.ProjectCalcio.services.SquadraService;
import com.example.statics.Controlli;

@Configuration
public class ServicesContext {

    @Bean
    public PersonaService newPersonaService() {
        return new PersonaService();
    }

    @Bean
    public LoginService newLoginService() {
        return new LoginService();
    }

    @Bean
    public SquadraService newSquadraService() {
        return new SquadraService();
    }

    @Bean 
    public Controlli newControlli(){
        return new Controlli();
    }

    

}
