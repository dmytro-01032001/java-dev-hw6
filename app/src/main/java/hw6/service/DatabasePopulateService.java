package hw6.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import hw6.Database;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            String contentSql = Files.readString(Paths.get("src/main/resources/sql/populate_db.sql"));
            Connection conn = Database.getConnection();
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(contentSql);
            } catch(SQLException e) {
                e.printStackTrace();
            };
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
