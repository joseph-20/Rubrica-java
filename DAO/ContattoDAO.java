package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ContattoDAO {

    public DefaultListModel getContatti (ArrayList<Integer> pkContatti) throws SQLException;
    public DefaultListModel getContattiPrivati (ArrayList<Integer> pkContattiPrivati) throws SQLException;
    public String getIndirizzoPrincipale (int pk) throws SQLException;
    public String getNome (int pk) throws SQLException;
    public String getCognome (int pk) throws SQLException;
    public String getIndirizziSecondari(int pk) throws SQLException;
    public String getEmail(int pk) throws SQLException;
    public String getNumeriFissi(int pk) throws SQLException;
    public String getNumeriMobili(int pk) throws SQLException;
}
