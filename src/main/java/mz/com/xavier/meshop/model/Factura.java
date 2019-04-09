package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_numero")
    @EqualsAndHashCode.Include
    private Long facturaNumero;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusFactura statusFactura;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;


}
