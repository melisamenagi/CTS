package ro.ase.cts.contracts;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Connection;

public interface StatementNoSQL {
    void executeStatement(MongoCollection<Document> collection);
}
