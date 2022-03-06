package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NumeriFissiDAO {

    public String getNumeriFissi(int pk) throws SQLException;
    public void creaNumeriFissi (ArrayList<String> prefisso, ArrayList<String> numero, int id, int n) throws SQLException;
}
