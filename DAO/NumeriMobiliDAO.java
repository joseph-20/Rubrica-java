package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface NumeriMobiliDAO {

    public String getNumeriMobili(int pk) throws SQLException;

    public void creaNumeriMobili (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException;

    public int getcontNumNumeriMobili(int pk) throws SQLException;

    public void getArrayNumeriMobili (ArrayList<String> array,int pk) throws SQLException;

    public DefaultListModel getContattiSearchNumeriMobili(String ricerca, ArrayList<Integer> pkContatti) throws SQLException;

    public DefaultListModel getContattiSearchNumeriMobiliPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException;
}
