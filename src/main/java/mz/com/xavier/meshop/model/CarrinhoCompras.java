package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "carrinho_compras")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarrinhoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    private Boolean activo;

    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusCarrinho statusCarrinho;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;
}
