package app.controllers;

import app.Devinette;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


@Controller
@SessionAttributes("devinette")
public class IndexController {

    @GetMapping("/")
    public String index(@Valid Devinette devinette) {
        return "index";
    }

    @PostMapping(value = "/", params = "valider")
    public String traitement(@Validated Devinette devinette, BindingResult br, SessionStatus session) {
        if (devinette.isFound()) {
            devinette.reset();
            session.setComplete(); // termine la session courante
        }

        return "index";
    }

    @PostMapping(value = "/", params = "nouveau")
    public String nouveau(@Valid Devinette devinette, BindingResult br, SessionStatus session) {
        devinette.reset();
        session.setComplete();
        return "index";
    }

}