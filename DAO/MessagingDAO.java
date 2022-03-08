package DAO;

import java.sql.SQLException;

public interface MessagingDAO {
    public String getServizio(String sistema, int pk) throws SQLException;

    public String getUsername(String sistema, int pk) throws SQLException;

    public String getEmail(String sistema, int pk) throws SQLException;

    public String getStato(String sistema, int pk) throws SQLException;

    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException;

    public void eliminaMessaging (int pk) throws SQLException;
}
