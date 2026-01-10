package dev.java.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Seja bem vindo a primeira rota criada !";
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado !";
    }


    // Mostrar todos os ninjas
    @GetMapping("/todos")
    public String mostrarNinja() {
        return "mostrar todos os ninjas !";
    }

    // Mostrar ninja por id
    @GetMapping("/todosID")
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
