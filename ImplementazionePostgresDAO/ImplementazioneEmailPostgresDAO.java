package ImplementazionePostgresDAO;

import DAO.EmailDAO;
import Database.ConnessioneDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ImplementazioneEmailPostgresDAO implements EmailDAO {
    private Connection connection;
    private String email;
    private ResultSet rs;
    private Statement s;
    private int cont;
    private int index;
    private ArrayList<String> username = new ArrayList<>();
    private ArrayList<String> dominio = new ArrayList<>();

    public ImplementazioneEmailPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmail(int pk) throws SQLException {
        cont = 0;
        email = "<html>";
        s = connection.createStatement();
        //QUERY DI SELEZIONE ATTRIBUTI DI EMAIL
        rs = s.executeQuery("SELECT * " +
                "FROM EMAIL " +
                "WHERE ID_CONTATTO = "+pk);
        while(rs.next()){                                      //Finche non scorro tutto il resultSet
            email = email+(rs.getString("username")+"@"+rs.getString("dominio")+"<br/>");
            cont++;
        }
        email = email+"<br/><html>";
        if(cont==0) return "NOT FOUND";
        return email;
    }

    public void creaEmail (ArrayList<String> mail, int id, int n) throws SQLException{
        s = connection.createStatement();
        username.clear();
        dominio.clear();
        //QUERY DI AGGIUNTA DI TUTTE LE MAIL
        for(int i=0;i<n;i++){
            index = mail.get(i).indexOf('@');
            username.add(mail.get(i).substring(0,index));
            dominio.add(mail.get(i).substring(index+1));
            s.executeUpdate("INSERT INTO EMAIL " +
                            "VALUES ('"+username.get(i)+"','"+dominio.get(i)+"',"+id+")");
        }
    }

}
