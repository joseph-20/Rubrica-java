package ImplementazionePostgresDAO;

import DAO.NumeriFissiDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazioneNumeriFissiPostgresDAO implements NumeriFissiDAO {
    private Connection connection;
    private String numeriFissi;
    private ResultSet rs;
    private Statement s;
    int cont;

    public ImplementazioneNumeriFissiPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNumeriFissi(int pk) throws SQLException {
        cont = 0;
        numeriFissi = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI NUMERO FISSO
        rs = s.executeQuery("SELECT * " +
                "FROM NUMERO_FISSO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            numeriFissi = numeriFissi+(rs.getString("prefisso")+" "+rs.getString("numero")+"<br/>");
            cont++;
        }
        numeriFissi = numeriFissi+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return numeriFissi;
    }
}
