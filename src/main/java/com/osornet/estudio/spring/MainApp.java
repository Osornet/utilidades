package com.osornet.estudio.spring;




import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.osornet.estudio.spring.dao.AdminDao;
import com.osornet.estudio.spring.pojo.Admin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class MainApp{
    public static void main(String[] args) {
        ApplicationContext contenedor = new ClassPathXmlApplicationContext("spring/estudioSpring.xml");
        
        AdminDao adminDao = contenedor.getBean(AdminDao.class,"adminDao");
        Timestamp ts = new Timestamp(new Date().getTime());
        try {
                        
           System.out.println(new Admin());
            
                
        } catch (CannotGetJdbcConnectionException e) {
            e.printStackTrace();
        } catch (DataAccessException e){
            e.printStackTrace();
        }

        
        ((ClassPathXmlApplicationContext)contenedor).close();
    }
}