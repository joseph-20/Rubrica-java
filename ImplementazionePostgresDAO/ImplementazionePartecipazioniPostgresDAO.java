package ImplementazionePostgresDAO;

import DAO.PartecipazioniDAO;
import Database.ConnessioneDatabase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazionePartecipazioniPostgresDAO implements PartecipazioniDAO {

    private Connection connection;
    private ResultSet rs;
    private Statement s;
    private ImageIcon img;
    private String partecipanti;
    private int index;
    private DefaultListModel DLMGruppi = new DefaultListModel();


    public ImplementazionePartecipazioniPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPartecipazioni (ArrayList pk,String gruppo) throws SQLException {
        s = connection.createStatement();
        //QUERY DI INSERIMENTO NOME GRUPPO
        for (int i = 0; i < pk.size(); i++) {
            s.executeUpdate("INSERT INTO PARTECIPAZIONE " +
                    "VALUES (" + pk.get(i) + ",'"+gruppo+"')");
        }
        s.close();
    }

    public void setIdToLast (int precId,int lastId) throws SQLException {
        s = connection.createStatement();

        //QUERY DI AGGIORNAMENTO
        s.executeUpdate("UPDATE PARTECIPAZIONE " +
                "SET ID_CONTATTO = "+lastId+" " +
                "WHERE ID_CONTATTO = "+precId);
        s.close();
    }

    public String getPartecipanti (String gruppo) throws SQLException {
        partecipanti = "<html>";
        s = connection.createStatement();

        //QUERY DI AGGIORNAMENTO
        rs = s.executeQuery("SELECT C.NOME,C.COGNOME " +
                "FROM PARTECIPAZIONE AS P,CONTATTO AS C WHERE NOME_GRUPPO = '"+gruppo+"' AND ID_CONTATTO = ID");
        while(rs.next()){
            partecipanti = partecipanti+rs.getString("NOME")+" "+rs.getString("COGNOME")+"<br/>";
        }
        partecipanti = partecipanti+"<html>";
        rs.close();
        s.close();
        return partecipanti;
    }

    public void eliminaGruppo (String gruppo) throws SQLException{
        s = connection.createStatement();

        //QUERY DI ELIMINAZIONE DEI PARTECIPANTI AL GRUPPO
        s.executeUpdate("DELETE FROM PARTECIPAZIONE WHERE NOME_GRUPPO = '"+gruppo+"'");
        s.close();
    }

    public DefaultListModel getGruppiSearchContatto(String ricerca) throws SQLException {
        DLMGruppi.removeAllElements();
        s = connection.createStatement();

        //Settaggio index
        index=0;
        index = ricerca.indexOf(' ');

        //QUERY DI SELEZIONE DEI GRUPPI
        if(ricerca.equals("")){
            rs = s.executeQuery("SELECT * " +
                    "FROM GRUPPO ");
        }else if(index!=-1) {
            rs = s.executeQuery("SELECT * " +
                    "FROM PARTECIPAZIONE,CONTATTO " +
                    "WHERE ID_CONTATTO=ID AND (NOME ILIKE '%"+ricerca.substring(0,index)+"%' AND COGNOME ILIKE '%"+ricerca.substring(index+1)+"%')"+
                    " ORDER BY NOME,COGNOME");
        }else{
            rs = s.executeQuery("SELECT * " +
                    "FROM PARTECIPAZIONE,CONTATTO " +
                    "WHERE ID_CONTATTO=ID AND (NOME ILIKE '%" + ricerca + "%' OR COGNOME ILIKE '%" + ricerca  + "%')" +
                    " ORDER BY NOME,COGNOME");
        }
        while (rs.next()) {                                   //Finche non scorro tutto il resultSet
            DLMGruppi.addElement(rs.getString("NOME_GRUPPO"));
        }
        rs.close();
        s.close();
        return DLMGruppi;
    }
}
