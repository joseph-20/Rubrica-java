package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface NumeriFissiDAO {

    public String getNumeriFissi(int pk) throws SQLException;
    public void creaNumeriFissi (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException;
    public int getcontNumNumeriFissi (int pk) throws SQLException;
    public void getArrayNumeriFissi (ArrayList<String> array,int pk) throws SQLException;
    public DefaultListModel getContattiSearchNumeriFissi(String ricerca, ArrayList<Integer> pkContatti) throws SQLException;
    public DefaultListModel getContattiSearchNumeriFissiPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException;
}
