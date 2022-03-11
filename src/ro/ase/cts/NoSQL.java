package ro.ase.cts;

import ro.ase.cts.contracts.Database;
import ro.ase.cts.contracts.StatementNoSQL;
import ro.ase.cts.orchestrators.OrchestratorNoSQL;

import java.lang.reflect.InvocationTargetException;

public class NoSQL implements Database {
    @Override
    public void operateDatabase() {
        StatementNoSQL createStatementNoSQL = null;
        StatementNoSQL insertStatementNoSQL = null;
        StatementNoSQL selectStatementNoSQL = null;
        try {
            createStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Create").getDeclaredConstructor().newInstance();
            insertStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Insert").getDeclaredConstructor().newInstance();
            selectStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Select").getDeclaredConstructor().newInstance();
            OrchestratorNoSQL orchestrator = new OrchestratorNoSQL(createStatementNoSQL, insertStatementNoSQL, selectStatementNoSQL);
            orchestrator.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
