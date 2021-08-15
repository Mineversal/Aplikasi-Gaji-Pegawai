package apk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class menu extends JFrame  implements ActionListener {
    public Label nip, nama;
    private String Snip, Snama;
    private boolean admin;

    public menu(String nip, String nama, boolean adminP) {
        Image icon = Toolkit.getDefaultToolkit().getImage((getClass().getResource("logo.png")));
        setIconImage(icon);
        this.Snip = nip;
        this.Snama = nama;
        this.admin = adminP;
        setTitle("Aplikasi Absensi dan Laporan Gaji Pegawai | Menu");
        GUIMenu();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void GUIMenu(){
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Container cp = getContentPane();
        cp.setLayout(gb);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(gb);

        JLabel LNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LNIP, gbc);
        menuPanel.add(LNIP);

        nip = new Label(this.Snip);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        menuPanel.add(nip);

        JLabel LNama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LNama, gbc);
        menuPanel.add(LNama);

        nama = new Label(this.Snama);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(nama, gbc);
        menuPanel.add(nama);


        JButton btShift = new JButton("Shift dan Absensi");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.ipady = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(btShift, gbc);

        btShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shift shiftGUI = new shift(Snip, Snama, admin);
                shiftGUI.setVisible(true);
                dispose();
            }
        });

        menuPanel.add(btShift);



        JButton btGaji = new JButton("Laporan Total Gaji");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.ipady = 2;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(btGaji, gbc);

        btGaji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gaji gajiGUI = new gaji(Snip, Snama, admin);
                gajiGUI.setVisible(true);
                dispose();
            }
        });

        menuPanel.add(btGaji);


        if (this.admin == true) {
            JButton btAdmin = new JButton("Admin Panel");
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridwidth = 2;
            gbc.ipady = 2;
            gbc.gridx = 0;
            gbc.gridy = 3;
            gb.setConstraints(btAdmin, gbc);

            menuPanel.add(btAdmin);

            btAdmin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    admin adminGUI = new admin(Snip, Snama, admin);
                    adminGUI.setVisible(true);
                    dispose();
                }
            });
        }

        menuPanel.setBorder(BorderFactory.createTitledBorder("Selamat Datang"));

        JPanel panelCopyright = new JPanel();
        panelCopyright.setLayout(gb);
        panelCopyright.setBorder(BorderFactory.createEtchedBorder());

        JLabel labelCopyright =  new JLabel("Created by Mineversal Team");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCopyright.add(labelCopyright, gbc);

        JLabel labelCp =  new JLabel("Copyright © 2020 Mineversal");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelCopyright.add(labelCp, gbc);

        JPanel panelNama = new JPanel();
        panelNama.setLayout(gb);
        panelNama.setBorder(BorderFactory.createEtchedBorder());

        JLabel Laplikasi =  new JLabel("Aplikasi Absensi dan Laporan Gaji Pegawai");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelNama.add(Laplikasi, gbc);

        cp.add(menuPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(panelCopyright, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(8, 0,
                1, 0), 0, 0));
        cp.add(panelNama, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 2,
                0, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}