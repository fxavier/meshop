package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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

    @Column(name = "numero_cartao")
    private String numeroCartao;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;

    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;
}
