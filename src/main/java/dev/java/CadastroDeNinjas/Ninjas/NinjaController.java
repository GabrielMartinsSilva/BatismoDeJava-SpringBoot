package dev.java.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }


    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id
    @GetMapping("/listarID/{id}")
    public NinjaModel mostrarNinjasID(@PathVariable Long id) {
        return ninjaService.listarNinjasID(id);
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterar")
    public String alterarNinja() {
        return "Alterar ninja ";
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinjaID(id);
    }

}
