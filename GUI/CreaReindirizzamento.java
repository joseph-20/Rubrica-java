package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CreaReindirizzamento {
    private JPanel panelMain;
    private JPanel panelMobili;
    private JPanel panelFissi;
    private JLabel lblFotoReindirizzamento;
    private JComboBox comboBoxNumeriMobili;
    private JComboBox comboBoxNumeriFissi;
    private JLabel lblReindirizzamento;
    private JButton btnReindirizza;
    private JLabel lblFissi;
    private JLabel lblMobili;
    private ImageIcon img;

    public CreaReindirizzamento(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException{

        JFrame frame = new JFrame("Reindirizzamento");
        frame.setContentPane(this.panelMain);
        frame.setMinimumSize (new Dimension(430, 200));
        frame.setVisible(true);

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 430 / 2, center.y - 430 / 2, 430, 200);

        //Disattivazione resizability
        frame.setResizable(false);

        //Settaggio lblFotoReindirizzamento
        lblFotoReindirizzamento.setIcon(c.SetImageSize(".images/Reindirizzamento.png",60,60));

        //settaggio dlm
        comboBoxNumeriMobili.setModel(c.getDlmReindirizzamentiMobili());
        comboBoxNumeriFissi.setModel(c.getDlmReindirizzamentiFissi());

        //Interazioni click Reindirizza
        btnReindirizza.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.creaReindirizzamento(comboBoxNumeriMobili.getSelectedItem().toString(),comboBoxNumeriFissi.getSelectedItem().toString(),c.getLastId());
                    img = c.SetImageSize(".images/creazionecontatto.png",30,30);
                    JOptionPane.showMessageDialog(null,"Reindirizzamento aggiunto!","RIUSCITA!",1,img);
                    frame.dispose();
                } catch (SQLException ex) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"Questo reindirizzamento è stato già aggiunto!","ATTENZIONE!",1,img);
                    ex.printStackTrace();
                }
            }
        });
    }
}
