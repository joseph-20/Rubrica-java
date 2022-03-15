package ImplementazionePostgresDAO;

import DAO.PasswordDAO;
import Database.ConnessioneDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazionePasswordPostgresDAO implements PasswordDAO {
    private Connection connection;
    private ResultSet rs;
    private Statement s;
    private String password;
    private int cont=0;

    public ImplementazionePasswordPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPassword(String pw) throws SQLException{
        s = connection.createStatement();

        //QUERY DI ELIMINAZIONE PASSWORD PRECEDENTE
        s.executeUpdate("DELETE FROM AREA_PRIVATA");


        //QUERY DI INSERIMENTO PASSWORD
        s.executeUpdate("INSERT INTO AREA_PRIVATA " +
                        "VALUES('"+pw+"')");
    }

    public String getPassword () throws SQLException {
        cont=0;
        s = connection.createStatement();
        //QUERY DI OTTENIMENTO PASSWORD
        rs = s.executeQuery("SELECT PASSWORD " +
                        "FROM AREA_PRIVATA");

        while(rs.next()){
            password = rs.getString("PASSWORD");
            cont++;
        }
        if(cont==0){
            return null;
        }else{
            return password;
        }

    }

}
