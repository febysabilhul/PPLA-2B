package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JFrame;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import view.MainMenu;
import view.Petunjuk;
import view.Tentang;
import view.load;
import model.m_player;
import model.m_aset;
import model.m_function;
/**
 *
 * @author BoniBarBar
 */
public class cMenu {

    private Tentang viewtentang;
    private Petunjuk viewpetunjuk;
    public MainMenu viewMenu;
    private load viewLoad;
    private m_player mPlayer;
    private m_aset mAset;
    AudioInputStream audio;
    Clip clip;
    private m_function mFunction;

    public cMenu() throws SQLException, InterruptedException {
        viewMenu = new MainMenu();
        viewtentang = new Tentang();
        viewLoad = new load();
        mPlayer = new m_player();
        mAset = new m_aset();
        music();
        viewMenu.getBtnMulai().addActionListener(new mulaiAction());
        viewMenu.getBtnAbout().addActionListener(new aboutAction());
        viewMenu.getBtnOk().addActionListener(new OkAction());
        viewtentang.getBtnKembali().addActionListener(new kembaliAction());
        viewMenu.getBtnBatal().addActionListener(new batalAction());
        viewMenu.klikvol(new acttombolvolume());
        viewMenu.setVisible(true);
        

    }

    public void music() {
        try {
            audio = AudioSystem.getAudioInputStream(new File("src//ost//ost.wav"));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
            Logger.getLogger(cMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class acttombolvolume implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (clip.isRunning()) {
                clip.stop();
                viewMenu.vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ost/MusicOff.png"))); // NOI18N
            } else {
                clip.start();
                viewMenu.vol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ost/MusicOn.png"))); // NOI18N
            }
        }
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
    private class batalAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
      viewMenu.getUsernameFrame().setVisible(false);
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

        }
    }

    private class keluarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(viewMenu, "Yakin Keluar Game..???", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
                    mAset.insertAset();

                    JOptionPane.showMessageDialog(viewMenu, "Username " + viewMenu.getFieldUsername().getText() + " berhasil dibuat");
                    new cbantuan(viewMenu.getFieldUsername().getText());
                    viewMenu.getUsernameFrame().dispose();
                    viewMenu.setVisible(false);
                }
            } catch (SQLException ex) {
                Logger.getLogger(cMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
