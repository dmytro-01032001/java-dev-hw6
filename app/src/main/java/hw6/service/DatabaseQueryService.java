package hw6.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hw6.Database;
import hw6.model.LongestProject;
import hw6.model.MaxProjectCountClient;
import hw6.model.MaxSalaryWorker;
import hw6.model.OldestYoungestWorker;
import hw6.model.ProjectPrice;


public class DatabaseQueryService {
    public static List<LongestProject> findLongestProject() throws IOException{
        String query = Files.readString(Paths.get("src/main/resources/sql/find_longest_project.sql"));
        Connection conn = Database.getConnection();
        List<LongestProject> projects = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                projects.add(new LongestProject(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("month_count")
                    )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        };
        return projects;
    }

    public static List<MaxProjectCountClient> findMaxProjectsClient() throws IOException {
        String query = Files.readString(Paths.get("src/main/resources/sql/find_max_projects_client.sql"));
        Connection conn = Database.getConnection();
        List<MaxProjectCountClient> projects = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                projects.add(new MaxProjectCountClient(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("PROJECT_COUNT")
                    )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException {
        String query = Files.readString(Paths.get("src/main/resources/sql/find_max_salary_worker.sql"));
        Connection conn = Database.getConnection();
        List<MaxSalaryWorker> workers = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                workers.add(new MaxSalaryWorker(
                        result.getString("name"),
                        result.getInt("salary")
                    )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public static List<OldestYoungestWorker> findOldestYoungestWorker() throws IOException {
        String query = Files.readString(Paths.get("src/main/resources/sql/find_youngest_eldest_workers.sql"));
        Connection conn = Database.getConnection();
        List<OldestYoungestWorker> workers = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                workers.add(new OldestYoungestWorker(
                        result.getString("type"),
                        result.getString("name"),
                        result.getString("birthday")
                    )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return workers;
    }

    public static List<ProjectPrice> getProjectPrices() throws IOException {
        String query = Files.readString(Paths.get("src/main/resources/sql/print_project_prices.sql"));
        Connection conn = Database.getConnection();
        List<ProjectPrice> projects = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                projects.add(new ProjectPrice(
                        result.getString("name"),
                        result.getInt("price")
                    )
                );
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
