package ma.ens.security.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {


    @GetMapping("/hello")
    public String sayHello() {
        return "Hello ! Vous êtes bien authentifié avec un JWT valide.";
    }


    @GetMapping("/admin")
    public String adminOnly() {
        return "Accès réservé à l'ADMIN : Félicitations, vous avez les bons privilèges.";
    }


    @GetMapping("/user")
    public String userOrAdmin() {
        return "Accès USER/ADMIN : Ce contenu est sécurisé mais accessible pour vous.";
    }
}