package com.example.ProjectCalcio.controllers;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ProjectCalcio.entities.Dirigente;
import com.example.ProjectCalcio.entities.Allenatore;
import com.example.ProjectCalcio.services.LoginService;
import com.example.statics.Controlli;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @Autowired
    private Controlli controlli;

    //Pagina di LOGIN visualizzata correttamente!
    @GetMapping("/loginpage")
    public String loginPage(HttpSession session){
        if(session.getAttribute("login") != null){
            if("OK".equals(session.getAttribute("login").toString())){
                
                switch(session.getAttribute("ruolo").toString().toLowerCase()){
                    case "allenatore":
                        return "redirect:/allenatore.html";
                    case "dirigente":
                        return "redirect:/areaDirigente";
                    default:
                        session.invalidate();
                        return "/logout";
                }
                 
            }
        } 
        return "login.html";
    }

    @PostMapping("/login1")
	public String login(@RequestParam Map<String, String> params, HttpSession session) {
		Allenatore a = null;
		Dirigente dg = null;
			if(controlli.controlloLoginAllenatore(params.get("username"), params.get("password"))){
			a = loginService.checkAndReturnLoginAllenatore(params.get("username"), params.get("password"));
			if(a !=null) {
				session.setAttribute("login", "OK");
				session.setAttribute("id", a.getId());
                session.setAttribute("ruolo", "allenatore");
				return "redirect:/areaAllenatore";
			}
			
		}else if(controlli.controlloLoginDirigente(params.get("username"),params.get("password"))) {
			dg = loginService.checkAndReturnLoginDirigente(params.get("username"), params.get("password"));
			if(dg != null) {
				session.setAttribute("login", "OK");
				session.setAttribute("id", dg.getId());
                session.setAttribute("ruolo", "dirigente");
				return "redirect:/areaDirigente";
			}
		}
		return "redirect:/loginpage";
	}
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/loginpage";
    }
}
