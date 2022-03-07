package Controller;

import DAO.*;
import Database.ConnessioneDatabase;
import ImplementazionePostgresDAO.*;

import javax.swing.*;
import java.awt.*;
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
    public int getLastId() throws SQLException{
       return contact.getLastId();
    }
    /* Interazione con il database dell'interfaccia ContattoDAO implementata da ImplementazioneContattoDAO
     di postgres per ricavare tutti i contatti privati dal database */
    public DefaultListModel getContattiPrivati(ArrayList<Integer> pkContatti) throws SQLException{
        return contact.getContattiPrivati(pkContatti);
    }
    public String getIndirizzoPrincipale (int pk) throws SQLException{
        return indirizzoP.getIndirizzoPrincipale(pk);
    }
    public void creaIndirizzoPrincipale (String indirizzo,int id) throws SQLException{
        indirizzoP.creaIndirizzoPrincipale(indirizzo,id);
    }
    public String getPath (int pk) throws SQLException{
        return contact.getPath(pk);
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
    public void creaEmail (ArrayList<String> mail, int id, int n) throws SQLException{
        email.creaEmail(mail,id,n);
    }
    public String getNumeriFissi(int pk) throws SQLException{
        return numeriF.getNumeriFissi(pk);
    }
    public void creaNumeriFissi (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        numeriF.creaNumeriFissi(prefisso,numero,id,n);
    }
    public String getNumeriMobili(int pk) throws SQLException{
        return numeriM.getNumeriMobili(pk);
    }
    public void creaNumeriMobili (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        numeriM.creaNumeriMobili(prefisso,numero,id,n);
    }
    public void swapVisibility (JPanel active,JPanel disable){
        active.setVisible(true);
        disable.setVisible(false);
    }
    public ImageIcon SetImageSize(String path,int width,int height){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);

        return newImc;
    }
    public void cancellaContatto(int pk) throws SQLException {
        contact.cancellaContatto(pk);
    }
    public int creaContatto(String pathFoto,String nome,String cognome,boolean security) throws SQLException{
        return contact.creaContatto(pathFoto,nome,cognome,security);
    }
}
