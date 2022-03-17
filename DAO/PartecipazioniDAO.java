package DAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public interface PartecipazioniDAO {

    public void setPartecipazioni (ArrayList pk, String gruppo) throws SQLException;

    public void setIdToLast (int precId,int lastId) throws SQLException;

    public String getPartecipanti (String gruppo) throws SQLException;

    public void eliminaGruppo (String gruppo) throws SQLException;

    public DefaultListModel getGruppiSearchContatto(String ricerca) throws SQLException;

}
