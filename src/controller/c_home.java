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
import java.util.Timer;

public class c_home {

    int siram = 0;
    private home vHome;
    private m_aset mAset;
    Timer timer = new Timer();
    private toko vtoko;
    private JButton petak[] = new JButton[6];
    private static int cnt;
    private JLabel air[] = new JLabel[6];
    private JLabel gulma[] = new JLabel[6];
    private JLabel tunas[] = new JLabel[6];
    private JButton card = new JButton();
    private JButton[] buttons = new JButton[6];

    private JButton[] obatbtn = new JButton[6];

    private int statusAir[] = {0, 0, 0, 0, 0, 0};
    private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
    private int statusTime4[] = {0, 0, 0, 0, 0, 0};
    private boolean statusSiram[] = {false, false, false, false, false, false};

    private int bibit;
    private int kopi;
    private int pupuk;
    private int obat;
    private int koin;
    private int datasiram;
    private int datapupuk1;
    private int datapupuk2;
    private int datapupuk3;
    private int datapupuk4;
    private int datapupuk5;
    private int datapupuk6;
    private int waktusiram;
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
        vHome.getBtnGunting().addActionListener(new GuntingAction());

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
        air[3] = vHome.getLblAir5();
        air[4] = vHome.getLblAir4();
        air[5] = vHome.getLblAir3();
        gulma[0] = vHome.getLblGulma();
        gulma[1] = vHome.getLblGulma1();
        gulma[2] = vHome.getLblGulma2();
        gulma[3] = vHome.getLblGulma3();
        gulma[4] = vHome.getLblGulma4();
        gulma[5] = vHome.getLblGulma5();

        buttons[0] = vHome.getBtnJbutton1();
        buttons[1] = vHome.getBtnJbutton2();
        buttons[2] = vHome.getBtnJbutton3();
        buttons[3] = vHome.getBtnJbutton4();
        buttons[4] = vHome.getBtnJbutton5();
        buttons[5] = vHome.getBtnJbutton6();

        obatbtn[0] = vHome.getBtnObt1();
        obatbtn[1] = vHome.getBtnObt2();
        obatbtn[2] = vHome.getBtnObt3();
        obatbtn[3] = vHome.getBtnObt4();
        obatbtn[4] = vHome.getBtnObt5();
        obatbtn[5] = vHome.getBtnObt6();

        tunas[0] = vHome.getLblTunas();
        tunas[1] = vHome.getLblTunas1();
        tunas[2] = vHome.getLblTunas2();
        tunas[3] = vHome.getLblTunas3();
        tunas[4] = vHome.getLblTunas4();
        tunas[5] = vHome.getLblTunas5();

        for (int i = 0; i < air.length; i++) {
            air[i].setVisible(false);
        }
        for (int i = 0; i < gulma.length; i++) {
            gulma[i].setVisible(false);

        }
        for (int i = 0; i < gulma.length; i++) {
            tunas[i].setVisible(false);

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

        vHome.getBtnJbutton1().addActionListener(new Jbutton1Action());
        vHome.getBtnJbutton2().addActionListener(new Jbutton2Action());
        vHome.getBtnJbutton3().addActionListener(new Jbutton3Action());
        vHome.getBtnJbutton4().addActionListener(new Jbutton4Action());
        vHome.getBtnJbutton5().addActionListener(new Jbutton5Action());
        vHome.getBtnJbutton6().addActionListener(new Jbutton6Action());

        vHome.getBtnObt1().addActionListener(new BtnObt1Action());
        vHome.getBtnObt2().addActionListener(new BtnObt2Action());
        vHome.getBtnObt3().addActionListener(new BtnObt3Action());
        vHome.getBtnObt4().addActionListener(new BtnObt4Action());
        vHome.getBtnObt5().addActionListener(new BtnObt5Action());
        vHome.getBtnObt6().addActionListener(new BtnObt6Action());

        vHome.getBtnCangkul().setEnabled(false);
        vHome.getBtnGunting().setEnabled(false);

        t = new time();
        t.start();
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

    private class BtnObt1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[0].setVisible(true);
            obatbtn[0].setVisible(false);

            air[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class BtnObt2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[1].setVisible(true);
            obatbtn[1].setVisible(false);

            air[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class BtnObt3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[2].setVisible(true);
            obatbtn[2].setVisible(false);

            air[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class BtnObt4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[3].setVisible(true);
            obatbtn[3].setVisible(false);

            air[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class BtnObt5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[4].setVisible(true);
            obatbtn[4].setVisible(false);

            air[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class BtnObt6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            air[5].setVisible(true);
            obatbtn[5].setVisible(false);

            air[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Nyemprot.png")));

            if (obat > 0) {
                obat -= 1;
                try {
                    mAset.updateObat(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya obat");
            }
        }
    }

    private class Jbutton1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk1++;

            air[0].setVisible(true);
            buttons[0].setVisible(false);

            air[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class Jbutton2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk2++;
            air[1].setVisible(true);
            buttons[1].setVisible(false);

            air[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class Jbutton3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk3++;
            air[2].setVisible(true);
            buttons[2].setVisible(false);

            air[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class Jbutton6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk6++;
            air[5].setVisible(true);
            buttons[5].setVisible(false);

            air[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class Jbutton4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk4++;
            air[3].setVisible(true);
            buttons[3].setVisible(false);

            air[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class Jbutton5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            datapupuk5++;
            air[4].setVisible(true);
            buttons[4].setVisible(false);

            air[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Mupuk.png")));

            if (pupuk > 0) {
                pupuk -= 1;
                try {
                    mAset.updatePupuk(pupuk, mAset.cekIdPlayer(username));
                    vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(vHome, "Tidak punya pupuk");
            }
        }
    }

    private class GuntingAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 3) {

                    detikSiram1 = true;
                    statusSiram[i] = true;
                    tunas[i].setVisible(false);
                    air[i].setVisible(true);

                    air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Nggunting.png")));

                    vHome.getBtnCangkul().setEnabled(false);
                }

            }
        }

    }

    private class CangkulAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < statusKotak.length; i++) {
                if (statusKotak[i] == 3) {

                    detikSiram1 = true;
                    statusSiram[i] = true;
                    air[i].setVisible(true);
                    gulma[i].setVisible(false);

                    air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Nyangkul.png")));

                    vHome.getBtnCangkul().setEnabled(false);
                }

            }
        }

    }

    private class airAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

//            datapupuk += 1;
            siram++;

            int tes = 0;

            for (int i = 0; i < statusKotak.length; i++) {
                switch (i) {
                    case 1:
                        if (statusKotak[0] == 2) {
                            statusAir[0] += 1;

                            if (siram % 2 == 0) {
                                air[0].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[0] = true;
                                air[0].setVisible(true);

//                    System.out.println("Coba");
                                air[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }

                        }
                        break;
                    case 2:
                        if (statusKotak[1] == 2) {
                            statusAir[1] += 1;

                            if (siram % 2 == 0) {
                                air[1].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[1] = true;
                                air[1].setVisible(true);

//                    System.out.println("Coba");
                                air[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }

                        }
                        break;
                    case 3:
                        if (statusKotak[2] == 2) {
                            statusAir[2] += 1;

                            if (siram % 2 == 0) {
                                air[2].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[2] = true;
                                air[2].setVisible(true);

//                    System.out.println("Coba");
                                air[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }

                        }
                        break;
                    case 4:
                        if (statusKotak[3] == 2) {
                            statusAir[3] += 1;

                            if (siram % 2 == 0) {
                                air[3].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[3] = true;
                                air[3].setVisible(true);

//                    System.out.println("Coba");
                                air[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }

                        }
                        break;
                    case 5:
                        if (statusKotak[4] == 2) {
                            statusAir[4] += 1;

                            if (siram % 2 == 0) {
                                air[4].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[4] = true;
                                air[4].setVisible(true);

//                    System.out.println("Coba");
                                air[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }

                        }
                        break;
                    case 6:
                        if (statusKotak[5] == 2) {
                            statusAir[5] += 1;

                            if (siram % 2 == 0) {
                                air[5].setVisible(false);
                            } else {
                                detikSiram1 = true;
                                statusSiram[5] = true;
                                air[5].setVisible(true);

//                    System.out.println("Coba");
                                air[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Siram.png")));

                            }
                        }

                }
            }
        }
    }

    private class kotak1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[0] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[0] = 2;
                    bibit -= 1;
                    statusAir[0] = 0;
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
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += 75;
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
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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
                    vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[1] = 2;
                    bibit -= 1;
                    statusAir[1] = 0;
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
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
                koin += 75;
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
            } else if (statusKotak[1] == 4) {//siap panen
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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
                    vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[2] = 2;
                    bibit -= 1;
                    statusAir[2] = 0;
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
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
                koin += 75;
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
            } else if (statusKotak[2] == 4) {//siap panen
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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
                    vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[3] = 2;
                    bibit -= 1;
                    statusAir[3] = 0;
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
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += random.nextInt((3 - 2) + 1) + 2;
                koin += 75;
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
            } else if (statusKotak[3] == 4) {//siap panen
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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
                    vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[4] = 2;
                    bibit -= 1;
                    statusAir[4] = 0;
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
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += random.nextInt((3 - 1) + 1) + 1;
                koin += 75;
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
            } else if (statusKotak[4] == 4) {//siap panen
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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
                    vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/CilikBaru.png")));
                    statusKotak[5] = 2;
                    bibit -= 1;
                    statusAir[5] = 0;
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
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/SetengahGediBaru.png")));
                koin += 75;
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
            } else if (statusKotak[5] == 4) {//siap panen
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));
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

                            if (statusTime1[i] == 90) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));

                                statusair += 1;
                            }
                            if (statusTime1[i] == 180) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                statusair += 1;
                            }

                            if (statusTime1[i] == 240) {
                                buttons[i].setVisible(true);
                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                                statusair += 1;
                            }

                            if (statusTime1[i] == 245) {
                                buttons[i].setVisible(false);

                            }

                            if (statusTime1[i] == 270) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                statusair += 1;
                            }

                            if (statusTime1[i] == 360) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                statusair += 1;
                            }

                            if (statusTime1[i] == 450) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                statusair += 1;

                            }

                            if (statusTime1[i] == 540) {
                                air[i].setVisible(true);
                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                                statusair += 1;

                            }

                            if (statusTime1[i] == 600) {
                                buttons[i].setVisible(true);
                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                                statusair += 1;

                            }
                            if (statusTime1[i] == 605) {
                                buttons[i].setVisible(false);

                            }
                            if (statusTime1[i] == 615) {
                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Tanaman Setengah Gedi.png")));

                            }

                            if (statusTime1[i] == 620) {
                                if (statusAir[0] % 2 >= 8 && datapupuk1 <= 1) {
                                    petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[1] % 2 >= 8 && datapupuk2 <= 1) {
                                    petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[2] % 2 >= 8 && datapupuk3 <= 1) {
                                    petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[3] % 2 >= 8 && datapupuk4 <= 1) {
                                    petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[4] % 2 >= 8 && datapupuk5 <= 1) {
                                    petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[5] % 2 >= 8 && datapupuk6 <= 1) {
                                    petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[0] % 2 <= 3) {
                                    petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[1] % 2 <= 3) {
                                    petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[2] % 2 <= 3) {
                                    petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[3] % 2 <= 3) {
                                    petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[4] % 2 <= 3) {
                                    petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[5] % 2 <= 3) {
                                    petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang.png")));
                                    if (statusTime1[i] == 630) {
                                        petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                }

                            }

                        }

                        if (statusSiram[i]) {
                            statusTime2[i] += 1;
                            if (statusTime2[i] == 660) {
                                statusTime2[i] += 1;
                                statusKotak[i] = 3;
                                air[i].setVisible(false);
                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang buah.png")));
                                petak[i].setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang buah highlight.png")));
                            }

                            if (statusTime2[i] == 704) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime2[i] == 788) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime2[i] == 862) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime2[i] == 862) {
                                buttons[i].setVisible(true);

                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                            }

                            if (statusTime2[i] == 867) {
                                buttons[i].setVisible(false);
                            }

                            if (statusTime2[i] == 880) {
                                gulma[i].setVisible(true);
                                vHome.getBtnCangkul().setEnabled(true);
                                gulma[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gulma.png")));
                            }

                            if (statusTime2[i] == 885) {
                                gulma[i].setVisible(false);
                            }
                            if (statusTime2[i] == 900) {
                                buttons[i].setVisible(true);

                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                            }

                            if (statusTime2[i] == 905) {
                                buttons[i].setVisible(false);
                            }

                            if (statusTime2[i] == 946) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }
                            if (statusTime2[i] == 1020) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime2[i] == 1040) {
                                tunas[i].setVisible(true);
                                vHome.getBtnGunting().setEnabled(true);
                                tunas[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Tunas.png")));
                            }

                            if (statusTime2[i] == 1045) {
                                tunas[i].setVisible(false);
                            }

                            if (statusTime2[i] == 1080) {
                                obatbtn[i].setVisible(true);

                                obatbtn[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Uler.png")));
                            }
                            if (statusTime2[i] == 1104) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime1[i] == 1120) {
                                if (statusAir[0] % 4 >= 8 && datapupuk1 <= 1) {
                                    petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[1] % 4 >= 8 && datapupuk2 <= 1) {
                                    petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[2] % 4 >= 8 && datapupuk3 <= 1) {
                                    petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[3] % 4 >= 8 && datapupuk4 <= 1) {
                                    petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[4] % 4 >= 8 && datapupuk5 <= 1) {
                                    petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[5] % 4 >= 8 && datapupuk6 <= 1) {
                                    petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[0] % 4 <= 3) {
                                    petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[1] % 4 <= 3) {
                                    petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[2] % 4 <= 3) {
                                    petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[3] % 4 <= 3) {
                                    petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[4] % 4 <= 3) {
                                    petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                } else if (statusAir[5] % 4 <= 3) {
                                    petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/New/sedang+buah busuk.png")));
                                    if (statusTime1[i] == 1130) {
                                        petak[5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Gundukan.png")));

                                    }
                                }

                            }

                        }

                        if (statusKotak[i] == 3) {
                            statusTime3[i] += 1;

                            if (statusTime3[i] == 1150) {

                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/GediTok.png")));
                            }
                            if (statusTime3[i] == 1270) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }
                            if (statusTime3[i] == 1390) {
                                buttons[i].setVisible(true);

                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                            }

                            if (statusTime3[i] == 1510) {
                                air[i].setVisible(true);

                                air[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/ngelak.png")));
                            }

                            if (statusTime3[i] == 1630) {
                                buttons[i].setVisible(true);

                                buttons[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Pupuk Notif.png")));
                            }

                            if (statusTime3[i] == 1900) {

                                statusKotak[i] = 4;
                                petak[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/GediBaru.png")));
                            }

                        }
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
