package ro.api.db;

import java.sql.*;

public class ConnectDB {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/test";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Closed database connection successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ResultSet executeQuery(String query, Object... values) {
        Connection conn = getConnection();
        ResultSet resultSet = null;

        try {
            PreparedStatement statement = conn.prepareStatement(query);

            int index = 1;
            for (Object obj : values) {
                statement.setObject(index, obj);
                index++;
            }

            resultSet = statement.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(conn);
        }

        return resultSet;
    }
}
