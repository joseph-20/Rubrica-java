package ImplementazionePostgresDAO;

import DAO.NumeriMobiliDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazioneNumeriMobiliPostgresDAO implements NumeriMobiliDAO {
    private Connection connection;
    private String numeriMobili;
    private ResultSet rs;
    private Statement s;
    int cont;

    public ImplementazioneNumeriMobiliPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNumeriMobili(int pk) throws SQLException{
        cont = 0;
        numeriMobili = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI NUMERO MOBILE
        rs = s.executeQuery("SELECT * " +
                "FROM NUMERO_MOBILE " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            numeriMobili= numeriMobili+(rs.getString("prefisso")+" "+rs.getString("numero")+"<br/>");
            cont++;
        }
        numeriMobili = numeriMobili+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return numeriMobili;
    }
}
