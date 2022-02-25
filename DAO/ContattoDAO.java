package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ContattoDAO {

    public DefaultListModel getContatti (ArrayList<Integer> pkContatti) throws SQLException;
    public DefaultListModel getContattiPrivati (ArrayList<Integer> pkContattiPrivati) throws SQLException;
}
