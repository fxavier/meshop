package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "cartao_credito")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @NotBlank(message = "cartao-1")
    @Column(name = "numero_cartao")
    private String numeroCartao;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;

    @NotNull(message = "cartao-2")
    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;

    @Transient
    public Boolean isNovo() {
        return this.codigo == null;
    }

    @Transient
    public Boolean existes() {
       return this.codigo != null;
    }
}
