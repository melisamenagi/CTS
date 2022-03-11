package ro.ase.cts.orchestrators;

import ro.ase.cts.contracts.StatementSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Orchestrator {
    StatementSQL statementSQL;
    private final StatementSQL createStatementSQL;
    private final StatementSQL insertStatementSQL;
    private final StatementSQL selectStatementSQL;
    Connection connection;

    public Orchestrator(StatementSQL createStatementSQL, StatementSQL insertStatementSQL, StatementSQL selectStatementSQL){
//        this.statement = statement;
        this.createStatementSQL = createStatementSQL;
        this.insertStatementSQL = insertStatementSQL;
        this.selectStatementSQL = selectStatementSQL;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute() {
        createStatementSQL.executeStatement(connection);
        insertStatementSQL.executeStatement(connection);
        selectStatementSQL.executeStatement(connection);
    }
}
