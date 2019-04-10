package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subcategoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @NotBlank(message = "subcategoria-1")
    private String nome;

    @NotNull(message = "subcategoria-2")
    @ManyToOne
    @JoinColumn(name = "codigo_categoria")
    private Categoria categoria;

    @Transient
    public Boolean isNovo() {
        return this.codigo == null;
    }

    @Transient
    public Boolean exists() {
        return this.codigo != null;
    }
}
