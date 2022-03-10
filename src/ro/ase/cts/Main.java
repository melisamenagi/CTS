package ro.ase.cts;

import ro.ase.cts.contracts.Statement;
import ro.ase.cts.orchestrators.Orchestrator;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Statement createStatement = null;
        Statement insertStatement = null;
        Statement selectStatement = null;

        try {
            createStatement = (Statement) Class.forName("ro.ase.cts.sqlStatements.Create").getDeclaredConstructor().newInstance();
            insertStatement = (Statement) Class.forName("ro.ase.cts.sqlStatements.Insert").getDeclaredConstructor().newInstance();
            selectStatement = (Statement) Class.forName("ro.ase.cts.sqlStatements.Select").getDeclaredConstructor().newInstance();
            Orchestrator orchestrator = new Orchestrator(createStatement,insertStatement,selectStatement);
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
