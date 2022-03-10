package ro.ase.cts.nosqlStatements;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import ro.ase.cts.contracts.StatementNoSQL;

public class Select implements StatementNoSQL {
    @Override
    public void executeStatement(MongoCollection<Document> collection) {
        FindIterable<org.bson.Document> result = collection.find();
        for(Document doc : result) {
            System.out.println(doc);
        }
    }
}
