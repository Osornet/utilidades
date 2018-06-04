package com.osornet.estudio.spring.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.osornet.estudio.spring.dao.UsuarioDao;
import com.osornet.estudio.spring.pojo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UsuarioServicio
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

	public void save(Usuario usuario) {
        Timestamp fechaCreacion = new Timestamp(new Date().getTime());
        usuario.setFechaCreacion(fechaCreacion);
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        this.usuarioDao.save(usuario);
	}

	public List<Usuario> findAll() {
		return this.usuarioDao.findAll();
	}
    
}