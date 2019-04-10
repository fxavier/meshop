package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @NotBlank(message = "categoria-1")
    private String nome;

    @Transient
    public Boolean isNovo() {
        return this.codigo == null;
    }

    @Transient
    public Boolean exists() {
        return this.codigo != null;
    }

}
