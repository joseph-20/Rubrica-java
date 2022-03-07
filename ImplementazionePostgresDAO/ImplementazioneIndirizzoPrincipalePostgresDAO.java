package ImplementazionePostgresDAO;

import DAO.IndirizzoPrincipaleDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneIndirizzoPrincipalePostgresDAO implements IndirizzoPrincipaleDAO {
    private Connection connection;
    private String indirizzoPrincipale;
    private ResultSet rs;
    private Statement s;
    int cont;
    private String via,civico,citta,cap,nazione;
    int index,indextmp;

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

    public void creaIndirizzoPrincipale (String indirizzo,int id) throws SQLException{
        s = connection.createStatement();
        //QUERY DI AGGIUNTA DELL'INDIRIZZO PRINCIPALE
        index = indirizzo.indexOf(',');
        indextmp = index;
        via = indirizzo.substring(0,index);
        civico = indirizzo.substring(index+1);
        index = civico.indexOf(',');
        civico = civico.substring(0,index);
        indextmp = indextmp + index+1;
        citta = indirizzo.substring(indextmp+1);
        index = citta.indexOf(',');
        citta = citta.substring(0,index);
        indextmp = indextmp+index+1;
        cap = indirizzo.substring(indextmp+1);
        index = cap.indexOf(',');
        cap = cap.substring(0,index);
        indextmp=indextmp+index+1;
        nazione = indirizzo.substring(indextmp+1);
            s.executeUpdate("INSERT INTO INDIRIZZO_PRINCIPALE (VIA,CIVICO,CITTA,CAP,NAZIONE,ID_CONTATTO)" +
                    "VALUES ('"+via+"','"+civico+"','"+citta+"','"+cap+"','"+nazione+"',"+id+")");
    }
}
