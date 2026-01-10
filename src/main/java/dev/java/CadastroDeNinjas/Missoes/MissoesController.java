package dev.java.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String missao() {
        return "Pagina de missoes !";
    }

    @GetMapping("/listarID")
    public String missao() {
        return "Pagina de missoes por id !";
    }

    @PostMapping("/criar")
    public String criarMissao() {
        return "missao criada !";
    }

    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missao alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missao deletada com sucesso";
    }



}
