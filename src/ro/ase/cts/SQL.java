package ro.ase.cts;

import ro.ase.cts.contracts.Database;
import ro.ase.cts.contracts.StatementSQL;
import ro.ase.cts.orchestrators.Orchestrator;

import java.lang.reflect.InvocationTargetException;

public class SQL implements Database {
    @Override
    public void operateDatabase() {
        StatementSQL createStatementSQL = null;
        StatementSQL insertStatementSQL = null;
        StatementSQL selectStatementSQL = null;
        try {
            createStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Create").getDeclaredConstructor().newInstance();
            insertStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Insert").getDeclaredConstructor().newInstance();
            selectStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Select").getDeclaredConstructor().newInstance();
            Orchestrator orchestrator = new Orchestrator(createStatementSQL, insertStatementSQL, selectStatementSQL);
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
