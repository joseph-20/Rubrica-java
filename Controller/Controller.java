package Controller;

import DAO.*;
import Database.ConnessioneDatabase;
import ImplementazionePostgresDAO.*;
import Model.Password;

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
    private PasswordDAO password = new ImplementazionePasswordPostgresDAO();
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
    private JTabbedPane jt;
    private int lastint;
    private JPanel pan;

    //Comunicazione con il DB per ottenere tutti i contatti e ritornare un DLM
   public DefaultListModel getContatti(ArrayList<Integer> pkContatti) throws SQLException{
       return contact.getContatti(pkContatti);
   }

   //Comunicazione con il DB per ottenere tutti i contatti coerenti con la ricerca e ritornare un DLM
    public DefaultListModel getContattiSearch(String ricerca,ArrayList<Integer> pkContatti) throws SQLException{
       return contact.getContattiSearch(ricerca,pkContatti);
    }

    //Comunicazione con il DB per ritornare l'ultimo id
    public int getLastId() throws SQLException{
       return contact.getLastId()+1;
    }

    //Ridimensionamento di un immagine
    public void setImg (String path){
       img = this.SetImageSize(path,70,70);
    }

    //Creazione di un DLM per i servizi
    public void setDlmServizi(String mail,int reset){
       if(reset == 1){
           dlmServizi.removeAllElements();
           dlmServizi.addElement(mail);
       }else {
           dlmServizi.addElement(mail);
       }
    }

    //Comunicazione con il DB per ottenere tutti i contatti privati coerenti con la ricerca e ritornare un DLM
    public DefaultListModel getContattiSearchPrivati(String ricerca,ArrayList<Integer> pkContatti) throws SQLException{
       return contact.getContattiSearchPrivati(ricerca,pkContatti);
    }

    // //Creazione di un DLM per i servizi
    public void setDlmReindirizzamentiMobili(String numero,int reset){
        if(reset == 1){
            dlmReindirizzamentiMobili.removeAllElements();
            dlmReindirizzamentiMobili.addElement(numero);
        }else {
            dlmReindirizzamentiMobili.addElement(numero);
        }
    }

    //Creazione di un DLM per i reindirizzamenti di numeri fissi
    public void setDlmReindirizzamentiFissi(String numero,int reset){
        if(reset == 1){
            dlmReindirizzamentiFissi.removeAllElements();
            dlmReindirizzamentiFissi.addElement(numero);
        }else {
            dlmReindirizzamentiFissi.addElement(numero);
        }
    }

    //Comunicazione con il database per inserire un reindirizzamento
    public void creaReindirizzamento (String numero_mobile,String numero_fisso,int pk) throws SQLException{
       reindirizzamento.creaReindirizzamento(numero_mobile,numero_fisso,pk);
    }

    //Ritorna il DLM servizi
    public DefaultComboBoxModel getDlmServizi(){
       return dlmServizi;
    }

    //Ritorna il DLM dei reindirizzamenti mobili
    public DefaultComboBoxModel getDlmReindirizzamentiMobili(){
        return dlmReindirizzamentiMobili;
    }

    ////Ritorna il DLM dei reindirizzamenti fissi
    public DefaultComboBoxModel getDlmReindirizzamentiFissi(){
        return dlmReindirizzamentiFissi;
    }

    //Ritorna l'img settata
    public ImageIcon getImg (){
       return img;
    }

    //Setta la primary key di un contatto nel controller
    public void setPk(int primary){
       pk = primary;
    }

    //Ritorna la primary key settata nel controller
    public int getPk(){
       return pk;
    }

    //Setta il nome del servizio di messaging
    public void setServizioMessaging (String servizio){
       servizioMessaging = servizio;
    }

    //Ritorna il nome del servizio di messaging
    public String getServizioMessaging(){
       return servizioMessaging;
    }

    //Ritorna il servizio
    public String getServizio(String sistema,int pk) throws SQLException {
       return messaging.getServizio(sistema, pk);
    }

    //Ritorna l'username del servizio
    public void setUsername (String sistema,int pk) throws SQLException{
       username = messaging.getUsername(sistema,pk);
    }

    //Setta l'email per il servizio
    public void setEmail (String sistema,int pk) throws SQLException{
       emailServizio = messaging.getEmail(sistema,pk);
    }

    //Setta lo stato per il servizio
    public void setStato (String sistema,int pk) throws SQLException{
       stato = messaging.getStato(sistema,pk);
    }

    //Ritorna l'username del servizio
    public String getUsername(){
       return username;
    }

    //Ritorna l'email del servizio
    public String getEmail(){
       return emailServizio;
    }

    //Ritorna lo stato
    public String getStato(){
       return stato;
    }

    //Elimina il sistema di messaging di pk
    public void eliminaMessaging (int pk) throws SQLException{
       messaging.eliminaMessaging(pk);
    }

    //Elimina i reindirizzamenti di pk
    public void eliminaReindirizzamento (int pk) throws SQLException{
       reindirizzamento.eliminaReindirizzamento(pk);
    }

    //Setta i reindirizzamenti di pk
    public void setReindirizzamenti(int pk) throws SQLException{
      reindirizzamentoInfo = reindirizzamento.getReindirizzamenti(pk);
    }

    //Ritorna le info reindirizzamenti
    public String getReindirizzamenti(){
       return reindirizzamentoInfo;
    }

    //Crea il sistema di messaging
    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException{
       messaging.creaMessaging(username,servizio,stato,email,pk);
    }

    //Ritorna il DLM dei contatti privati di pkContatti
    public DefaultListModel getContattiPrivati(ArrayList<Integer> pkContatti) throws SQLException{
        return contact.getContattiPrivati(pkContatti);
    }

    //Ritorna l'indirizzo principale di pk
    public String getIndirizzoPrincipale (int pk) throws SQLException{
        return indirizzoP.getIndirizzoPrincipale(pk);
    }

    //Crea l'indirizzo principale per pk
    public void creaIndirizzoPrincipale (String indirizzo,int id) throws SQLException{
        indirizzoP.creaIndirizzoPrincipale(indirizzo,id);
    }

    //Ritorna il path della foto di pk
    public String getPath (int pk) throws SQLException{
        return contact.getPath(pk);
    }

    //Ritonra il nome di pk
    public String getNome (int pk) throws SQLException{
        return contact.getNome(pk);
    }

    //Ritorna il cognome di pk
    public String getCognome (int pk) throws SQLException{
        return contact.getCognome(pk);
    }

    //Ritorna gli indirizzi secondari di pk
    public String getIndirizziSecondari(int pk) throws SQLException{
        return indirizziS.getIndirizziSecondari(pk);
    }

    //Ritorna le mail di pk
    public String getEmail(int pk) throws SQLException{
        return email.getEmail(pk);
    }

    //Crea le mail per pk
    public void creaEmail (ArrayList<String> mail, int id, int n) throws SQLException{
        email.creaEmail(mail,id,n);
    }

    //Ritorna i numeri fissi di pk
    public String getNumeriFissi(int pk) throws SQLException{
        return numeriF.getNumeriFissi(pk);
    }

    //Crea i numeri fissi per pk
    public void creaNumeriFissi (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        numeriF.creaNumeriFissi(prefisso,numero,id,n);
    }

    //Ritorna i numeri mobili per pk
    public String getNumeriMobili(int pk) throws SQLException{
        return numeriM.getNumeriMobili(pk);
    }

    //Crea i numeri mobili per pk
    public void creaNumeriMobili (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException{
        numeriM.creaNumeriMobili(prefisso,numero,id,n);
    }

    //Swappa la visibilità di due panel
    public void swapVisibility (JPanel active,JPanel disable){
        active.setVisible(true);
        disable.setVisible(false);
    }

    //Setta la grandezza di un immagine
    public ImageIcon SetImageSize(String path,int width,int height){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);

        return newImc;
    }

    //Cancella il contatto pk
    public void cancellaContatto(int pk) throws SQLException {
        contact.cancellaContatto(pk);
    }

    //Crea un contatto
    public int creaContatto(String pathFoto,String nome,String cognome,boolean security) throws SQLException{
        return contact.creaContatto(pathFoto,nome,cognome,security);
    }

    //Ritorna il numeri di mail che ha pk
    public int getcontNumEmail (int pk) throws SQLException{
      return email.getcontNumEmail(pk);
    }

    //Ritorna il numero di numeri fissi che ha pk
    public int getcontNumNumeriFissi (int pk) throws SQLException{
       return numeriF.getcontNumNumeriFissi(pk);
    }

    //Ritorna il numero di numeri mobili che ha pk
    public int getcontNumNumeriMobili(int pk) throws SQLException{
      return numeriM.getcontNumNumeriMobili(pk);
    }

    //Ritorna il numero di indirizzi secondari che ha pk
    public int getcontNumIndirizziSecondari(int pk) throws SQLException{
       return indirizziS.getcontNumIndirizziSecondari(pk);
    }

    //Ritorna l'array di email
    public void getArrayEmail (ArrayList<String> array,int pk) throws SQLException{
       email.getArrayEmail(array,pk);
    }

    //Ritorna l'array di numeri fissi
    public void getArrayNumeriFissi (ArrayList<String> array,int pk) throws SQLException{
       numeriF.getArrayNumeriFissi(array,pk);
    }

    //Ritorna l'array di numeri mobili
    public void getArrayNumeriMobili (ArrayList<String> array,int pk) throws SQLException{
       numeriM.getArrayNumeriMobili(array,pk);
    }

    //Ritorna l'array di indirzzi secondari
    public void getArrayIndirizziSecondari (ArrayList<String> array, int pk) throws SQLException{
       indirizziS.getArrayIndirizziSecondari(array,pk);
    }

    //Ritorna l'indirzzi secondario staccato dalle stringhe di html per le info
    public String getIndirizzoPrincipaleNoHTML (int pk) throws SQLException{
       return indirizzoP.getIndirizzoPrincipaleNoHTML(pk);
    }

    //Ritorna i contatti coerenti con la ricerca per mail
    public DefaultListModel getContattiSearchEmail(String ricerca, ArrayList<Integer> pkContatti) throws SQLException{
       return email.getContattiSearchEmail(ricerca,pkContatti);
    }

    //Ritorna i contatti coerenti con la ricerca per email privata
    public DefaultListModel getContattiSearchEmailPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException{
       return email.getContattiSearchEmailPrivati(ricerca,pkContattiPrivati);
    }

    //Ritorna i contatti coerenti con la ricerca per username
    public DefaultListModel getContattiSearchUsername(String ricerca, ArrayList<Integer> pkContatti) throws SQLException{
       return messaging.getContattiSearchUsername(ricerca,pkContatti);
    }

    //Ritorna i contatti coerenti con la ricerca per username privati
    public DefaultListModel getContattiSearchUsernamePrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException{
      return messaging.getContattiSearchUsernamePrivati(ricerca,pkContattiPrivati);
    }

    //Ritorna i contatti coerenti con la ricerca per numeri fissi
    public DefaultListModel getContattiSearchNumeriFissi(String ricerca, ArrayList<Integer> pkContatti) throws SQLException{
       return numeriF.getContattiSearchNumeriFissi(ricerca,pkContatti);
    }

    //Ritorna i contatti coerenti con la ricerca per numeri fissi privati
    public DefaultListModel getContattiSearchNumeriFissiPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException{
       return numeriF.getContattiSearchNumeriFissiPrivati(ricerca,pkContattiPrivati);
    }

    //Ritorna i contatti coerenti con la ricerca per numeri mobili
    public DefaultListModel getContattiSearchNumeriMobili(String ricerca, ArrayList<Integer> pkContatti) throws SQLException{
       return numeriM.getContattiSearchNumeriMobili(ricerca, pkContatti);
    }

    //Ritorna i contatti coerenti con la ricerca per numeri mobili privati
    public DefaultListModel getContattiSearchNumeriMobiliPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException{
       return numeriM.getContattiSearchNumeriMobiliPrivati(ricerca,pkContattiPrivati);
    }

    //Setta gli id dei sistemi di messaging di un contatto che viene modificato a LastId
    public void setIdToLastMessaging (int precId,int lastId) throws SQLException{
       messaging.setIdToLast(precId,lastId);
    }

    //Setta gli id dei reindirizzamenti di un contatto che viene modificato a LastId
    public void setIdToLastReindirizzamenti (int precId,int lastId) throws SQLException{
       reindirizzamento.setIdToLast(precId,lastId);
    }

    //Crea un indirizzo secondario
    public void creaIndirizzoSecondario (String indirizzo,int id) throws SQLException{
       indirizziS.creaIndirizzoSecondario(indirizzo,id);
    }

    //Eliminazione di tutti i sistemi di messaging di cui non esistono più mail
    public void deleteSistemaMessaging () throws SQLException{
       messaging.deleteSistemaMessaging();
    }

    //Eliminazione di tutti i reindirizzamenti di cui non esistono più numeri
    public void deleteReindirizzamento () throws SQLException{
       reindirizzamento.deleteReindirizzamento();
    }

    //Ritorno della password settata
    public String getPassword () throws SQLException{
      return password.getPassword();
    }

    //Settaggio tabs di window per CreaPassword
    public void setJTabs(JTabbedPane jtb){
       jt = jtb;
    }

    //Get tabs di window per CreaPassword
    public JTabbedPane getJTabs (){
       return jt;
    }

    //Query di set password
    public void setPassword(String pw) throws SQLException{
       password.setPassword(pw);
    }

    //Setta l'ultimo int di TabbedPane
    public void setLastInt(int l){
       lastint = l;
    }

    //Ritorna l'ultimo int di TabbedPane
    public int getLastInt(){
       return lastint;
    }

    //Setta il panel da rendere false in un altra gui
    public void setPanel (JPanel p){
       pan = p;
    }

    //Ritorna il panel
    public JPanel getPanel (){
       return pan;
    }
}
