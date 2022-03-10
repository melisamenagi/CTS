package ro.ase.cts.contracts;

import java.sql.Connection;

public interface Statement {
    void executeStatement(Connection connection);
}
