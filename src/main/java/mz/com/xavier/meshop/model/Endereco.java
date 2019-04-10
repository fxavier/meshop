package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "endereco")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    private String nome;

    @Column(name = "end1")
    private String endereco1;

    @Column(name = "end2")
    private String endereco2;

    private String cidade;

    private String bairro;

    @Column(name = "av_rua")
    private String avOuRua;

    @Column(name = "numero_casa")
    private String numeroCasa;
}
