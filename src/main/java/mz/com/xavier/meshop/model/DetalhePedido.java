package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "detalhes_pedido")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DetalhePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codigo_produto")
    private Produto produto;

    private Integer quantidade;
}
