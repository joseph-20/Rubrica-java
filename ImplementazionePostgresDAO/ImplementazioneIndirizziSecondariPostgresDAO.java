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
    private String indirizziSecondari,civico,citta,cap,nazione,via;
    private ResultSet rs;
    private Statement s;
    private int cont,num,index,indextmp;

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
        if(num==0) num=1;
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

    public void creaIndirizzoSecondario (String indirizzo,int id) throws SQLException {
        s = connection.createStatement();

        //QUERY DI AGGIUNTA DELL'INDIRIZZO PRINCIPALE
        if (!indirizzo.equals("")) {
            index = indirizzo.indexOf(',');
            indextmp = index;
            via = indirizzo.substring(0, index);
            civico = indirizzo.substring(index + 1);
            index = civico.indexOf(',');
            civico = civico.substring(0, index);
            indextmp = indextmp + index + 1;
            citta = indirizzo.substring(indextmp + 1);
            index = citta.indexOf(',');
            citta = citta.substring(0, index);
            indextmp = indextmp + index + 1;
            cap = indirizzo.substring(indextmp + 1);
            index = cap.indexOf(',');
            cap = cap.substring(0, index);
            indextmp = indextmp + index + 1;
            nazione = indirizzo.substring(indextmp + 1);
            s.executeUpdate("INSERT INTO INDIRIZZO_SECONDARIO (VIA,CIVICO,CITTA,CAP,NAZIONE,ID_CONTATTO)" +
                    "VALUES ('" + via + "','" + civico + "','" + citta + "','" + cap + "','" + nazione + "'," + id + ")");
        }
    }
}
