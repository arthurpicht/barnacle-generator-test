package de.arthurpicht.barnacleGeneratorTest.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String USER = "sa";
    static final String PASS = "sa";

    public static Connection openConnection(Class<?> aClass) throws DataSourceException {

        String canonicalName = aClass.getCanonicalName();
        int begin = canonicalName.indexOf("tc");
        if (begin < 0)
            throw new IllegalArgumentException(
                    "package tc* not found in canonical class name: [" + canonicalName + "].");
        int end = canonicalName.indexOf(".", begin);
        String testCaseId = canonicalName.substring(begin, end);

        System.out.println("TestCaseId: " + testCaseId);

        String dbUrl = "jdbc:h2:./db/" + testCaseId;

        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(dbUrl, USER, PASS);
        } catch(ClassNotFoundException | SQLException e) {
            throw new DataSourceException(e);
        }
    }

    public static void releaseConnection(Connection connection, Class<?> aClass) throws DataSourceException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataSourceException(e);
        }
    }

}
