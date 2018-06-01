package com.osornet.estudio.spring;




import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.osornet.estudio.spring.dao.AdminDao;
import com.osornet.estudio.spring.dao.AdminDaoImp;
import com.osornet.estudio.spring.pojo.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class MainApp{
    public static void main(String[] args) {
        ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring/springMVC/persistence-context.xml");
        
        AdminDao adminDao = contenedor.getBean(AdminDao.class,"adminDao");
        Timestamp fechaCreacion = new Timestamp(new Date().getTime());

        Admin admin = adminDao.findById(1);
        
        System.out.println(admin);
        
        ((ClassPathXmlApplicationContext)contenedor).close();
    }
}