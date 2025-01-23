package OOP_assignment2;
import OOP_assignment2.models.*;
import java.sql.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/oop-assignment";
        String user = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the PostgreSQL database!");

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Insert data");
                System.out.println("2. Select all data");
                System.out.println("3. Update data");
                System.out.println("4. Delete data");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        insertData(connection, scanner);
                        break;
                    case 2:
                        selectAllData(connection);
                        break;
                    case 3:
                        updateData(connection, scanner);
                        break;
                    case 4:
                        deleteData(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    private static void insertData(Connection connection, Scanner scanner) {
        System.out.print("Enter value for name: ");
        String column1 = scanner.nextLine();

        System.out.print("Enter value for age: ");
        int column2 = scanner.nextInt();
        scanner.nextLine();

        String insertSQL = "INSERT INTO patient (name, age) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, column1);
            preparedStatement.setInt(2, column2);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Error during INSERT: " + e.getMessage());
        }
    }
    private static void updateData(Connection connection, Scanner scanner) {
        System.out.print("Enter value for name to update: ");
        String name = scanner.nextLine();

        System.out.print("Enter new value for age (integer): ");
        int age = scanner.nextInt();
        scanner.nextLine();

        String updateSQL = "UPDATE patient SET age = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, name);
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Rows updated: " + rowsUpdated);
        } catch (SQLException e) {
            System.out.println("Error during UPDATE: " + e.getMessage());
        }
    }

    private static void deleteData(Connection connection, Scanner scanner) {
        System.out.print("Enter value for name to delete: ");
        String name = scanner.nextLine();

        String deleteSQL = "DELETE FROM patient WHERE name = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, name);
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            System.out.println("Error during DELETE: " + e.getMessage());
        }
    }

    private static void selectAllData(Connection connection) {
        String selectAllSQL = "SELECT * FROM patient order by id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectAllSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Results from SELECT ALL:");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error during SELECT ALL: " + e.getMessage());
        }
    }
}
