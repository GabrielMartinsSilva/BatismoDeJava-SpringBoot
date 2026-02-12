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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.criarNinja(ninjaDTO);
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por id
    @GetMapping("/listarID/{id}")
    public NinjaDTO mostrarNinjasID(@PathVariable Long id) {
        return ninjaService.listarNinjasID(id);
    }

    // Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinjaID(id);
    }



}
