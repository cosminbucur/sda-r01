package com.sda.jdbc.prepared_statement;

import java.sql.*;
import java.util.logging.Logger;

public class PreparedStatements {

    // CRUD
    private static final Logger logger = Logger.getLogger(PreparedStatement.class.getName());
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // insert
    public void insertOperation(String name, String email, String country) {
        String sql = "INSERT INTO user(name, email, country) VALUES (?, ?, ?)";

        // try with resources
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            // set parameters to sql prepared statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    // read
    public void queryOperation() {
        String sql = "SELECT * FROM user";

        // try with resources
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery()
        ) {

            while (rs.next()) {
                // save properties from results set
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                logger.info(id + ", " + name + ", " + email + ", " + country);
            }
        } catch (SQLException e) {
            logger.severe("failed to insert");
        }
    }

    // update
    // TODO: implement this

    // delete
    // TODO: implement this
}
