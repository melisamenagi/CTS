package ro.ase.cts;

import ro.ase.cts.contracts.Database;
import ro.ase.cts.contracts.StatementNoSQL;
import ro.ase.cts.contracts.StatementSQL;
import ro.ase.cts.orchestrators.Orchestrator;
import ro.ase.cts.orchestrators.OrchestratorNoSQL;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
//        StatementSQL createStatementSQL = null;
//        StatementSQL insertStatementSQL = null;
//        StatementSQL selectStatementSQL = null;
//        StatementNoSQL createStatementNoSQL = null;
//        StatementNoSQL insertStatementNoSQL = null;
//        StatementNoSQL selectStatementNoSQL = null;


//        try {
//            createStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Create").getDeclaredConstructor().newInstance();
//            insertStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Insert").getDeclaredConstructor().newInstance();
//            selectStatementSQL = (StatementSQL) Class.forName("ro.ase.cts.sqlStatements.Select").getDeclaredConstructor().newInstance();
//            Orchestrator orchestrator = new Orchestrator(createStatementSQL, insertStatementSQL, selectStatementSQL);
//            createStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Create").getDeclaredConstructor().newInstance();
//            insertStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Insert").getDeclaredConstructor().newInstance();
//            selectStatementNoSQL = (StatementNoSQL) Class.forName("ro.ase.cts.nosqlStatements.Select").getDeclaredConstructor().newInstance();
//            OrchestratorNoSQL orchestrator = new OrchestratorNoSQL(createStatementNoSQL, insertStatementNoSQL, selectStatementNoSQL);
//            orchestrator.execute();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Database database = null;

        try {
            database = (SQL) Class.forName("ro.ase.cts.SQL").getDeclaredConstructor().newInstance();
            database.operateDatabase();
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
