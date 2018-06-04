package com.osornet.estudio.spring.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.osornet.estudio.spring.pojo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UsuarioDaoImp
 */
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
    
	public Usuario findByUsername(String username) {
		/* Criteria criteria = this.getSession().createCriteria(Usuario.class)
		.add(Restrictions.eq("usuario",username));
		Usuario usuario = (Usuario)criteria.uniqueResult();
		return usuario; */
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Usuario> consulta = builder.createQuery(Usuario.class);
		Root<Usuario> usuarioRoot = consulta.from(Usuario.class);
		consulta.where(builder.equal(usuarioRoot.get("usuario"), username));
		return this.getSession().createQuery(consulta).getSingleResult();
    }

	public void save(Usuario usuario) {
		this.getSession().save(usuario);
	}

	public List<Usuario> findAll() {
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Usuario> consulta = builder.createQuery(Usuario.class);
		Root<Usuario> usuarioRoot = consulta.from(Usuario.class);
		consulta.select(usuarioRoot);
		return this.getSession().createQuery(consulta).getResultList();
	}
   


	


       
    
}