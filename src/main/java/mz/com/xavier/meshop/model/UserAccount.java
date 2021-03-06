package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user_account")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    private String nome;

    private String sobrenome;

    private String apelido;

    private String email;

    private String password;

    private String phone;

    @Column(name = "numero_visitas")
    private Long numeroVisitas;

    @Column(name = "numero_transacoes")
    private Long numeroTransacoes;

    @Column(name = "valor_total_transacao")
    private BigDecimal valorTotalTransacao;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_account_permissao", joinColumns = @JoinColumn(name = "codigo_usuario")
               , inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
    private List<Permissao> permissoes;
}
