package DAO;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmailDAO {

    public String getEmail(int pk) throws SQLException;
}
