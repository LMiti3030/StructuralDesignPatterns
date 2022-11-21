package mititelu.laura;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {


    private static volatile DBSingleton instance = null;
    private static volatile Connection conn = null;

    private DBSingleton() {

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            throw new RuntimeException("Use getConnection() method to create");
        }

        //make sure nobody uses reflection on our code
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DBSingleton getInstance() { //if you make the entire method synchronized it is a performance hit!!
        if (instance == null) {
            synchronized (DBSingleton.class) { //synchronized adds a little overhead
                if (instance == null) {
                    instance = new DBSingleton();
                }
            }

        }
        return instance;
    }

    //it is not static
    //we have to have an instance of the singleton and then use getConnection
    public Connection getConnection() {
        if (conn == null) {
            synchronized (DBSingleton.class) {
                if (conn == null) {
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        conn = DriverManager.getConnection(dbUrl);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;

    }
}
