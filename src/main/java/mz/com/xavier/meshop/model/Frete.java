package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "frete")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(name = "metodo_frete")
    private String metodoFrete;

    @Column(name = "charge_code")
    private Long chargeCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusFrete statusFrete;

    @Column(name = "data_frete")
    private LocalDate dataFrete;

    @Column(name = "valor_frete")
    private BigDecimal valorFrete;

    @ManyToOne
    @JoinColumn(name = "codigo_pedido")
    private PedidoCompra pedidoCompra;
}
