package ge.exchangeservicegela.db;

/**
 * Created by Alex on 5/25/2015.
 */

import ge.exchangeservicegela.db.DBInfo;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectionProvider {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + DBInfo.MYSQL_DATABASE_SERVER
                + ":3306/" + DBInfo.MYSQL_DATABASE_NAME + "?characterEncoding=UTF8");
        dataSource.setUsername(DBInfo.MYSQL_USERNAME);
        dataSource.setPassword(DBInfo.MYSQL_PASSWORD);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
