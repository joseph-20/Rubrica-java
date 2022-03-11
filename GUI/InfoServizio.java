package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InfoServizio {
    private JLabel lblFotoServizio;
    private JPanel panelMain;
    private JLabel lblUsernameInfo;
    private JPanel panelStatoBorder;
    private JScrollPane statoInfoScroll;
    private JPanel panelStatoInfo;
    private JLabel lblStatoInfo;
    private JLabel lblEmailInfo;
    private ImageIcon img;

    public InfoServizio(Controller c) throws SQLException {
        esegui(c);
}

    private void esegui(Controller c) throws SQLException{

        //Creazione finestra principale
        JFrame frame = new JFrame("Servizio");
        frame.setContentPane(this.panelMain);
        frame.setMinimumSize (new Dimension(300, 200));
        frame.setVisible(true);

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 300 / 2, center.y - 200 / 2, 300, 200);

        //settaggio icona frame
        img = c.SetImageSize(".images/info.png",512,512);
        frame.setIconImage(img.getImage());

        //Disattivazione resizability
        frame.setResizable(false);

        //settaggio border
        statoInfoScroll.setBorder(null);

        //settaggio lbl
        lblFotoServizio.setIcon(c.getImg());
        lblEmailInfo.setText(c.getEmail());
        lblUsernameInfo.setText(c.getUsername());
        lblStatoInfo.setText(c.getStato());
    }
}
