package ro.ase.cts.contracts;

import java.sql.Connection;

public interface SQL {
    void createTable(Connection conection);
}
