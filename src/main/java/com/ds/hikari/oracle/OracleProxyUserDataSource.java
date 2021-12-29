package com.ds.hikari.oracle;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class OracleProxyUserDataSource {

    public DataSource createDataSource( HikariConfig hikariConfig){
        hikariConfig.setDataSourceClassName("com.ds.hikari.oracle.CustomOracleDataSource");
        return new HikariDataSource(hikariConfig);
    }
}
