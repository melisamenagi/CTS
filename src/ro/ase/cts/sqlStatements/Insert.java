package ro.ase.cts.sqlStatements;

import ro.ase.cts.contracts.StatementSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert implements StatementSQL {

    @Override
    public void executeStatement(Connection connection) {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
        java.sql.Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
            statement.close();

            String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlInsertWithParams);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();
            System.out.println("INSERT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
