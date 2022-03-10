package ImplementazionePostgresDAO;

import DAO.ReindirizzamentoDAO;
import Database.ConnessioneDatabase;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplementazioneReindirizzamentoPostgresDAO implements ReindirizzamentoDAO {
    private Connection connection;
    private ResultSet rs;
    private Statement s;
    private String reindirizzamento = "<html>";
    private int cont=0;
    File f = new File("C:\\Users\\39366\\IdeaProjects\\Rubrica-java\\.images\\Reindirizzamento.png");

    public ImplementazioneReindirizzamentoPostgresDAO(){
        try {
            connection = ConnessioneDatabase.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void creaReindirizzamento (String numero_mobile,String numero_fisso,int pk) throws SQLException {
        s = connection.createStatement();
        //QUERY DI CREAZIONE REINDIRIZZAMENTO
        s.executeUpdate("INSERT INTO REINDIRIZZAMENTO " +
                "VALUES ('"+numero_fisso.substring(0,3)+"','"+numero_fisso.substring(3)+"',"+pk+",'"+numero_mobile.substring(0,3)+"','"+numero_mobile.substring(3)+"')");
    }
    public void eliminaReindirizzamento (int pk) throws SQLException{
        s = connection.createStatement();
        //QUERY DI ELIMINAZIONE
        s.executeUpdate("DELETE FROM REINDIRIZZAMENTO " +
                "WHERE ID_CONTATTO_FISSO = "+pk);
    }

    public String getReindirizzamenti(int pk) throws SQLException{
        reindirizzamento="<html>";
        cont = 0;
        s = connection.createStatement();
        //QUERY DI SELEZIONE REINDIRIZZAMENTI
        rs = s.executeQuery("SELECT * " +
                            "FROM REINDIRIZZAMENTO " +
                            "WHERE ID_CONTATTO_FISSO = "+pk);
        while(rs.next()){
            reindirizzamento = reindirizzamento+rs.getString("prefisso_fisso")+" "+rs.getString("numero_fisso")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\""
                    + ImplementazioneReindirizzamentoPostgresDAO.class.getResource("/.images/Reindirizzamento20x20.png")
                    + "\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("prefisso_mobile")+" "+rs.getString("numero_mobile")+"<br/>";
            cont++;
        }
        if(cont == 0) return null;
        else return reindirizzamento+"<html>";
    }
}
