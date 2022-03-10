package ro.ase.cts.orchestrators;

import ro.ase.cts.contracts.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Orchestrator {
    Statement statement;
    private final Statement createStatement;
    private final Statement insertStatement;
    private final Statement selectStatement;
    Connection connection;

    public Orchestrator(Statement createStatement, Statement insertStatement, Statement selectStatement){
//        this.statement = statement;
        this.createStatement = createStatement;
        this.insertStatement = insertStatement;
        this.selectStatement = selectStatement;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        createStatement.executeStatement(connection);
        insertStatement.executeStatement(connection);
        selectStatement.executeStatement(connection);
    }
}
