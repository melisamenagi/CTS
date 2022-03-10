package ro.ase.cts.nosqlStatements;

import com.mongodb.client.MongoCollection;

import org.bson.Document;
import ro.ase.cts.contracts.StatementNoSQL;

public class Insert implements StatementNoSQL {
    @Override
    public void executeStatement(MongoCollection<Document> collection) {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }
}
