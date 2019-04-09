package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "subcategoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;
}
