
package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    private String sku;

    @NotBlank(message = "produto-1")
    private String nome;

    private String descricao;

    @Column(name = "preco_antigo")
    private BigDecimal precoAntigo;

    @NotNull(message = "produto-2")
    @Column(name = "preco_novo")
    private BigDecimal precoNovo;

  /*  private BigDecimal iva;

    @Column(name = "preco_iva")
    private BigDecimal precoComIva;

    @Column(name = "outras_despesas")
    private BigDecimal outrasDespesas;

    private BigDecimal lucro;

    @Column(name = "stock_min")
    private BigDecimal stockMinimo;

    @Column(name = "stock_max")
    private BigDecimal stockMaximo;*/

    @NotNull(message = "produto-3")
    private Long quantidade;

    @OneToMany
    private List<Imagem> imagens;

    @NotNull(message = "produto-4")
    @ManyToOne
    @JoinColumn(name = "codigo_subcategoria")
    private Subcategoria subcategoria;

    @Transient
    public Boolean isNovo() {
        return this.codigo == null;
    }

    @Transient
    public Boolean exists() {
        return this.codigo != null;
    }
}
