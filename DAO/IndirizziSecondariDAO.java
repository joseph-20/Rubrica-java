package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IndirizziSecondariDAO {

    public String getIndirizziSecondari(int pk) throws SQLException;

    public int getcontNumIndirizziSecondari(int pk) throws SQLException;

    public void getArrayIndirizziSecondari (ArrayList<String> array, int pk) throws SQLException;

    public void creaIndirizzoSecondario (String indirizzo,int id) throws SQLException;
}
