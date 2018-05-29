package com.osornet.estudio.spring.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * AdminRowMapper
 */
public class AdminRowMapper implements RowMapper<Admin>{

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin admin = new Admin();

        admin.setIdAd(rs.getInt("idAd"));
        admin.setCargo(rs.getString("cargo"));
        admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
        admin.setNombre(rs.getString("nombre"));
        
        return admin;
	}


}