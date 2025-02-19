package com.cinemamanagementsoftware.database;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Record;

public class Neo4JConnection {
    private final Driver driver;

    public Neo4JConnection(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public void close() {
        driver.close();
    }

    public void testConnection() {
        try (Session session = driver.session()) {
            String query = "RETURN 'Neo4J Verbindung erfolgreich!' AS message";
            Result result = session.run(query);
            Record record = result.single();
            System.out.println(record.get("message").asString());
        }
    }

    public static void main(String[] args) {
        Neo4JConnection db = new Neo4JConnection("bolt://localhost:7687", "neo4j", "lobster-child-atomic-canvas-infant-6060");
        db.testConnection();
        db.close();
    }
}
