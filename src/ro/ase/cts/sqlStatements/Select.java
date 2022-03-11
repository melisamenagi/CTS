package ro.ase.cts.sqlStatements;

import ro.ase.cts.contracts.StatementSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select implements StatementSQL {
    @Override
    public void executeStatement(Connection connection) {
        String sqlSelect = "SELECT * FROM employees";
        java.sql.Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while(rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
            rs.close();
            statement.close();
            System.out.println("SELECT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
