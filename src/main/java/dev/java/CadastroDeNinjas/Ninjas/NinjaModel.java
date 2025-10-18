package dev.java.CadastroDeNinjas.Ninjas;

import dev.java.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @JoinColumn (name = "missoes_id" )
    @ManyToOne
    private MissoesModel missoes;


}
