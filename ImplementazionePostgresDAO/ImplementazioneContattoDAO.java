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
    private String indirizzoPrincipale;
    private String indirizziSecondari;
    private String email;
    private String numeriFissi;
    private String numeriMobili;
    private ResultSet rs;
    private Statement s;
    private int cont = 0;


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

    public String getIndirizzoPrincipale (int pk) throws SQLException{
        cont = 0;
        indirizzoPrincipale = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI INDIRIZZO_PRINCIPALE
        rs = s.executeQuery("SELECT * " +
                            "FROM INDIRIZZO_PRINCIPALE " +
                            "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            indirizzoPrincipale = indirizzoPrincipale+(rs.getString("via")+","+rs.getString("civico")+","+rs.getString("citta")+","+rs.getString("cap")+","+rs.getString("nazione")+"<br/>");
            cont++;
        }
        indirizzoPrincipale = indirizzoPrincipale+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return indirizzoPrincipale;
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

    public String getIndirizziSecondari(int pk) throws SQLException{
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

    public String getEmail(int pk) throws SQLException{
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

    public String getNumeriFissi(int pk) throws SQLException{
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
}
