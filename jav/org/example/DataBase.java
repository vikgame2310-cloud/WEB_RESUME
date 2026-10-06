package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBase {

    final String url =
            "jdbc:postgresql://localhost:5432/Table";

    final String headUser =
            "vikga";

    final String headPassword =
            "ТВОЙ_ПАРОЛЬ";

    String sql = """
            INSERT INTO users(email, password_hash)
            VALUES (?, ?)
            """;

    public void save(String email, String password) {

        IO.println("save: STARTED");

        try (
                Connection connection =
                        DriverManager.getConnection(
                                url,
                                headUser,
                                headPassword
                        );

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, email);
            statement.setString(2, password);

            statement.executeUpdate();

            IO.println("save: COMPLETE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}