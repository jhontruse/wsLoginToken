package com.wslogintoken.service.impl;

import com.wslogintoken.model.entity.Usuario;
import com.wslogintoken.repository.IUsuarioRepo;
import com.wslogintoken.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioRepo iUsuarioRepo;

    public UsuarioServiceImpl(IUsuarioRepo iUsuarioRepo) {
        this.iUsuarioRepo = iUsuarioRepo;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        Optional<Usuario> userOpt = iUsuarioRepo.findByUsername(username);
        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public List<String> getRolesByUsuarioId(String username) {
        return iUsuarioRepo.findByUsername(username)
                .map(user -> iUsuarioRepo.getRolesByUsuarioId(user.getId()))
                .orElse(List.of());
    }

    @Override
    public List<Usuario> findAll() {
        return iUsuarioRepo.findAll();
    }
}
