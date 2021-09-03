package ru.netology.db;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.DriverManager;

public class DataBase {

    @SneakyThrows
    public void cleanDataBase() {
        var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");

        conn.prepareStatement("DELETE FROM auth_codes");
        conn.prepareStatement("DELETE FROM card_transactions");
        conn.prepareStatement("DELETE FROM cards");
        conn.prepareStatement("DELETE FROM users");
    }

    @SneakyThrows
    public static String getCorrectVerificationCode() {
        var runner = new QueryRunner();
        var codesSQL = "SELECT code FROM auth_codes WHERE created is not null;";

        var conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app", "app", "pass");

        var countStmt = conn.createStatement();
        var result = countStmt.executeQuery(codesSQL);

        if (result.next()) {
            return result.getString("code");
        }
        return null;
    }
}