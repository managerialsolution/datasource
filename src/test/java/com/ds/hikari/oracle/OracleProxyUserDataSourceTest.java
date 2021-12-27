package com.ds.hikari.oracle;

import com.zaxxer.hikari.HikariConfig;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class OracleProxyUserDataSourceTest {

    @Test
    public void createDataSourceTest() throws SQLException {
        OracleProxyUserDataSource oracleProxyUserDataSource = new OracleProxyUserDataSource();
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(1);
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:port");
        DataSource datasource = oracleProxyUserDataSource.createDataSource(hikariConfig);
        assertTrue(datasource.getConnection("test","") instanceof Connection);
    }
}
