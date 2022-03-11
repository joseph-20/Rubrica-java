package ImplementazionePostgresDAO;

import DAO.NumeriFissiDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneNumeriFissiPostgresDAO implements NumeriFissiDAO {
    private Connection connection;
    private String numeriFissi;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private int num;

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

    public void creaNumeriFissi (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        s = connection.createStatement();
        //QUERY DI AGGIUNTA DI TUTTI I NUMERI FISSI
        for(int i=0;i<n;i++){
            s.executeUpdate("INSERT INTO NUMERO_FISSO " +
                    "VALUES ('"+prefisso.get(i)+"','"+numero.get(i)+"',"+id+")");
        }
    }

    public int getcontNumNumeriFissi (int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT COUNT (*) as CONTEGGIO " +
                "FROM NUMERO_FISSO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            num = rs.getInt("CONTEGGIO");
        }
        return num;
    }

    public void getArrayNumeriFissi (ArrayList<String> array,int pk) throws SQLException{
        s = connection.createStatement();
        array.clear();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT PREFISSO,NUMERO " +
                "FROM NUMERO_FISSO " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            array.add(rs.getString("PREFISSO")+rs.getString("NUMERO"));
        }
    }
}
