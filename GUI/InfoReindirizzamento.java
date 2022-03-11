package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InfoReindirizzamento {
    private JPanel panelMain;
    private JScrollPane listaReindirizzamentiScroll;
    private JPanel panelReindirizzamentiScroll;
    private JLabel lblInfoReindirizzamenti;
    private JLabel lblFissi;
    private JLabel lblMobili;
    private ImageIcon img;

    public InfoReindirizzamento(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException {
        //Creazione finestra principale
        JFrame frame = new JFrame("Reindirizzamenti");
        frame.setContentPane(this.panelMain);
        frame.setMinimumSize(new Dimension(300, 150));
        frame.setVisible(true);

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 300 / 2, center.y - 150 / 2, 300, 150);

        //settaggio icona frame
        img = c.SetImageSize(".images/info.png",512,512);
        frame.setIconImage(img.getImage());

        //Disattivazione resizability
        frame.setResizable(false);

        //Settaggio bordi
        listaReindirizzamentiScroll.setBorder(null);

        lblInfoReindirizzamenti.setText(c.getReindirizzamenti());
    }
}
