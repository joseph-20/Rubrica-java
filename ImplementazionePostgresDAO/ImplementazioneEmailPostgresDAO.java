package ImplementazionePostgresDAO;

import DAO.EmailDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneEmailPostgresDAO implements EmailDAO {
    private Connection connection;
    private String email;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private int index;
    private ArrayList<String> username = new ArrayList<>();
    private ArrayList<String> dominio = new ArrayList<>();
    private DefaultListModel<String> DLM = new DefaultListModel<>();
    private DefaultListModel<String> DLMPrivati = new DefaultListModel<>();
    private int num;

    public ImplementazioneEmailPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getEmail(int pk) throws SQLException {
        cont = 0;
        email = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI EMAIL
        rs = s.executeQuery("SELECT * " +
                "FROM EMAIL " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            email = email+(rs.getString("username")+"@"+rs.getString("dominio")+"<br/>");
            cont++;
        }
        email = email+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return email;
    }


    public void creaEmail (ArrayList<String> mail, int id, int n) throws SQLException{
        s = connection.createStatement();
        username.clear();
        dominio.clear();
        //QUERY DI AGGIUNTA DI TUTTE LE MAIL
        for(int i=0;i<n;i++){
            index = mail.get(i).indexOf('@');
            username.add(mail.get(i).substring(0,index));
            dominio.add(mail.get(i).substring(index+1));
            s.executeUpdate("INSERT INTO EMAIL " +
                            "VALUES ('"+username.get(i)+"','"+dominio.get(i)+"',"+id+")");
        }
    }


    public int getcontNumEmail (int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI CONTEGGIO
        rs = s.executeQuery("SELECT COUNT (*) as CONTEGGIO " +
                "FROM EMAIL " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            num = rs.getInt("CONTEGGIO");
        }
        return num;
    }


    public void getArrayEmail (ArrayList<String> array,int pk) throws SQLException{
        s = connection.createStatement();
        array.clear();
        //QUERY DI OTTENIMENTO USERNAME DOMINIO
        rs = s.executeQuery("SELECT USERNAME,DOMINIO " +
                "FROM EMAIL " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){
            array.add(rs.getString("USERNAME")+"@"+rs.getString("DOMINIO"));
        }
    }


    public DefaultListModel getContattiSearchEmail(String ricerca, ArrayList<Integer> pkContatti) throws SQLException {
        pkContatti.clear();
        DLM.removeAllElements();
        s = connection.createStatement();

        //Settaggio index
        index=0;
        index = ricerca.indexOf('@');
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID  " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = FALSE " +
                    "ORDER BY NOME,COGNOME");
        }
        else if(index!=-1) {
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,EMAIL " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND (USERNAME ILIKE '%"+ricerca.substring(0,index)+"%' AND DOMINIO ILIKE '%"+ricerca.substring(index+1)+"%')"+
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,EMAIL " +
                    "WHERE SECURITY = FALSE AND ID_CONTATTO = ID AND (USERNAME ILIKE '%" + ricerca + "%' OR DOMINIO ILIKE '%" + ricerca  + "%')" +
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


    public DefaultListModel getContattiSearchEmailPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException {
        pkContattiPrivati.clear();
        DLMPrivati.removeAllElements();
        s = connection.createStatement();

        //Settaggio index
        index=0;
        index = ricerca.indexOf('@');
        //QUERY DI SELEZIONE DEI CONTATTI CON SECURITY FALSE
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO " +
                    "WHERE SECURITY = TRUE " +
                    "ORDER BY NOME,COGNOME");
        }
        else if(index!=-1) {
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,EMAIL " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND (USERNAME ILIKE '%"+ricerca.substring(0,index)+"%' AND DOMINIO ILIKE '%"+ricerca.substring(index+1)+"%')"+
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT DISTINCT NOME,COGNOME,FOTO,SECURITY,ID " +
                    "FROM CONTATTO,EMAIL " +
                    "WHERE SECURITY = TRUE AND ID_CONTATTO = ID AND (USERNAME ILIKE '%" + ricerca + "%' OR DOMINIO ILIKE '%" + ricerca  + "%')" +
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
