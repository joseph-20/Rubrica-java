package Controller;

import Model.Contatto;

import java.util.ArrayList;

public class Controller {
    //POSSIBILE SOLUZIONE 1 :

    //Dichiarazione variabili
    ArrayList<Contatto> contact = new ArrayList<Contatto>;

    /*
    CREARE UNA FUNZIONE CHE PRENDE DAL DATABASE TUTTI I CONTATTI
    E LI METTE NELL'ARRAYLIST
    public void getContattiDatabase()
     */



    public void creaContatto(String n,String co,boolean sec,String im){
        //Creazione del contatto tramite GUI
      Contatto c = new Contatto(n,co,sec,im);
      contact.add(c);
      //TODO
        //UNA VOLTA CREATO IL CONTATTO INSERIRLO ANCHE NEL DATABASE
    }

    //POSSIBILE SOLUZIONE 2
    public void CreaContatto(String n,String co,boolean sec,String im){
        //Importare la classe DAO,IMPLEMENTAZIONEDAO
        //Eseguire la funzione che esegue la query di inserimento database
    }

    public String getNomiContatti(){
        //Chiamare funzione che esegui query per avere tutti i nomi dei Contatti
    }

    public String getCognomiContatti(){
        //Chiamare funzione che esegue query per avere tutti i cognomi dei Contatti
    }

    public String getContactSecurity(){
        //Chiamare funzione che esegue query per avere le security
    }

    public String getFotoContatto(){
        //Chiamare funzione che invia il path a java e lo inserisce del database
    }

}
