package com.grsu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadFromDB implements ReadFile {
    public List<String> fileRead(String columnName) {
        List<String> predicts = new ArrayList<>();
        try {
            String sqlComman = "SELECT * FROM " + columnName;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/predicts";
            String login = "postgres";
            String password = "root";
            Connection con = DriverManager.getConnection(url, login, password);
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sqlComman);
                while (rs.next()) {
                    predicts.add(rs.getString(1));
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return predicts;
    }
}

