package com.osornet.estudio.spring.dao;


import java.util.List;

import com.osornet.estudio.spring.pojo.Admin;

/**
 * AdministradorDao
 */
public interface AdminDao {
    public boolean save(Admin admin);
    public List<Admin> findAll();
    public Admin findById(int id);
    public List<Admin> findByName(String nombre);
    public boolean update(Admin admin);
    public boolean delete(int idAd);
    public int[] saveAll(List<Admin> admins);
    public int[] deleteAll(List<Admin> admins);
}