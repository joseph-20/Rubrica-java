package DAO;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmailDAO {

    public String getEmail(int pk) throws SQLException;

    public void creaEmail (ArrayList<String> mail, int id, int n) throws SQLException;

    public int getcontNumEmail (int pk) throws SQLException;

    public void getArrayEmail (ArrayList<String> array,int pk) throws SQLException;

    public DefaultListModel getContattiSearchEmail(String ricerca, ArrayList<Integer> pkContatti) throws SQLException;

    public DefaultListModel getContattiSearchEmailPrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException;
}
