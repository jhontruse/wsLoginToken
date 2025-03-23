package com.wslogintoken.security;

import com.wslogintoken.model.entity.Usuario;
import com.wslogintoken.repository.IUsuarioRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Clase S4
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final IUsuarioRepo usuarioRepo;

    public JwtUserDetailsService(IUsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Usuario> user = usuarioRepo.findByUsername(username);

        List<GrantedAuthority> roles = new ArrayList<>();

        List<String> roleNames = usuarioRepo.getRolesByUsuarioId(user.get().getId());

        roleNames.forEach(roleName -> {
            roles.add(new SimpleGrantedAuthority(roleName));
        });

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), roles);
    }
}
