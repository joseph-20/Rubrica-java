package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InfoServizio {
    private JLabel lblFotoServizio;
    private JLabel lblEmailAssociateServizio;
    private JLabel lblStatoServizio;
    private JPanel panelMain;
    private JLabel lblStatoInfo;
    private JLabel lblEmailInfo;
    private JScrollPane emailAssociateScroll;
    private JScrollPane statoScroll;
    private JPanel panelEmailAssociateScroll;
    private JPanel panelStatoScroll;

    public InfoServizio() throws SQLException {
        Controller c = new Controller();
        esegui(c);
}

    private void esegui(Controller c) throws SQLException{
        //Creazione finestra principale
        JFrame frame = new JFrame("Servizio");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize (new Dimension(400, 300));
        frame.setVisible(true);

        //eliminazione bordi scroll
        statoScroll.setBorder(null);
        emailAssociateScroll.setBorder(null);
        //settaggio lbl
        lblEmailAssociateServizio.setText("<html>Email<br/><html>");
        lblEmailInfo.setText("<html>andpnace00@gmail.com<br/>hermino904@gmail.com<br/>andpnace@icloud.com<br/>htco@icloud.com<br/>tech2@gmail.com<br/><html>");
        lblStatoServizio.setText("Stato");
        lblFotoServizio.setIcon(c.SetImageSize(".images/Teams512x512.png",100,100));
    }

    public static void main(String[] args) throws SQLException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //System Look And Feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new InfoServizio();
    }


}
