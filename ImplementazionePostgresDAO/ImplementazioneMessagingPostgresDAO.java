package ImplementazionePostgresDAO;

import DAO.MessagingDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazioneMessagingPostgresDAO implements MessagingDAO {
    private Connection connection;
    private String numeriMobili;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private String servizio = null;
    private String username;
    private String email;
    private String stato;
    private String emailUsername;
    private String emailDominio;
    private int index;

    public ImplementazioneMessagingPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getServizio(String sistema,int pk) throws SQLException {
        s = connection.createStatement();
        cont=0;
        //QUERY DI SELEZIONE SERVIZIO PER ID CONTATTO
        rs = s.executeQuery("SELECT SERVIZIO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            servizio = rs.getString("SERVIZIO");
            cont++;
        }
        if(cont==0){
            return null;
        }
        return servizio;
    }

    public String getUsername (String sistema,int pk) throws SQLException{
        s= connection.createStatement();
        //QUERY DI OTTENIMENTO USERNAME
        rs = s.executeQuery("SELECT USERNAME " +
                            "FROM SISTEMA_DI_MESSAGING " +
                            "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            username = rs.getString("username");
        }
        return username;
    }

    public String getEmail (String sistema,int pk) throws SQLException{
        s= connection.createStatement();
        //QUERY DI OTTENIMENTO EMAIL
        rs = s.executeQuery("SELECT EMAIL_USERNAME,EMAIL_DOMINIO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            email = rs.getString("EMAIL_USERNAME")+"@"+rs.getString("EMAIL_DOMINIO");
        }
        return email;
    }

    public String getStato (String sistema,int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI OTTENIMENTO STATO
        rs = s.executeQuery("SELECT STATO " +
                "FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk+" AND SERVIZIO ILIKE '"+sistema+"'");
        while(rs.next()){
            stato = rs.getString("STATO");
        }
        return stato;
    }

    public void creaMessaging(String username,String servizio,String stato,String email,int pk) throws SQLException {
        s = connection.createStatement();
        //scomposizione email
        index = email.indexOf('@');
        emailUsername = email.substring(0,index);
        emailDominio = email.substring(index+1);
        //QUERY DI CREAZIONE MESSAGING
        s.executeUpdate("INSERT INTO SISTEMA_DI_MESSAGING " +
                        "VALUES ('"+username+"','"+servizio+"','"+stato+"','"+emailUsername+"','"+emailDominio+"',"+pk+")");
    }

    public void eliminaMessaging (int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI ELIMINAZIONE
        s.executeUpdate("DELETE FROM SISTEMA_DI_MESSAGING " +
                "WHERE ID_CONTATTO = "+pk);
        }
    }
