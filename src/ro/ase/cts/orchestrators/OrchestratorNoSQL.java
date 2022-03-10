package ro.ase.cts.orchestrators;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.cts.contracts.StatementNoSQL;
import ro.ase.cts.contracts.StatementSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrchestratorNoSQL {
    private final StatementNoSQL createStatementNoSQL;
    private final StatementNoSQL insertStatementNoSQL;
    private final StatementNoSQL selectStatementNoSQL;
    MongoCollection<Document> collection;

    public OrchestratorNoSQL(StatementNoSQL createStatementNoSQL, StatementNoSQL insertStatementNoSQL, StatementNoSQL selectStatementNoSQL){
//        this.statement = statement;
        this.createStatementNoSQL = createStatementNoSQL;
        this.insertStatementNoSQL = insertStatementNoSQL;
        this.selectStatementNoSQL = selectStatementNoSQL;
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
        collection = mongoDb.getCollection("employees");
    }

    public void execute() {
        createStatementNoSQL.executeStatement(collection);
        insertStatementNoSQL.executeStatement(collection);
        selectStatementNoSQL.executeStatement(collection);
    }

}
