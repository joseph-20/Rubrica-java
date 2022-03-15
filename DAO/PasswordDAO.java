package DAO;

import java.sql.SQLException;

public interface PasswordDAO {

    public String getPassword () throws SQLException;

    public void setPassword(String pw) throws SQLException;
}
