package com.osornet.estudio.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.pojo.Direccion;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * DireccionDaoImp
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository
public class DireccionDaoImp implements DireccionDao{

    @Autowired
	private SessionFactory sessionFactory;


	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}


	public void save(Direccion direccion) {
		this.getSession().saveOrUpdate(direccion);
	}


	public List<Direccion> findAll(Admin admin) {
		//con JPA
		CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Direccion> consulta = builder.createQuery(Direccion.class);
		Root<Direccion> direccionRoot = consulta.from(Direccion.class);
		direccionRoot.fetch("admin");
		consulta.where(builder.equal(direccionRoot.get("admin"), admin));
		return this.getSession().createQuery(consulta).getResultList();
		//con criteria (decrepited)
		/* Criteria criteria = this.getSession().createCriteria(Direccion.class)
		.setFetchMode("admin", FetchMode.DEFAULT)
		.add(Restrictions.eq("admin", admin))
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list(); */
		
	}

	public Direccion findById(int idDir) {
		return this.getSession().get(Direccion.class, idDir);
	}


	public void delete(Direccion direccion) {
		this.getSession().delete(direccion);
	}

    
	
}