package ImplementazionePostgresDAO;

import DAO.NumeriFissiDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
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
    private DefaultListModel<String> DLM = new DefaultListModel<>();
    private DefaultListModel<String> DLMPrivati = new DefaultListModel<>();
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

    public DefaultListModel getContattiSearchNumeriFissi(String ricerca, ArrayList<Integer> pkContatti) throws SQLException {
        pkContatti.clear();
        DLM.removeAllElements();
        s = connection.createStatement();

        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = FALSE " +
                    "ORDER BY NOME,COGNOME");
        }
        else if (ricerca.length()>3){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_FISSO " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND PREFISSO = '" + ricerca.substring(0,3) + "' AND NUMERO ILIKE '"+ricerca.substring(3)+"%'" +
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_FISSO " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND PREFISSO ILIKE '" + ricerca + "%'"+
                    " ORDER BY NOME,COGNOME");
        }
        while (rs.next()) {                                   //Finche non scorro tutto il resultSet
            Contatto contact = new Contatto();
            contact.setContatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("foto"), rs.getBoolean("security"));
            DLM.addElement(contact.getNome() + " " + contact.getCognome());
            pkContatti.add(rs.getInt("id"));
        }
        rs.close();
        s.close();
        return DLM;
    }

    public DefaultListModel getContattiSearchNumeriFissiPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException {
        pkContattiPrivati.clear();
        DLMPrivati.removeAllElements();
        s = connection.createStatement();

        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = TRUE " +
                    " ORDER BY NOME,COGNOME");
        }
        else if (ricerca.length()>3){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_FISSO " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND PREFISSO = '" + ricerca.substring(0,3) + "' AND NUMERO ILIKE '"+ricerca.substring(3)+"%'" +
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_FISSO " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND PREFISSO ILIKE '" + ricerca + "%'"+
                    " ORDER BY NOME,COGNOME");
        }
        while (rs.next()) {                                   //Finche non scorro tutto il resultSet
            Contatto contact = new Contatto();
            contact.setContatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("foto"), rs.getBoolean("security"));
            DLMPrivati.addElement(contact.getNome() + " " + contact.getCognome());
            pkContattiPrivati.add(rs.getInt("id"));
        }
        rs.close();
        s.close();
        return DLMPrivati;
    }
}
