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
    private MessagingDAO messaging = new ImplementazioneMessagingPostgresDAO();
    private ReindirizzamentoDAO reindirizzamento = new ImplementazioneReindirizzamentoPostgresDAO();
    private ImageIcon img;
    private DefaultComboBoxModel dlmServizi = new DefaultComboBoxModel();
    private DefaultComboBoxModel dlmReindirizzamentiMobili = new DefaultComboBoxModel();
    private DefaultComboBoxModel dlmReindirizzamentiFissi = new DefaultComboBoxModel();
    private int pk;
    private String username;
    private String emailServizio;
    private String stato;
    private String servizioMessaging;
    private String reindirizzamentoInfo;

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
       return contact.getLastId()+1;
    }
    public void setImg (String path){
       img = this.SetImageSize(path,70,70);
    }
    public void setDlmServizi(String mail,int reset){
       if(reset == 1){
           dlmServizi.removeAllElements();
           dlmServizi.addElement(mail);
       }else {
           dlmServizi.addElement(mail);
       }
    }
    public void setDlmReindirizzamentiMobili(String numero,int reset){
        if(reset == 1){
            dlmReindirizzamentiMobili.removeAllElements();
            dlmReindirizzamentiMobili.addElement(numero);
        }else {
            dlmReindirizzamentiMobili.addElement(numero);
        }
    }
    public void setDlmReindirizzamentiFissi(String numero,int reset){
        if(reset == 1){
            dlmReindirizzamentiFissi.removeAllElements();
            dlmReindirizzamentiFissi.addElement(numero);
        }else {
            dlmReindirizzamentiFissi.addElement(numero);
        }
    }
    public void creaReindirizzamento (String numero_mobile,String numero_fisso,int pk) throws SQLException{
       reindirizzamento.creaReindirizzamento(numero_mobile,numero_fisso,pk);
    }
    public DefaultComboBoxModel getDlmServizi(){
       return dlmServizi;
    }
    public DefaultComboBoxModel getDlmReindirizzamentiMobili(){
        return dlmReindirizzamentiMobili;
    }
    public DefaultComboBoxModel getDlmReindirizzamentiFissi(){
        return dlmReindirizzamentiFissi;
    }
    public ImageIcon getImg (){
       return img;
    }
    public void setPk(int primary){
       pk = primary;
    }
    public int getPk(){
       return pk;
    }
    public void setServizioMessaging (String servizio){
       servizioMessaging = servizio;
    }
    public String getServizioMessaging(){
       return servizioMessaging;
    }
    public String getServizio(String sistema,int pk) throws SQLException {
       return messaging.getServizio(sistema, pk);
    }
    public void setUsername (String sistema,int pk) throws SQLException{
       username = messaging.getUsername(sistema,pk);
    }
    public void setEmail (String sistema,int pk) throws SQLException{
       emailServizio = messaging.getEmail(sistema,pk);
    }
    public void setStato (String sistema,int pk) throws SQLException{
       stato = messaging.getStato(sistema,pk);
    }
    public String getUsername(){
       return username;
    }
    public String getEmail(){
       return emailServizio;
    }
    public String getStato(){
       return stato;
    }
    public void eliminaMessaging (int pk) throws SQLException{
       messaging.eliminaMessaging(pk);
    }
    public void eliminaReindirizzamento (int pk) throws SQLException{
       reindirizzamento.eliminaReindirizzamento(pk);
    }
    public void setReindirizzamenti(int pk) throws SQLException{
      reindirizzamentoInfo = reindirizzamento.getReindirizzamenti(pk);
    }
    public String getReindirizzamenti(){
       return reindirizzamentoInfo;
    }
    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException{
       messaging.creaMessaging(username,servizio,stato,email,pk);
    }
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
