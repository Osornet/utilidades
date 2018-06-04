package com.osornet.estudio.spring.config;

import java.util.ArrayList;
import java.util.List;

import com.osornet.estudio.spring.dao.UsuarioDao;
import com.osornet.estudio.spring.pojo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUsersDetailService
 */
@Service("customUsersDetailService")
public class CustomUsersDetailService implements UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Usuario usuario = usuarioDao.findByUsername(username);

        if(usuario!=null){
            authorities.add(new SimpleGrantedAuthority(usuario.getPermiso()));
            User user =  new User(usuario.getUsuario(), usuario.getClave(), authorities);
            return user;
        }
        else{
            throw new UsernameNotFoundException("Usuario no Encontrado");
        }
        
	}

    
}