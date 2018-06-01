package com.osornet.estudio.spring.service;


import java.util.List;

import com.osornet.estudio.spring.dao.AdminDao;
import com.osornet.estudio.spring.dao.DireccionDao;
import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.pojo.Direccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DireccionService
 */
@Service
public class DireccionService {

    @Autowired
    private DireccionDao direccionDao;
    @Autowired
    private AdminDao adminDao;

    public void save(Admin admin, Direccion direccion){
      direccion.setAdmin(admin);
      this.direccionDao.save(direccion);
    }
    public List<Direccion> findAll(int idAd) {
      Admin admin = this.adminDao.findById(idAd);
      return this.direccionDao.findAll(admin);
	}
	public Direccion findById(int idDir) {
		return this.direccionDao.findById(idDir);
	}
	public void delete(int idDir) {
    Direccion direccion = this.direccionDao.findById(idDir);
    this.direccionDao.delete(direccion);
	}

}