package Database;

import javax.swing.*;
import java.sql.*;

public class ConnessioneDatabase {

    // ATTRIBUTI
    private static ConnessioneDatabase instance;
    private Connection connection = null;
    private String nome = "gmrbcvnzblxbqo";
    private String password = "73adfbf723013b464edc8f3b143c7769d0b7a5cbd1ade30b1ad4662072d2ec42";
    private String url = "jdbc:postgresql://ec2-54-194-147-61.eu-west-1.compute.amazonaws.com:5432/dcip2l877niggc";
    private String driver = "org.postgresql.Driver";

    // COSTRUTTORE
    public ConnessioneDatabase() throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, nome, password);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Connessione al database FALLITA!\n" + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnessioneDatabase getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnessioneDatabase();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnessioneDatabase();
        }
        return instance;
    }
}
