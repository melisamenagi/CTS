package ro.ase.cts.sqlStatements;

import ro.ase.cts.contracts.StatementSQL;

import java.sql.Connection;
import java.sql.SQLException;

public class Create implements StatementSQL {

    @Override
    public void executeStatement(Connection connection) {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        java.sql.Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
            System.out.println("CREATE");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
