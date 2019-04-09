package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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
}
