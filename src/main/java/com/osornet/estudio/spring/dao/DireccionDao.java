package com.osornet.estudio.spring.dao;

import java.util.List;

import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.pojo.Direccion;

/**
 * DireccionDa
 */
public interface DireccionDao  {
    public void save(Direccion direccion);
    public List<Direccion> findAll(Admin admin);
	public Direccion findById(int idDir);
	public void delete(Direccion direccion);
}