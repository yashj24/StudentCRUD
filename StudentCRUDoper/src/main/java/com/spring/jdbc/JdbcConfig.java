package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {

	@Bean("datasource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("jdbcTemplate")
	 public JdbcTemplate getTemplate() {
		 JdbcTemplate jt = new JdbcTemplate();
		 jt.setDataSource(getDataSource());
		 return jt;
	 }
	@Bean("sdi")
	public StudentDao getStudentDao() {
		StudentDaoImpl sd = new StudentDaoImpl();
		sd.setJt(getTemplate());
		return sd; 
	}
	
	
}
