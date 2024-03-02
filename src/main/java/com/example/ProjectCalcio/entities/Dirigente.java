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
public class Dirigente extends Persona {
    private String username;
    private String password;
    private Squadra squadra;
}
