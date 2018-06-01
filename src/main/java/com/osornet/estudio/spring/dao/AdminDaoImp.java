package com.osornet.estudio.spring.dao;



import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.osornet.estudio.spring.pojo.Admin;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




/**
 * AdminDaoImp
 */
@Transactional
@Repository
public class AdminDaoImp implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;


	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}


	public void save(Admin admin) {
		this.getSession().save(admin);
	}

	public List<Admin> findAll() {
		Query<Admin> query = this.getSession().createQuery("from Admin admin",Admin.class);

		return query.list();
	}

	public Admin findById(int id) {
		
		//forma actual de criterios con jpa
		/* CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Admin> criteriaQuery = builder.createQuery(Admin.class);
		Root<Admin> adminRoot = criteriaQuery.from(Admin.class);
		criteriaQuery.select(adminRoot);
		criteriaQuery.where(builder.equal(adminRoot.get("idAd"),id));
		Query<Admin> query = this.getSession().createQuery(criteriaQuery);
		return query.getSingleResult();  */

		//criteria de hibernate
		/* Criteria criteria = this.getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("idAd", id));
		return (Admin)criteria.uniqueResult(); */

		//la que se usa comunente
		return this.getSession().get(Admin.class,id);
		
	}

	@SuppressWarnings("unchecked")
	public List<Admin> findByName(String nombre) {
		//con JPA
		/* CriteriaBuilder builder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<Admin> consulta = builder.createQuery(Admin.class);
		Path<String> nombreAdm = consulta.from(Admin.class).get("nombre");
		consulta.where(builder.like(nombreAdm,"%"+nombre+"%"));
		List<Admin> admins= this.getSession().createQuery(consulta).getResultList(); */
		Criteria criteria = this.getSession().createCriteria(Admin.class);
		criteria.add(Restrictions.like("nombre","%"+nombre+"%"));
		List<Admin> admins = criteria.list();
		return admins;
	}

	public void update(Admin admin) {
		this.getSession().update(admin);
	}

	public void delete(Admin admin) {
		this.getSession().delete(admin);
	}

  

}