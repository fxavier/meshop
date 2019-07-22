package mz.com.xavier.meshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
public class UsuarioGrupoId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "codigo_usuario")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "codigo_grupo")
    private Grupo grupo;
}
