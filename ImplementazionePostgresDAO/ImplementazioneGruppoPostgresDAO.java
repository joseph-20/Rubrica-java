package ImplementazionePostgresDAO;

import DAO.GruppoDAO;
import Database.ConnessioneDatabase;
import Model.Contatto;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneGruppoPostgresDAO implements GruppoDAO {
    private Connection connection;
    private ResultSet rs;
    private Statement s;
    private DefaultListModel DLMGruppi = new DefaultListModel<>();


    public ImplementazioneGruppoPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGruppo (String nome) throws SQLException {
        s = connection.createStatement();
        //QUERY DI INSERIMENTO NOME GRUPPO
        s.executeUpdate("INSERT INTO GRUPPO " +
                "VALUES ('"+nome+"')");
    }

    public DefaultListModel setDLMGruppi() throws SQLException {
        DLMGruppi.removeAllElements();
        s = connection.createStatement();
        //QUERY DI RACCOGLIMENTO NOMI GRUPPI
        rs = s.executeQuery("SELECT * " +
                            "FROM GRUPPO");

        while(rs.next()){
            DLMGruppi.addElement(rs.getString("nome"));
        }
        rs.close();
        s.close();
        return DLMGruppi;
    }

    public DefaultListModel getGruppiSearch(String ricerca) throws SQLException {
        DLMGruppi.removeAllElements();
        s = connection.createStatement();

        //QUERY DI SELEZIONE DEI GRUPPI
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT * " +
                    "FROM GRUPPO ");
        }else{
            rs = s.executeQuery("SELECT * " +
                    "FROM GRUPPO " +
                    "WHERE NOME ILIKE '%"+ricerca+"%'");
        }
        while (rs.next()) {                                   //Finche non scorro tutto il resultSet
            DLMGruppi.addElement(rs.getString("NOME"));
        }
        rs.close();
        s.close();
        return DLMGruppi;
    }


}
