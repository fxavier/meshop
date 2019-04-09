package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user_session")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long codigo;

    @Column(name = "numero_clicks")
    private Long numeroClicks;

    @Column(name = "data_sessao")
    private LocalDate dataSessao;

    @ManyToOne
    @JoinColumn(name = "codigo_user")
    private UserAccount userAccount;

    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;
}
