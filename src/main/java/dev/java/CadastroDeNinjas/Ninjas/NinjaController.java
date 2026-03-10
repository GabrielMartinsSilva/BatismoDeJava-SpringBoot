package dev.java.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Adicionar ninja
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description ="Rota cria um novo ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso "),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja ")

    })

    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO ninjaNovo = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso !" + ninjaNovo.getNome());
    }

    // Mostrar todos os ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }


    // ResponseEntity<?> está passando como parametro um generic, aceitando o retorno de qualquer tipo
    @GetMapping("/listarID/{id}")
    public ResponseEntity<?> mostrarNinjasID(@PathVariable Long id) {
        if(ninjaService.listarNinjasID(id) != null) {
            NinjaDTO ninjasID = ninjaService.listarNinjasID(id);
            return ResponseEntity.ok(ninjasID);

        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não foi encontrado !");

        }

    }

    // Alterar dados dos ninjas
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por id", description ="Rota cria um novo ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso "),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })

    public ResponseEntity<String> alterarNinja(
            @Parameter(description = "Usuario envia ID no path da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuario envia dados do ninja no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado) {
        if(ninjaService.listarNinjasID(id) != null) {
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("O ninja " + ninjaNovo.getNome() + " foi atualizado com sucesso !");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja " + ninjaAtualizado.getNome() + " não foi encontrado na nossa base de dados !");
        }
    }

    // Deletar Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if(ninjaService.listarNinjasID(id) != null) {
            ninjaService.deletarNinjaID(id);
            return ResponseEntity.ok("Ninja com o id " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id " + id + " não encontrado !");
        }

    }



}
