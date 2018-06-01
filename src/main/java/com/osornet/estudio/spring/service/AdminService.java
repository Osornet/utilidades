package com.osornet.estudio.spring.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;



import com.osornet.estudio.spring.dao.AdminDao;
import com.osornet.estudio.spring.pojo.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminService
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;
    
    public void save(Admin admin) {

        admin.setFechaCreacion(new Timestamp(new Date().getTime()));

        this.adminDao.save(admin);
    }

	public List<Admin> findAll() {
		return this.adminDao.findAll();
	}

	public Admin findById(int idAd) {
		return this.adminDao.findById(idAd);
	}

	public void saveOrUpdate(Admin admin) {
        if(admin.getIdAd()==0){
            admin.setFechaCreacion(new Timestamp(new Date().getTime()));
            this.adminDao.save(admin);

        }else{
            //update
            this.adminDao.update(admin);
        } 

	}

	public void delete(int idAd) {
        Admin admin = this.adminDao.findById(idAd);
		this.adminDao.delete(admin);
	}

	

    
}