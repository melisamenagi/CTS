package ro.ase.cts.contracts;

import java.sql.Connection;

public interface StatementSQL {
    void executeStatement(Connection connection);
}
