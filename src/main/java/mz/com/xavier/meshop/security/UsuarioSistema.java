package mz.com.xavier.meshop.security;

import lombok.Getter;
import mz.com.xavier.meshop.model.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class UsuarioSistema extends User {

    private static final long serialVersionUID = 1L;

    @Getter
    private UserAccount userAccount;

    public UsuarioSistema(UserAccount userAccount, Collection<? extends GrantedAuthority> authorities) {
        super(userAccount.getEmail(), userAccount.getPassword(), authorities);
        this.userAccount = userAccount;
    }


}
