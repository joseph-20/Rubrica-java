package Controller;

import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller {


    public void CreaContatto(String n,String co,boolean sec,String im){
        //Importare la classe DAO,IMPLEMENTAZIONEDAO
        //Eseguire la funzione che esegue la query di inserimento database
    }


   public Connection getConnection () throws SQLException {
        ConnessioneDatabase conn = ConnessioneDatabase.getInstance();
        return conn.getConnection();
   }

}
