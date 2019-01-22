package com.debyendu.spring.config;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.debyendu.spring")
@PropertySource(value = "classpath:db.properties")
public class SpringJDBCConfiguration {

	final static Logger logger = Logger.getLogger(SpringJDBCConfiguration.class);
	
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;

	@Bean
	@Scope("singleton")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	@Scope("singleton")
	public Connection getConnection() {
		Connection con = null;
		try {
			con = dataSource().getConnection();
			logger.debug("Connection object is created!");
		}catch(SQLException e) {
			System.out.println("This is exception connection creation exception : "+e);
		}
		return con;
	}
}
