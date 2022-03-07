package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ContattoDAO {

    public DefaultListModel getContatti (ArrayList<Integer> pkContatti) throws SQLException;
    public DefaultListModel getContattiPrivati (ArrayList<Integer> pkContattiPrivati) throws SQLException;
    public String getNome (int pk) throws SQLException;
    public String getCognome (int pk) throws SQLException;
    public void cancellaContatto(int pk) throws SQLException;
    public int creaContatto(String pathFoto,String nome,String cognome,boolean security) throws SQLException;
    public String getPath (int pk) throws SQLException;
    public int getLastId() throws SQLException;
}
