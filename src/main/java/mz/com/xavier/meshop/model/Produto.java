package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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

    @NotNull(message = "produto-2")
    @Column(name = "preco_compra")
    private BigDecimal precoCompra;

    @NotNull(message = "produto-3")
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    private BigDecimal iva;

    @Column(name = "preco_iva")
    private BigDecimal precoComIva;

    @Column(name = "outras_despesas")
    private BigDecimal outrasDespesas;

    private BigDecimal lucro;

    @Column(name = "stock_min")
    private BigDecimal stockMinimo;

    @Column(name = "stock_max")
    private BigDecimal stockMaximo;

    @NotNull(message = "produto-4")
    private Long quantidade;

    private String image1;

    @Column(name = "content_type1")
    private String contentType1;

    private String image2;

    @Column(name = "content_type2")
    private String contentType2;

    private String image3;

    @Column(name = "content_type3")
    private String contentType3;

    private String image4;

    @Column(name = "content_type4")
    private String contentType4;

    private String image5;

    @Column(name = "content_type5")
    private String contentType5;

    private String image6;

    @Column(name = "content_type6")
    private String contentType6;

    @NotNull(message = "produto-5")
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
