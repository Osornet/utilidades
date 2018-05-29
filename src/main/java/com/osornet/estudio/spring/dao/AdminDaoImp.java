package com.osornet.estudio.spring.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.pojo.AdminRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

/**
 * AdminDaoImp
 */
@Component("adminDao")
public class AdminDaoImp implements AdminDao{

    private NamedParameterJdbcTemplate jdbcTemplate;

    
    public boolean save(Admin admin) {
        /* MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("nombre", admin.getNombre());
        paramMap.addValue("cargo", admin.getCargo());
        paramMap.addValue("fechaCreacion", admin.getFechaCreacion()); */

        BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(admin);

        return jdbcTemplate.update("INSERT into admin(nombre, cargo, fechaCreacion) values"+
        "(:nombre, :cargo, :fechaCreacion)", paramMap) == 1;
        
    }
    

    @Autowired
    private void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


	public List<Admin> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM admin", new RowMapper<Admin>(){
            public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
                Admin admin = new Admin();

                admin.setIdAd(rs.getInt("idAd"));
                admin.setCargo(rs.getString("cargo"));
                admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
                admin.setNombre(rs.getString("nombre"));
                
                return admin;
            }
        });
	}


	public Admin findById(int id) {
       /*  return (Admin) this.jdbcTemplate.query("SELECT * FROM admin WHERE idAd = :idAd",
        new MapSqlParameterSource("idAd", id), new AdminRowMapper());
        */
        return this.jdbcTemplate.queryForObject("SELECT * FROM admin WHERE idAd = :idAd",
        new MapSqlParameterSource("idAd", id), new AdminRowMapper());

	}


	public List<Admin> findByName(String nombre) {
        String consulta = "SELECT * FROM admin WHERE nombre like :nombre";
        MapSqlParameterSource parametro = new MapSqlParameterSource("nombre", "%"+nombre+"%");
        AdminRowMapper adminRowMapper = new AdminRowMapper();

        return this.jdbcTemplate.query(consulta, parametro, adminRowMapper);
    }


	public boolean update(Admin admin) {
        String consulta = "UPDATE admin set nombre=:nombre, "+
        "cargo=:cargo, fechaCreacion=:fechaCreacion "+
        "WHERE idAd=:idAd";
        BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(admin);
        return this.jdbcTemplate.update(consulta, parameterSource)==1;
	}


	public boolean delete(int idAd) {
        String consulta = "DELETE FROM admin WHERE idAd=:idAd";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("idAd",idAd);
        return this.jdbcTemplate.update(consulta, parameterSource)==1;
	}

    @Transactional
	public int[] saveAll(List<Admin> admins) {
		String consulta = "INSERT into admin(idAd, nombre, cargo, fechaCreacion) values"+
        "(:idAd, :nombre, :cargo, :fechaCreacion)";
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());

        return this.jdbcTemplate.batchUpdate(consulta, batchArgs);
	}


	public int[] deleteAll(List<Admin> admins) {
        String consulta = "DELETE FROM admin WHERE idAd=:idAd";
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(admins.toArray());

        return this.jdbcTemplate.batchUpdate(consulta, batchArgs);
	}

}