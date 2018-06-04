package com.osornet.estudio.spring.dao;

import java.util.List;

import com.osornet.estudio.spring.pojo.Usuario;

/**
 * UsuarioDao
 */
public interface UsuarioDao {

    public Usuario findByUsername(String username);

	public void save(Usuario usuario);

	public List<Usuario> findAll();
    
}