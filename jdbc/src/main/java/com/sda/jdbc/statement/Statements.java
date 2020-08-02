package com.sda.jdbc.statement;

import java.sql.*;
import java.util.logging.Logger;

public class Statements {

    private static final Logger logger = Logger.getLogger(Statements.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // CRUD

    // insert - command
    public void insertOperation(String name, String email, String country) {
        try {
            // create connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("connection created" + connection);

            // create statement
            Statement statement = connection.createStatement();
            logger.info("statement created" + statement);

            String insertUserSql = "INSERT user(name, email, country) VALUES"
                    + "('" + name + "','" + email + "','" + country + "')";
            logger.info("execute update: " + insertUserSql);

            // execute
            // INSERT user(name, email, country) VALUES
            // ('?', '?', '?')
            statement.executeUpdate(insertUserSql);

            // close connection
            connection.close();
            logger.info("connection closed");
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    // read all from users
    public void findAllUser() {
        // connection
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // create statement
            Statement statement = connection.createStatement();

            // execute
            String sql = "SELECT * FROM user";

            // result set
            ResultSet rs = statement.executeQuery(sql);

            // iterate result set and extract data
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                logger.info(id + ", " + name + ", " + email + ", " + country);

                // create user in memory
                User user = new User();
                user.setEmail(email);
            }

            // close
            connection.close();
        } catch (SQLException e) {
            logger.severe("failed to read from db");
        }


    }

    // update
    public void updateOperation(int id, String name, String email, String country) {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE user SET name = '" + name + "', " +
                    "email = '" + email + "', country = '" + country + "' WHERE id = " + id);
        } catch (SQLException e) {
            logger.severe("failed to update");
        } catch (Exception e) {
            logger.severe("something else went wrong");
        } finally {
            // close all resources

            // statement
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.severe("failed to close statement");
            }

            // connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.severe("failed to close connection");
            }

        }
    }

    // delete
    public void deleteOperation(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate("DELETE FROM user WHERE id = " + id);
            logger.info("delete successful: " + rowsAffected + " rows affected");
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }
}
