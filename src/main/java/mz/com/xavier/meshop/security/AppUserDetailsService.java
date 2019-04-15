package mz.com.xavier.meshop.security;

import mz.com.xavier.meshop.model.UserAccount;
import mz.com.xavier.meshop.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserAccount> foundUser = userAccountRepository.findByEmail(email);
        UserAccount userAccount = foundUser.orElseThrow(() -> new UsernameNotFoundException("usuario e/ou senha incorrectos"));
        return new User(email, userAccount.getPassword(), getPermissoes(userAccount));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(UserAccount userAccount) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        userAccount.getPermissoes().forEach(permissao -> authorities.add(new SimpleGrantedAuthority(permissao.getDescricao().toUpperCase())));
        return authorities;
    }
}
