package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InfoReindirizzamento {
    private JPanel panelMain;
    private JLabel lblReindirizzamenti;
    private JScrollPane listaReindirizzamentiScroll;
    private JPanel panelReindirizzamentiScroll;
    private JLabel lblInfoReindirizzamenti;

    public InfoReindirizzamento(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException {
        //Creazione finestra principale
        JFrame frame = new JFrame("Reindirizzamento");
        frame.setContentPane(this.panelMain);
        frame.setMinimumSize(new Dimension(300, 150));
        frame.setVisible(true);

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 300 / 2, center.y - 150 / 2, 300, 150);

        //Disattivazione resizability
        frame.setResizable(false);

        //Settaggio bordi
        listaReindirizzamentiScroll.setBorder(null);

        lblInfoReindirizzamenti.setText(c.getReindirizzamenti());
    }
}
