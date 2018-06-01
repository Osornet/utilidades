package com.osornet.estudio.spring.dao;


import java.util.List;

import com.osornet.estudio.spring.pojo.Admin;

/**
 * AdministradorDao
 */
public interface AdminDao {
    public void save(Admin admin);
    public List<Admin> findAll();
    public Admin findById(int id);
    public List<Admin> findByName(String nombre);
    public void update(Admin admin);
    public void delete(Admin admin);
   
}