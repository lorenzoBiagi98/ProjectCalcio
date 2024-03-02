package com.example.ProjectCalcio.configutations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.ProjectCalcio.database.AllenatoreDao;
import com.example.ProjectCalcio.database.Database;
import com.example.ProjectCalcio.database.DirigenteDao;
import com.example.ProjectCalcio.database.GiocatoreDao;
import com.example.ProjectCalcio.database.SquadraDao;
import com.example.ProjectCalcio.database.UserDao;

@Configuration
public class DatabaseContext {

    @Bean
    public Database newDatabase() {
        return new Database("football1");
    }

    @Bean
    public AllenatoreDao newAllenatoreDao() {
        return new AllenatoreDao();
    }

    @Bean
    public DirigenteDao newDirigenteDao() {
        return new DirigenteDao();
    }

    @Bean
    public SquadraDao newSquadraDao() {
        return new SquadraDao();
    }

    @Bean
    public UserDao newUserDao(){
        return new UserDao();
    }

    @Bean
    public GiocatoreDao newGiocatoreDao(){
        return new GiocatoreDao();
    }

}
