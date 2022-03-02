package ImplementazionePostgresDAO;

import DAO.IndirizzoPrincipaleDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazioneIndirizzoPrincipalePostgresDAO implements IndirizzoPrincipaleDAO {
    private Connection connection;
    private String indirizzoPrincipale;
    private ResultSet rs;
    private Statement s;
    int cont;

    public ImplementazioneIndirizzoPrincipalePostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getIndirizzoPrincipale (int pk) throws SQLException{
        cont = 0;
        indirizzoPrincipale = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI INDIRIZZO_PRINCIPALE
        rs = s.executeQuery("SELECT * " +
                "FROM INDIRIZZO_PRINCIPALE " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            indirizzoPrincipale = indirizzoPrincipale+(rs.getString("via")+","+rs.getString("civico")+","+rs.getString("citta")+","+rs.getString("cap")+","+rs.getString("nazione")+"<br/>");
            cont++;
        }
        indirizzoPrincipale = indirizzoPrincipale+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return indirizzoPrincipale;
    }
}
