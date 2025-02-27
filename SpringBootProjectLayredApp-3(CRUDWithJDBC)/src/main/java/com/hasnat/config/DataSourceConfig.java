//package com.hasnat.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//public class DataSourceConfig {
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        dataSource.setUsername("your_db_username");
//        dataSource.setPassword("your_db_password");
//        return dataSource;
//    }
//}
