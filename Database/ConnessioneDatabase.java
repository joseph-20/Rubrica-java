package Database;

import javax.swing.*;
import java.sql.*;

public class ConnessioneDatabase {

    // ATTRIBUTI
    private static ConnessioneDatabase instance;
    private Connection connection = null;
    private String nome = "gomwmhzurnduwv";
    private String password = "94e9a2e201fd7fb2b28805cea46b519e3e10bfe689164cbac04292342cdb1328";
    private String url = "jdbc:postgresql://ec2-63-34-153-52.eu-west-1.compute.amazonaws.com:5432/df1kj1nc91i2pn";
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
