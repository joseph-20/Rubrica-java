package ImplementazionePostgresDAO;
import DAO.ContattoDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneContattoPostgresDAO implements ContattoDAO {

    private Connection connection;

    private DefaultListModel DLM = new DefaultListModel();
    private DefaultListModel DLMPrivati = new DefaultListModel();
    private ResultSet rs;
    private Statement s;
    private String name;
    private String surname;
    private String path;
    private int pk;
    private int index;


    public ImplementazioneContattoPostgresDAO() {
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DefaultListModel getContatti(ArrayList<Integer> pkContatti) throws SQLException {
        pkContatti.clear();
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


    public DefaultListModel getContattiSearch(String ricerca,ArrayList<Integer> pkContatti) throws SQLException {
        pkContatti.clear();
        DLM.removeAllElements();
        s = connection.createStatement();

        //Settaggio index
        index=0;
        index = ricerca.indexOf(' ');
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = FALSE " +
                    "ORDER BY NOME,COGNOME");
        }
        else if(index!=-1) {
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = FALSE AND (NOME ILIKE '%"+ricerca.substring(0,index)+"%' AND COGNOME ILIKE '%"+ricerca.substring(index+1)+"%')"+
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = FALSE AND (NOME ILIKE '%" + ricerca + "%' OR COGNOME ILIKE '%" + ricerca  + "%')" +
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


    public DefaultListModel getContattiSearchPrivati(String ricerca,ArrayList<Integer> pkContattiPrivati) throws SQLException {
        pkContattiPrivati.clear();
        DLMPrivati.removeAllElements();
        s = connection.createStatement();

        //Settaggio index
        index=0;
        index = ricerca.indexOf(' ');
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY TRUE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = TRUE " +
                    "ORDER BY NOME,COGNOME");
        }
        else if(index!=-1) {
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = TRUE AND (NOME ILIKE '%"+ricerca.substring(0,index)+"%' AND COGNOME ILIKE '%"+ricerca.substring(index+1)+"%')"+
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT * " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = TRUE AND (NOME ILIKE '%" + ricerca + "%' OR COGNOME ILIKE '%" + ricerca  + "%')" +
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


    public DefaultListModel getContattiPrivati(ArrayList<Integer> pkContattiPrivati) throws SQLException {
        pkContattiPrivati.clear();
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

    public String getPath(int pk) throws SQLException {
        s = connection.createStatement();
        //QUERY DI SELEZIONE PATH CONTATTO
        rs = s.executeQuery("SELECT FOTO " +
                "FROM CONTATTO " +
                "WHERE ID = " + pk);
        while (rs.next()) {
            path = rs.getString("FOTO");
        }
        return path;
    }


    public String getNome(int pk) throws SQLException {
        s = connection.createStatement();
        //QUERY DI SELEZIONE NOME CONTATTO
        rs = s.executeQuery("SELECT NOME " +
                "FROM CONTATTO " +
                "WHERE ID = " + pk);
        while (rs.next()) {
            name = rs.getString("NOME");
        }
        return name;
    }


    public String getCognome(int pk) throws SQLException {
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


    public void cancellaContatto(int pk) throws SQLException {
        s = connection.createStatement();
        //QUERY DI CANCELLAZIONE CONTATTO
        s.executeUpdate("DELETE " +
                "FROM CONTATTO " +
                "WHERE ID = " + pk);
        s.executeUpdate("DELETE " +
                        "FROM SISTEMA_DI_MESSAGING " +
                        "WHERE ID_CONTATTO = " + pk);
    }


    public int creaContatto(String pathFoto, String nome, String cognome, boolean security) throws SQLException {
        s = connection.createStatement();
        //QUERY DI CREAZIONE CONTATTO
        s.executeUpdate("INSERT INTO CONTATTO (FOTO,NOME,COGNOME,SECURITY) " +
                "VALUES (" + pathFoto + ",'" + nome + "','" + cognome + "'," + security + ")");
        rs = s.executeQuery("SELECT ID " +
                "FROM CONTATTO " +
                "WHERE NOME = '" + nome + "' AND COGNOME = '" + cognome + "' AND SECURITY = " + security);
        while (rs.next()) {
            pk = rs.getInt("id");
        }
        return pk;
    }


    public int getLastId() throws SQLException {
        s = connection.createStatement();
        rs = s.executeQuery("SELECT LAST_VALUE " +
                "FROM CONTATTO_ID_SEQ");
        while (rs.next()) {
            pk = rs.getInt(1);
        }
        return pk;
    }
}
