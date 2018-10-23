/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.m_aset;
import view.home;
import view.toko;

public class c_home {

    private home vHome;
    private m_aset mAset;
    private toko vtoko;
    private JButton petak[] = new JButton[6];
    private JLabel air[] = new JLabel[6];
    private JLabel gulma[] = new JLabel[6];
    private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
    private boolean statusSiram[] = {false, false, false, false, false, false};
    private int bibit;
    private int kopi;
    private int pupuk;
    private int obat;
    private int koin;
    private String username;
    private int detikSiram = 0;
    private boolean detikSiram1 = false;
    private Random random = new Random();
    private int statusair;
    private Thread t;

    public c_home(String username) throws SQLException {
        vHome = new home();
        mAset = new m_aset();
        this.username = username;
        vHome.getBtntoko().addActionListener(new tokoAction());
        vHome.getBtnCangkul().addActionListener(new CangkulAction());
        vHome.getLblusername().setText(username);
        vHome.setVisible(true);

        petak[0] = vHome.getBtnPetak1();
        petak[1] = vHome.getBtnPetak2();
        petak[2] = vHome.getBtnPetak3();
        petak[3] = vHome.getBtnPetak4();
        petak[4] = vHome.getBtnPetak5();
        petak[5] = vHome.getBtnPetak6();
        air[0] = vHome.getLblAir();
        air[1] = vHome.getLblAir1();
        air[2] = vHome.getLblAir2();
        air[3] = vHome.getLblAir3();
        air[4] = vHome.getLblAir4();
        air[5] = vHome.getLblAir5();
        gulma[0] = vHome.getLblGulma();
        gulma[1] = vHome.getLblGulma1();
        gulma[2] = vHome.getLblGulma2();
        gulma[3] = vHome.getLblGulma3();
        gulma[4] = vHome.getLblGulma4();
        gulma[5] = vHome.getLblGulma5();
        for (int i = 0; i < air.length; i++) {
            air[i].setVisible(false);
            gulma[i].setVisible(false);

        }
        for (int i = 0; i < gulma.length; i++) {
            gulma[i].setVisible(false);

        }
        bibit = mAset.getBibit(mAset.cekIdPlayer(username));
        pupuk = mAset.getPupuk(mAset.cekIdPlayer(username));
        obat = mAset.getObat(mAset.cekIdPlayer(username));

        vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
        vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
        vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
        vHome.getBtnAir().addActionListener(new airAction());

        vHome.getBtnPetak1().addActionListener(new kotak1Action());
        vHome.getBtnPetak2().addActionListener(new kotak2Action());
        vHome.getBtnPetak3().addActionListener(new kotak3Action());
        vHome.getBtnPetak4().addActionListener(new kotak4Action());
        vHome.getBtnPetak5().addActionListener(new kotak5Action());
        vHome.getBtnPetak6().addActionListener(new kotak6Action());
        vHome.getBtnAir().setEnabled(false);
        vHome.getBtnCangkul().setEnabled(false);
        t = new time();
        t.start();
    }

    private class CangkulAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 2) {

                    detikSiram1 = true;
                    statusSiram[i] = true;
                    gulma[i].setVisible(true);
                  
                 gulma[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));
                  
                    vHome.getBtnCangkul().setEnabled(false);
                }

            }
        }

    }

    private class tokoAction implements ActionListener {

        private c_toko toko;

        public tokoAction() throws SQLException {
            toko = new c_toko(vHome, username);
            toko.getView().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                toko.getView().getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");

            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            toko.getView().setVisible(true);
            vHome.setVisible(false);
        }
    }

  

    private class airAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int tes = 0;
            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 2) {

                    detikSiram1 = true;
                    statusSiram[i] = true;
                    air[i].setVisible(true);
//                    System.out.println("Coba");
                    air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));
                    //set gif menyiram
                    //set label butuh air false
                    vHome.getBtnAir().setEnabled(false);
                }
            }
        }
    }

    private class kotak1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[0] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[0] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 2) + 1) + 2;
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[1] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[1] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[1] == 3) {//tumbuh 
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[1] = 1;
                statusSiram[1] = false;
                statusTime1[1] = 0;
                statusTime2[1] = 0;
                statusTime3[1] = 0;
            } else if (statusKotak[1] == 4) {//siap panen
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[1] = 1;
                statusSiram[1] = false;
                statusTime1[1] = 0;
                statusTime2[1] = 0;
                statusTime3[1] = 0;
            }
        }
    }

    private class kotak3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[2] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[2] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[2] == 3) {//tumbuh 
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[2] = 1;
                statusSiram[2] = false;
                statusTime1[2] = 0;
                statusTime2[2] = 0;
                statusTime3[2] = 0;
            } else if (statusKotak[2] == 4) {//siap panen
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[2] = 1;
                statusSiram[2] = false;
                statusTime1[2] = 0;
                statusTime2[2] = 0;
                statusTime3[2] = 0;
            }
        }
    }

    private class kotak4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[3] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[3] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[3] == 3) {//tumbuh 
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[3] = 1;
                statusSiram[3] = false;
                statusTime1[3] = 0;
                statusTime2[3] = 0;
                statusTime3[3] = 0;
            } else if (statusKotak[3] == 4) {//siap panen
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[3] = 1;
                statusSiram[3] = false;
                statusTime1[3] = 0;
                statusTime2[3] = 0;
                statusTime3[3] = 0;
            }
        }
    }

    private class kotak5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[4] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[4] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[4] == 3) {//tumbuh 
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[4] = 1;
                statusSiram[4] = false;
                statusTime1[4] = 0;
                statusTime2[4] = 0;
                statusTime3[4] = 0;
            } else if (statusKotak[4] == 4) {//siap panen
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[4] = 1;
                statusSiram[4] = false;
                statusTime1[4] = 0;
                statusTime2[4] = 0;
                statusTime3[4] = 0;
            }
        }
    }

    private class kotak6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[5] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    statusKotak[5] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
            } else if (statusKotak[5] == 3) {//tumbuh 
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[5] = 1;
                statusSiram[5] = false;
                statusTime1[5] = 0;
                statusTime2[5] = 0;
                statusTime3[5] = 0;
            } else if (statusKotak[5] == 4) {//siap panen
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                koin += 150;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[5] = 1;
                statusSiram[5] = false;
                statusTime1[5] = 0;
                statusTime2[5] = 0;
                statusTime3[5] = 0;
            }
        }
    }

    private class time extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    bibit = mAset.getBibit(mAset.cekIdPlayer(username));
                    koin = mAset.getKoin(mAset.cekIdPlayer(username));
                    for (int i = 0; i < statusKotak.length; i++) {
                        if (statusKotak[i] == 2) {

                            statusTime1[i] += 1;

                            if (statusTime1[i] == 5) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                vHome.getBtnAir().setEnabled(true);
                                statusair += 1;
                            }
                            if (statusTime1[i] == 10) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                vHome.getBtnAir().setEnabled(true);
                                statusair += 1;
                            }
                            if (statusTime1[i] == 15) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                vHome.getBtnAir().setEnabled(true);
                                statusair += 1;
                            }
                            if (statusTime1[i] == 20) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                vHome.getBtnAir().setEnabled(true);
                                statusair += 1;
                            }
                            if (statusTime1[i] == 25) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                vHome.getBtnAir().setEnabled(true);
                                statusair += 1;
                                
                            }

                        }

                        if (statusSiram[i]) {
//                            if (statusair==3) {
                            statusTime2[i] += 1;
                            if (statusTime2[i] == 25) {
                                statusTime2[i] += 1;
                                statusKotak[i] = 3;
                                air[i].setVisible(false);
                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Tanaman Setengah Gedi.png")));
                                petak[i].setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Tanaman Setengah Gedi Highlight.png")));
                            }
                            if (statusTime2[i] == 30) {
                                gulma[i].setVisible(true);
                                vHome.getBtnCangkul().setEnabled(true);
                                gulma[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gulma.png")));
                            }

                        }
                        if (statusKotak[i] == 3) {
                            statusTime3[i] += 1;
                            if (statusTime3[i] == 40) {
                                gulma[i].setVisible(false);
                                statusKotak[i] = 4;
                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Kakao Gedi.png")));
                                petak[i].setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Kakao Gedi Highlight.png")));
                            }
                        }
                    }
//                    System.out.println("");
//                    System.out.println("air =" + statusSiram[0]);
//                    System.out.println("air2 =" + statusSiram[1]);
//                    System.out.println("");
//                    System.out.println("jagung= " + jagung);
//                    System.out.println("");
//                    System.out.println("kotak 1= " + statusKotak[0]);
//                    System.out.println("kotak 2= " + statusKotak[1]);
//                    System.out.println("kotak 3= " + statusKotak[2]);
//                    System.out.println("kotak 4= " + statusKotak[3]);
//                    System.out.println("kotak 5= " + statusKotak[4]);
//                    System.out.println("kotak 6= " + statusKotak[5]);
                } catch (InterruptedException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
