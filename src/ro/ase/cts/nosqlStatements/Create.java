package ro.ase.cts.nosqlStatements;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.cts.contracts.StatementNoSQL;

public class Create implements StatementNoSQL {
    @Override
    public void executeStatement(MongoCollection<Document> collection) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");

        if(mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }

        mongoDb.createCollection("employees");
    }
}
