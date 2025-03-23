package com.wslogintoken.repository.impl;

import com.wslogintoken.model.entity.Usuario;
import com.wslogintoken.repository.IUsuarioRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepoImpl implements IUsuarioRepo {

    private final JdbcTemplate jdbcTemplate;

    public UsuarioRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Usuario> userRowMapper = (rs, rowNum) ->
            new Usuario(rs.getInt("id"), rs.getString("username"), rs.getString("password"));

    @Override
    public Optional<Usuario> findByUsername(String username) {
        String sql = "SELECT * FROM usuarios WHERE username = ?";
        return jdbcTemplate.query(sql, userRowMapper, username).stream().findFirst();
    }

    @Override
    public List<String> getRolesByUsuarioId(int userId) {
        String sql = "SELECT r.nombre FROM roles r " +
                     "JOIN usuario_rol ur ON r.id = ur.rol_id " +
                     "WHERE ur.usuario_id = ?";
        return jdbcTemplate.queryForList(sql, String.class, userId);
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        return jdbcTemplate.query(sql, userRowMapper);
    }
}
