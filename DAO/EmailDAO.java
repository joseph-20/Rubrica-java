package DAO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmailDAO {

    public String getEmail(int pk) throws SQLException;
    public void creaEmail (ArrayList<String> username, ArrayList<String> dominio, int id, int n) throws SQLException;
}
