package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CreaServizio {

    private JPanel panelMain;
    private JScrollPane selectEmailScroll;
    private JPanel selectEmailPanel;
    private JList selectEmailList;
    private JPanel panelServizio;
    private JLabel lblFoto;
    private JComboBox comboBoxEmail;
    private JPanel panelBottomSelect;
    private JButton btnSeleziona;
    private JLabel lblUsername;
    private JTextField textFieldUsername;
    private JLabel lblStato;
    private JTextField textFieldStato;
    private ImageIcon img;

    public CreaServizio(Controller c) throws SQLException {
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

            //settaggio foto
            lblFoto.setIcon(c.getImg());
            comboBoxEmail.setModel(c.getDlmServizi());

            //Interazione con btnSeleziona
            btnSeleziona.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    try {
                        c.creaMessaging(textFieldUsername.getText(),c.getServizioMessaging(),textFieldStato.getText(),comboBoxEmail.getSelectedItem().toString(),c.getLastId());
                        img = c.SetImageSize(".images/creazionecontatto.png",30,30);
                        JOptionPane.showMessageDialog(null,"Servizio aggiunto!","RIUSCITA!",1,img);
                        frame.dispose();
                    } catch (SQLException ex) {
                        img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Il contatto è gia collegato al servizio!","ATTENZIONE!",1,img);
                        ex.printStackTrace();
                    }
                }
            });
        }
}