package ImplementazionePostgresDAO;

import DAO.MessagingDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneMessagingPostgresDAO implements MessagingDAO {
    private Connection connection;
    private String numeriMobili;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private String servizio = null;
    private String username;
    private String email;
    private String stato;
    private String emailUsername;
    private String emailDominio;
    private DefaultListModel<String> DLM = new DefaultListModel<>();
    private DefaultListModel<String> DLMPrivati = new DefaultListModel<>();
    private int index;

    public ImplementazioneMessagingPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getServizio(String sistema,int pk) throws SQLException {
        s = connection.createStatement();
        cont=0;
        //QUERY DI SELEZIONE SERVIZIO PER ID CONTATTO
        rs = s.executeQuery("SELECT SERVIZIO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            servizio = rs.getString("SERVIZIO");
            cont++;
        }
        if(cont==0){
            return null;
        }
        return servizio;
    }

    public String getUsername (String sistema,int pk) throws SQLException{
        s= connection.createStatement();
        //QUERY DI OTTENIMENTO USERNAME
        rs = s.executeQuery("SELECT USERNAME " +
                            "FROM SISTEMA_DI_MESSAGING " +
                            "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            username = rs.getString("username");
        }
        return username;
    }

    public String getEmail (String sistema,int pk) throws SQLException{
        s= connection.createStatement();
        //QUERY DI OTTENIMENTO EMAIL
        rs = s.executeQuery("SELECT EMAIL_USERNAME,EMAIL_DOMINIO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            email = rs.getString("EMAIL_USERNAME")+"@"+rs.getString("EMAIL_DOMINIO");
        }
        return email;
    }

    public String getStato (String sistema,int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI OTTENIMENTO STATO
        rs = s.executeQuery("SELECT STATO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            stato = rs.getString("STATO");
        }
        return stato;
    }

    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException {
        s = connection.createStatement();
        //scomposizione email
        index = email.indexOf('@');
        emailUsername = email.substring(0,index);
        emailDominio = email.substring(index+1);
        //QUERY DI CREAZIONE MESSAGING
        s.executeUpdate("INSERT INTO SISTEMA_DI_MESSAGING " +
                        "VALUES ('"+username+"','"+servizio+"','"+stato+"','"+emailUsername+"','"+emailDominio+"',"+pk+")");
    }

    public void eliminaMessaging (int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI ELIMINAZIONE
        s.executeUpdate("DELETE FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk);
        }

    public DefaultListModel getContattiSearchUsername(String ricerca, ArrayList<Integer> pkContatti) throws SQLException {
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
        else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,SISTEMA_DI_MESSAGING " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND USERNAME ILIKE '%" + ricerca + "%'" +
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

    public DefaultListModel getContattiSearchUsernamePrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException {
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
        else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,SISTEMA_DI_MESSAGING " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND USERNAME ILIKE '%" + ricerca + "%'" +
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
    public void setIdToLast (int precId,int lastId) throws SQLException {
        s = connection.createStatement();

        //QUERY DI AGGIORNAMENTO
       s.executeUpdate("UPDATE SISTEMA_DI_MESSAGING " +
                        "SET ID_CONTATTO = "+lastId+" " +
                        "WHERE ID_CONTATTO = "+precId);
    }
}
