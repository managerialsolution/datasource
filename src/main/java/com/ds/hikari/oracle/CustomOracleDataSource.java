package com.ds.hikari.oracle;

import com.ds.hikari.oracle.config.OracleConfig;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class CustomOracleDataSource extends OracleDataSource {
    public CustomOracleDataSource() throws SQLException {
    }

    @Override
    public Connection getConnection(String var1, String var2) throws SQLException {
        OracleConnection connection = (OracleConnection) super.getConnection(var1, var2);
        Properties properties = new Properties();
        properties.setProperty(OracleConnection.PROXY_USER_NAME , OracleConfig.proxyUserName);
        connection.openProxySession(OracleConnection.PROXYTYPE_USER_NAME,properties);
        return connection;
    }
}
