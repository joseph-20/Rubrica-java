package DAO;

import java.sql.SQLException;

public interface ReindirizzamentoDAO {

    public void creaReindirizzamento (String numero_mobile,String numero_fisso,int pk) throws SQLException;
    public void eliminaReindirizzamento (int pk) throws SQLException;
    public String getReindirizzamenti(int pk) throws SQLException;
    public void setIdToLast (int precId,int lastId) throws SQLException;
}
