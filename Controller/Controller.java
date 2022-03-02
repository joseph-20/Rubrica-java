package Controller;

import DAO.*;
import Database.ConnessioneDatabase;
import ImplementazionePostgresDAO.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {
    private ContattoDAO contact = new ImplementazioneContattoPostgresDAO();
    private EmailDAO email = new ImplementazioneEmailPostgresDAO();
    private IndirizzoPrincipaleDAO indirizzoP = new ImplementazioneIndirizzoPrincipalePostgresDAO();
    private IndirizziSecondariDAO indirizziS = new ImplementazioneIndirizziSecondariPostgresDAO();
    private NumeriFissiDAO numeriF = new ImplementazioneNumeriFissiPostgresDAO();
    private NumeriMobiliDAO numeriM = new ImplementazioneNumeriMobiliPostgresDAO();

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
    public String getIndirizzoPrincipale (int pk) throws SQLException{
        return indirizzoP.getIndirizzoPrincipale(pk);
    }
    public String getNome (int pk) throws SQLException{
        return contact.getNome(pk);
    }
    public String getCognome (int pk) throws SQLException{
        return contact.getCognome(pk);
    }
    public String getIndirizziSecondari(int pk) throws SQLException{
        return indirizziS.getIndirizziSecondari(pk);
    }
    public String getEmail(int pk) throws SQLException{
        return email.getEmail(pk);
    }
    public String getNumeriFissi(int pk) throws SQLException{
        return numeriF.getNumeriFissi(pk);
    }
    public String getNumeriMobili(int pk) throws SQLException{
        return numeriM.getNumeriMobili(pk);
    }
}
