package com.connor.fuel.controller;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    /**
     * Sets up a connection to the local SQLite database
     * @return a active connection to the db.
     */
    public static Connection connect() {
        String url = "jdbc:sqlite:src/main/resources/database/fueldb.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Closes the active connection to the database
     * @param conn the database
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Queries a database and returns the result of said query
     * @param query the sql query
     * @return the results of the query
     */
    public static ArrayList<String> executeQuery(String query) {
        Connection conn = connect();
        var results = new ArrayList<String>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                results.add(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
        return results;
    }

    /**
     * Exectures sql on the database (usually to create a table or insert an entry)
     * @param sql the sql to be executed
     */
    public static void executeSQL(String sql) {
        Connection conn = connect();
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn);
    }
}
