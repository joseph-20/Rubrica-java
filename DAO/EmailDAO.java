package DAO;
import java.sql.SQLException;

public interface EmailDAO {

    public String getEmail(int pk) throws SQLException;
}
