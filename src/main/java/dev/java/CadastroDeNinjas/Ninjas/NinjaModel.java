package dev.java.CadastroDeNinjas.Ninjas;

import dev.java.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")

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

    @Column(name = "img_url")
    private String img_url;

    @Column (name = "rank")
    private String rank;

    @JoinColumn (name = "missoes_id" )
    @ManyToOne
    private MissoesModel missoes;


}
