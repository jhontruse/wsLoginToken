package com.wslogintoken.service;

import com.wslogintoken.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    Optional<Usuario> findByUsername(String username);

    List<String> getRolesByUsuarioId(String username);

    List<Usuario> findAll();

}
