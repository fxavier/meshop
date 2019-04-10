package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "factura_detalhes")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacturaDetalhes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "codigo_factura")
    private Factura factura;

}
