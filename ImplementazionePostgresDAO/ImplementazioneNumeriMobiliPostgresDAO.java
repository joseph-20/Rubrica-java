package ImplementazionePostgresDAO;

import DAO.NumeriMobiliDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
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
    private DefaultListModel<String> DLM = new DefaultListModel<>();
    private DefaultListModel<String> DLMPrivati = new DefaultListModel<>();

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


    public DefaultListModel getContattiSearchNumeriMobili(String ricerca, ArrayList<Integer> pkContatti) throws SQLException {
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
                    "FROM CONTATTO,NUMERO_MOBILE " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND PREFISSO ILIKE '%" + ricerca.substring(0,3) + "%' AND NUMERO ILIKE '"+ricerca.substring(3)+"%'" +
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_MOBILE " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND PREFISSO ILIKE '%" + ricerca + "%'"+
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


    public DefaultListModel getContattiSearchNumeriMobiliPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException {
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
                    "FROM CONTATTO,NUMERO_MOBILE " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND PREFISSO ILIKE '%" + ricerca.substring(0,3) + "%' AND NUMERO ILIKE '%"+ricerca.substring(3)+"%'" +
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,NUMERO_MOBILE " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND PREFISSO ILIKE '%" + ricerca + "%'"+
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
