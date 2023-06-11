package com.stelmasz.tutorial;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class Conf {


    public static DataSource createDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/tutorialdb");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("postgres");
        return dataSourceBuilder.build();
    }
}
