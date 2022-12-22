package it.servletdao.servletdao.dao;


import it.servletdao.servletdao.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/db_servlet?useSSL=false";
    private String jdbcUsername = "gianluca";
    private String jdbcPassword = "@Gianluca";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country, eta) VALUES "
            + " (?, ?, ?,?);";


    public UserDAO() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        System.out.println("Connected to Database.");
        return connection;
    }

    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USERS_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getEta());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}

