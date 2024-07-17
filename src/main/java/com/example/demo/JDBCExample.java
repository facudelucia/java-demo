/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author facun
 */
package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Change to your database URL
        String user = "root"; // Change to your database username
        String password = "root"; // Change to your database password

        try {
            // Load JDBC driver (optional in modern JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement statement = connection.createStatement();

            // Drop table if it exists
            String dropTableSQL = "DROP TABLE IF EXISTS `users`";
            statement.executeUpdate(dropTableSQL);

            // Create table (escaped table name)
            String createTableSQL = "CREATE TABLE `users` ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableSQL);

            // Insert data
            String insertSQL = "INSERT INTO `users` (name) VALUES ('John Doe')";
            statement.executeUpdate(insertSQL);

            // Select data (escaped table name)
            String selectSQL = "SELECT id, name FROM `users`";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            // Process results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }
}
