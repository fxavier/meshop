package mz.com.xavier.meshop.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_grupo")
@Data
public class UsuarioGrupo {

    @EmbeddedId
    private UsuarioGrupoId id;

}
