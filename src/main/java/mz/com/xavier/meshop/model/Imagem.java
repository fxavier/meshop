package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "imagem")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @Column(name = "content_type")
    private String contentType;

    @ManyToOne
    @JoinColumn(name = "codigo_produto")
    private Produto produto;
}
