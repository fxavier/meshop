package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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

    private String nome;

    private String descricao;

    @Column(name = "preco_compra")
    private BigDecimal precoCompra;

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

    private Long quantidade;

    @Column(name = "img_url1")
    private String imgUrl1;

    @Column(name = "img_url2")
    private String imgUrl2;

    @Column(name = "img_url3")
    private String imgUrl3;

    @Column(name = "img_url4")
    private String imgUrl4;

    @Column(name = "img_url5")
    private String imgUrl5;

    @Column(name = "img_url6")
    private String imgUrl6;

    @ManyToOne
    @JoinColumn(name = "codigo_subcategoria")
    private Subcategoria subcategoria;
}
