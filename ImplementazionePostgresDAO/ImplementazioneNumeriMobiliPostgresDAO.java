package ImplementazionePostgresDAO;

import DAO.NumeriMobiliDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneNumeriMobiliPostgresDAO implements NumeriMobiliDAO {
    private Connection connection;
    private String numeriMobili;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private int num;
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

    public void creaNumeriMobili (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        s = connection.createStatement();
        //QUERY DI AGGIUNTA DI I NUMERI MOBILI
        for(int i=0;i<n;i++){
            s.executeUpdate("INSERT INTO NUMERO_MOBILE " +
                    "VALUES ('"+prefisso.get(i)+"','"+numero.get(i)+"',"+id+")");
        }
    }

    public int getcontNumNumeriMobili(int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT COUNT (*) as CONTEGGIO " +
                "FROM NUMERO_MOBILE " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            num = rs.getInt("CONTEGGIO");
        }
        return num;
    }

    public void getArrayNumeriMobili (ArrayList<String> array,int pk) throws SQLException{
        s = connection.createStatement();
        array.clear();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT PREFISSO,NUMERO " +
                "FROM NUMERO_MOBILE " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            array.add(rs.getString("PREFISSO")+rs.getString("NUMERO"));
        }
    }
}
