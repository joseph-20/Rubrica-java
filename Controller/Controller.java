package Controller;

import DAO.ContattoDAO;
import Database.ConnessioneDatabase;
import ImplementazionePostgresDAO.ImplementazioneContattoDAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    private ContattoDAO contact = new ImplementazioneContattoDAO();

   public Connection getConnection () throws SQLException {
        ConnessioneDatabase conn = ConnessioneDatabase.getInstance();
        return conn.getConnection();
   }
   /* Interazione con il database dell'interfaccia ContattoDAO implementata da ImplementazioneContattoDAO
    di postgres per ricavare tutti i contatti dal database */
   public DefaultListModel getContatti(ArrayList<Integer> pkContatti) throws SQLException{
       return contact.getContatti(pkContatti);
   }
    /* Interazione con il database dell'interfaccia ContattoDAO implementata da ImplementazioneContattoDAO
     di postgres per ricavare tutti i contatti privati dal database */
    public DefaultListModel getContattiPrivati(ArrayList<Integer> pkContatti) throws SQLException{
        return contact.getContattiPrivati(pkContatti);
    }
    public DefaultListModel getIndirizzoPrincipale (int pk) throws SQLException{
        return contact.getIndirizzoPrincipale(pk);
    }
    public String getNome (int pk) throws SQLException{
        return contact.getNome(pk);
    }
    public String getCognome (int pk) throws SQLException{
        return contact.getCognome(pk);
    }
}
