package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ContattoDAO {

    public DefaultListModel getContatti (ArrayList<Integer> pkContatti) throws SQLException;
    public DefaultListModel getContattiPrivati (ArrayList<Integer> pkContattiPrivati) throws SQLException;
    public DefaultListModel getIndirizzoPrincipale (int pk) throws SQLException;
    public String getNome (int pk) throws SQLException;
    public String getCognome (int pk) throws SQLException;
    public DefaultListModel getIndirizziSecondari(int pk) throws SQLException;
    public DefaultListModel getEmail(int pk) throws SQLException;
    public DefaultListModel getNumeriFissi(int pk) throws SQLException;
    public DefaultListModel getNumeriMobili(int pk) throws SQLException;
}
