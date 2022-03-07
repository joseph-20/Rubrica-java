package DAO;

import java.sql.SQLException;

public interface IndirizzoPrincipaleDAO {

    public String getIndirizzoPrincipale (int pk) throws SQLException;
    public void creaIndirizzoPrincipale (String indirizzo,int id) throws SQLException;
}
