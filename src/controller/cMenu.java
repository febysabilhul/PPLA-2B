
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.MainMenu;
import view.Petunjuk;
import view.Tentang;
import view.load;
import model.m_player;
import model.m_aset;

/**
 *
 * @author BoniBarBar
 */
public class cMenu {

    private Tentang viewtentang;
    private Petunjuk viewpetunjuk;
    private MainMenu viewMenu;
    private load viewLoad;
    private m_player mPlayer;
     private m_aset mAset;

    public cMenu() throws SQLException, InterruptedException {
        viewMenu = new MainMenu();
        viewtentang = new Tentang();
        viewLoad = new load();
        mPlayer = new m_player();
        mAset = new m_aset();
        viewMenu.getBtnMulai().addActionListener(new mulaiAction());
          viewMenu.getBtnAbout().addActionListener(new aboutAction());
          viewMenu.getBtnPetunjuk().addActionListener(new aboutAction());
          viewMenu.getBtnOk().addActionListener(new OkAction());
          viewtentang.getBtnKembali().addActionListener(new kembaliAction());
          viewMenu.setVisible(true);
          

    }
    
    
       private class aboutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewtentang.setVisible(true);
            viewMenu.setVisible(false);
        }

    }
       private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewtentang.setVisible(false);
            viewMenu.setVisible(true);
        }
        
    }
       
       private class petunjukAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        viewpetunjuk.setVisible(true);
        viewMenu.setVisible(false);
        }
           
       }

    private class mulaiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             viewMenu.getUsernameFrame().setVisible(true);
//             viewMenu.setExtendedState(usernameFrame.MAXIMIZED_BOTH);
        }
    }
     private class keluarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(viewMenu, "Yakin Keluar Game..???",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }
      private class OkAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                if (viewMenu.getFieldUsername().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(viewMenu, "Username tidak boleh kosong");
                } else {
                    mPlayer.insertUsername(viewMenu.getFieldUsername().getText());
//                    mAset.insertAset();
                    
                    JOptionPane.showMessageDialog(viewMenu, "Username " + viewMenu.getFieldUsername().getText() + " berhasil dibuat");
                    new c_home(viewMenu.getFieldUsername().getText());
                    viewMenu.getUsernameFrame().dispose();
                    viewMenu.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(cMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
     
     
   
}
