package ImplementazionePostgresDAO;

import DAO.IndirizziSecondariDAO;
import Database.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneIndirizziSecondariPostgresDAO implements IndirizziSecondariDAO {
    private Connection connection;
    private String indirizziSecondari;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private int num;

    public ImplementazioneIndirizziSecondariPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getIndirizziSecondari(int pk) throws SQLException {
        cont = 0;
        indirizziSecondari = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI INDIRIZZO_SECONDARIO
        rs = s.executeQuery("SELECT * " +
                "FROM INDIRIZZO_SECONDARIO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            indirizziSecondari = indirizziSecondari+(rs.getString("via")+","+rs.getString("civico")+","+rs.getString("citta")+","+rs.getString("cap")+","+rs.getString("nazione")+"<br/>");
            cont++;
        }
        indirizziSecondari = indirizziSecondari+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return indirizziSecondari;
    }

    public int getcontNumIndirizziSecondari(int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT COUNT (*) as CONTEGGIO " +
                "FROM INDIRIZZO_SECONDARIO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            num = rs.getInt("CONTEGGIO");
        }
        return num;
    }

    public void getArrayIndirizziSecondari (ArrayList<String> array, int pk) throws SQLException{
        s = connection.createStatement();
        array.clear();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT VIA,CIVICO,CITTA,CAP,NAZIONE " +
                "FROM INDIRIZZO_SECONDARIO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            array.add(rs.getString("VIA")+","+rs.getString("CIVICO")+","+rs.getString("CITTA")+","+rs.getString("CAP")+","+rs.getString("NAZIONE"));
        }
    }
}
