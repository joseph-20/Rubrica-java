package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MessagingDAO {
    public String getServizio(String sistema, int pk) throws SQLException;

    public String getUsername(String sistema, int pk) throws SQLException;

    public String getEmail(String sistema, int pk) throws SQLException;

    public String getStato(String sistema, int pk) throws SQLException;

    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException;

    public void eliminaMessaging (int pk) throws SQLException;

    public DefaultListModel getContattiSearchUsername(String ricerca, ArrayList<Integer> pkContatti) throws SQLException;

    public DefaultListModel getContattiSearchUsernamePrivati(String ricerca, ArrayList<Integer> pkContattiPrivati) throws SQLException;

    public void setIdToLast (int precId,int lastId) throws SQLException;
}
