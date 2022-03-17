package DAO;

import javax.swing.*;
import java.sql.SQLException;

public interface GruppoDAO {

    public void setGruppo (String nome) throws SQLException;

    public DefaultListModel setDLMGruppi() throws SQLException;

    public DefaultListModel getGruppiSearch(String ricerca) throws SQLException;

}
