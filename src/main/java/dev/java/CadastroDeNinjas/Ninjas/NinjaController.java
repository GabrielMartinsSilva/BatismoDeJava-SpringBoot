package dev.java.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado !";
    }


    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public String mostrarNinja() {
        return "mostrar todos os ninjas !";
    }

    // Mostrar ninja por id
    @GetMapping("/listarID")
    public String mostrarNinjaID() {
        return "mostrar todos os ninjas por id !";
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Alterar ninja ";
    }

    // Deletar Ninja
    @DeleteMapping
    public String deletarNinja() {
        return "Deletar ninja ";
    }

}
