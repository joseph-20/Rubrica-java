package ImplementazionePostgresDAO;
import DAO.ContattoDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;
import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneContattoDAO implements ContattoDAO {

    private Connection connection;

    private ArrayList<Integer> pkCon;
    DefaultListModel DLM = new DefaultListModel();
    DefaultListModel DLMPrivati = new DefaultListModel();
    DefaultListModel DLMIndirizzoPrincipale = new DefaultListModel();
    private ResultSet rs;
    private Statement s;


    public ImplementazioneContattoDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public DefaultListModel getContatti (ArrayList<Integer> pkContatti) throws SQLException {
        s = connection.createStatement();
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        rs = s.executeQuery("SELECT * " +
                "FROM CONTATTO " +
                "WHERE SECURITY = FALSE " +
                "ORDER BY NOME,COGNOME");
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

    public DefaultListModel getContattiPrivati (ArrayList<Integer> pkContattiPrivati) throws SQLException{
        s = connection.createStatement();
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY TRUE
        rs = s.executeQuery("SELECT * " +
                "FROM CONTATTO " +
                "WHERE SECURITY = TRUE " +
                "ORDER BY NOME,COGNOME");
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

    public DefaultListModel getIndirizzoPrincipale (int pk) throws SQLException{
        DLMIndirizzoPrincipale.removeAllElements();
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI INDIRIZZO_PRINCIPALE
        rs = s.executeQuery("SELECT * " +
                            "FROM INDIRIZZO_PRINCIPALE " +
                            "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            DLMIndirizzoPrincipale.addElement(rs.getString("via")+","+rs.getString("civico")+","+rs.getString("citta")+","+rs.getString("cap")+","+rs.getString("nazione"));
        }
        return DLMIndirizzoPrincipale;
    }

    public String getNome (int pk) throws SQLException {
        String name = new String();
        s = connection.createStatement();
        //QUERY DI SELEZIONE NOME CONTATTO
        rs = s.executeQuery("SELECT NOME " +
                "FROM CONTATTO " +
                "WHERE ID = " + pk);
        while (rs.next()) {
            name =  rs.getString("NOME");
        }
        return name;
    }

    public String getCognome (int pk) throws SQLException {
        String surname = new String();
        s = connection.createStatement();
        //QUERY DI SELEZIONE NOME CONTATTO
        rs = s.executeQuery("SELECT COGNOME " +
                "FROM CONTATTO " +
                "WHERE ID = " + pk);
        while (rs.next()) {
            surname = rs.getString("COGNOME");
        }
        return surname;
    }

}
