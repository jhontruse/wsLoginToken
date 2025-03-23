package com.wslogintoken.repository;

import com.wslogintoken.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioRepo {

    Optional<Usuario> findByUsername(String username);

    List<String> getRolesByUsuarioId(int userId);

    List<Usuario> findAll();

}
