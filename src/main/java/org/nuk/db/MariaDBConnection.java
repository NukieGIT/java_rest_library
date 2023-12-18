package org.nuk.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MariaDBConnection {
    private static MariaDBConnection INSTANCE;

    private Connection connection;

    private MariaDBConnection() {
    }

    public static MariaDBConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MariaDBConnection();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = loadProps();

                connection = DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("user"),
                        props.getProperty("password"));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Properties loadProps() {
        Properties props = new Properties();
        try {
            props.load(MariaDBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }

}
