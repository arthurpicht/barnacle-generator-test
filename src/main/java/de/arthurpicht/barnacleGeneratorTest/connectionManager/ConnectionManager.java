package de.arthurpicht.barnacleGeneratorTest.connectionManager;

import de.arthurpicht.barnacleGeneratorTest.utils.TestUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String USER = "sa";
    static final String PASS = "sa";

    public static Connection openConnection(Class<?> aClass) throws DataSourceException {
        String testGroupId = TestUtils.getTestGroupId(aClass.getCanonicalName());
        String testCaseId = TestUtils.getTestCaseId(aClass.getCanonicalName());
        String dbUrl = "jdbc:h2:./db/" + testGroupId + "_" + testCaseId;
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
