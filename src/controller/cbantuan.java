/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author BoniBarBar
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.bantuan;
import view.home;
import view.helptoko;
import view.helpsawah;

public class cbantuan {

    private bantuan vBantuan;
    private helptoko vHelpToko;
    private helpsawah vHelpSawah;

    private String[] indexBantuan = new String[45];
    private String posisi;
    private String[] indexToko = new String[7];
    private int iBantuan;
    private int iToko;

    public cbantuan(String username) throws SQLException {

        vBantuan = new bantuan();
        vHelpSawah = new helpsawah();
        vHelpToko = new helptoko();

        indexToko[0]= "/gambar/bantuan1/toko/13.png";
        indexToko[1]= "/gambar/bantuan1/toko/13.2.png";
        indexToko[2]= "/gambar/bantuan1/toko/13.3.png";
        indexToko[3]= "/gambar/bantuan1/toko/13.4.png";
        indexToko[4]= "/gambar/bantuan1/toko/13.5.png";
        indexToko[5]= "/gambar/bantuan1/toko/13.6.png";
        indexToko[6]= "/gambar/bantuan1/toko/13.7.png";
        
        indexBantuan[0] = "/gambar/bantuan1/1.png";
        indexBantuan[1] = "/gambar/bantuan1/2.png";
        indexBantuan[2] = "/gambar/bantuan1/2.2.png";
        indexBantuan[3] = "/gambar/bantuan1/2.3.png";
        indexBantuan[4] = "/gambar/bantuan1/2.4.png";
        indexBantuan[5] = "/gambar/bantuan1/2.6.png";

        indexBantuan[6] = "/gambar/bantuan1/3.png";

        indexBantuan[7] = "/gambar/bantuan1/4.png";
        indexBantuan[8] = "/gambar/bantuan1/4.2.png";

        indexBantuan[9] = "/gambar/bantuan1/5.png";
        indexBantuan[10] = "/gambar/bantuan1/5.2.png";

        indexBantuan[11] = "/gambar/bantuan1/6.png";
        indexBantuan[12] = "/gambar/bantuan1/6.2.png";
        indexBantuan[13] = "/gambar/bantuan1/6.4.png";
        indexBantuan[14] = "/gambar/bantuan1/6.5.png";

        indexBantuan[15] = "/gambar/bantuan1/7.png";
        indexBantuan[16] = "/gambar/bantuan1/7.2.png";
        indexBantuan[17] = "/gambar/bantuan1/7.3.png";
        indexBantuan[18] = "/gambar/bantuan1/7.4.png";

        indexBantuan[19] = "/gambar/bantuan1/8.png";
        indexBantuan[20] = "/gambar/bantuan1/8.2.png";
        indexBantuan[21] = "/gambar/bantuan1/8.3.png";
        indexBantuan[22] = "/gambar/bantuan1/8.4.png";
        indexBantuan[23] = "/gambar/bantuan1/8.5.png";
        indexBantuan[24] = "/gambar/bantuan1/8.6.png";
        indexBantuan[25] = "/gambar/bantuan1/8.7.png";
        indexBantuan[26] = "/gambar/bantuan1/8.8.png";
        indexBantuan[27] = "/gambar/bantuan1/8.9.png";

        indexBantuan[28] = "/gambar/bantuan1/9.png";
        indexBantuan[29] = "/gambar/bantuan1/9.1.png";
        indexBantuan[30] = "/gambar/bantuan1/9.2.png";
        indexBantuan[31] = "/gambar/bantuan1/9.3.png";

        indexBantuan[32] = "/gambar/bantuan1/10.png";
        indexBantuan[33] = "/gambar/bantuan1/10.2.png";
        indexBantuan[34] = "/gambar/bantuan1/10.3.png";
        indexBantuan[35] = "/gambar/bantuan1/10.4.png";
        indexBantuan[36] = "/gambar/bantuan1/10.5.png";
        indexBantuan[37] = "/gambar/bantuan1/10.6.png";

        indexBantuan[38] = "/gambar/bantuan1/11.png";
        indexBantuan[39] = "/gambar/bantuan1/11.2.png";
        indexBantuan[40] = "/gambar/bantuan1/11.3.png";
        indexBantuan[41] = "/gambar/bantuan1/11.4.png";
        indexBantuan[42] = "/gambar/bantuan1/11.5.png";

        indexBantuan[43] = "/gambar/bantuan1/12.png";

        indexBantuan[44] = "/gambar/bantuan1/15.4.png";
        vBantuan.setVisible(true);
        
        vBantuan.getBtnSawah().addActionListener(new sawahAction());
        vBantuan.getBtnToko().addActionListener(new tokoAction());
        
        vHelpSawah.getBtnLanjut().addActionListener(new LanjutAction());
        
        vHelpSawah.getBtnKembali().addActionListener(new KembaliAction());
vHelpToko.getBtnLanjut().addActionListener(new LanjutAction());

    }
    
    private class KembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (posisi == "sawah") {
                if (iBantuan == indexBantuan.length - 1) {
                    iBantuan = 0;
                } else {
                    iBantuan -= 1;
                }
                vHelpSawah.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexBantuan[iBantuan])));
            }
            else  if (posisi == "toko") {
                if (iToko == indexToko.length - 1) {
                    iToko = 0;
                } else {
                    iToko -= 1;
                }
                vHelpToko.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexToko[iToko])));
            }

        }
    }

    private class LanjutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (posisi == "sawah") {
                if (iBantuan == indexBantuan.length - 1) {
                    iBantuan = 0;
                } else {
                    iBantuan += 1;
                }
                vHelpSawah.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexBantuan[iBantuan])));
            }
            else  if (posisi == "toko") {
                if (iToko == indexToko.length - 1) {
                    iToko = 0;
                } else {
                    iToko += 1;
                }
                vHelpToko.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexToko[iToko])));
            }

        }
    }

    
    private class tokoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            iToko = 0;
            posisi = "toko";
            vHelpToko.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexToko[iToko])));
            vHelpToko.setVisible(true);
            vBantuan.setVisible(false);
        }

    }
    private class sawahAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            iBantuan = 0;
            posisi = "sawah";
            vHelpSawah.getLblGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource(indexBantuan[iBantuan])));
            vHelpSawah.setVisible(true);
            vBantuan.setVisible(false);
        }

    }
 private class disposeAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vBantuan.dispose();
        }

    }
}
