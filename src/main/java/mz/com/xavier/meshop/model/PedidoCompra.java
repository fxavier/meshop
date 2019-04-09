package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pedido_compra")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PedidoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusPedido statusPedido;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;


}
