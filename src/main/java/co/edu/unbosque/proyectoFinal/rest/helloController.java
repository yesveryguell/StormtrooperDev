package co.edu.unbosque.proyectoFinal.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/hola")
    public String hello(){
        return "Hello World que tal! vp";
    }
}
