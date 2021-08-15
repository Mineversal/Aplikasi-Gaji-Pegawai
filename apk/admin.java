package apk;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

class admin extends JFrame implements ActionListener {
    public JComboBox<String> Jadwal;
    public JDateChooser cariTgl;
    private String Snip, Snama;
    private boolean admin;
    public JTextField CariNIP, nip;
    static JTable table;
    DefaultTableModel model = new DefaultTableModel(new String[]{"NIP", "Tanggal", "Nama Shift", "Jam Masuk","Jam Keluar"}, 0 );

    public admin(String NIP, String Nama, boolean adminP) {
        this.admin = adminP;
        this.Snama = Nama;
        this.Snip = NIP;
        Image icon = Toolkit.getDefaultToolkit().getImage((getClass().getResource("logo.png")));
        setIconImage(icon);
        setTitle("Aplikasi Absensi dan Laporan Gaji Pegawai | Admin Panel");
        GUIAdmin();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void GUIAdmin() {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Container cp = getContentPane();
        cp.setLayout(gb);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel navPanel = new JPanel();
        navPanel.setLayout(gb);

        JLabel LNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LNIP, gbc);
        navPanel.add(LNIP);

        Label Mynip = new Label(Snip);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(Mynip, gbc);
        navPanel.add(Mynip);

        JLabel LNama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LNama, gbc);
        navPanel.add(LNama);

        Label Mynama = new Label(Snama);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(Mynama, gbc);
        navPanel.add(Mynama);

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

        navPanel.add(btShift);

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

        navPanel.add(btGaji);

        JButton btAdmin = new JButton("Admin Panel");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.ipady = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(btAdmin, gbc);

        navPanel.add(btAdmin);

        navPanel.setBorder(BorderFactory.createTitledBorder("Navigasi"));

        JPanel adminPanelKiri = new JPanel();
        adminPanelKiri.setLayout(gb);

        JLabel LblNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LblNIP, gbc);
        adminPanelKiri.add(LblNIP);

        nip = new JTextField(10);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        adminPanelKiri.add(nip);


        JLabel LJCShift = new JLabel("Pilih Shift Kerja:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(LJCShift, gbc);
        adminPanelKiri.add(LJCShift);

        String[] jadwal = admin_entity.getShiftFromDatabase();
        Jadwal = new JComboBox(jadwal);
        Jadwal.setSize(15,3);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(Jadwal, gbc);
        adminPanelKiri.add(Jadwal);

        JButton btUpdateShift = new JButton("Update Shift");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(btUpdateShift, gbc);

        btUpdateShift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loginControl.isAlphanumeric(nip.getText())){
                    admin_entity.pergantianShift(nip.getText(), String.valueOf(Jadwal.getSelectedItem()));

                    JOptionPane.showMessageDialog(null, "Berhasil diganti !");

                }
                else {
                    JOptionPane.showMessageDialog(null, "NIP harus alphanumeric !");
                }
            }
        });

        adminPanelKiri.add(btUpdateShift);

        adminPanelKiri.setBorder(BorderFactory.createTitledBorder("Update Shift"));

        JPanel adminPanelKanan = new JPanel();
        adminPanelKanan.setLayout(gb);



        JTable table = new JTable(model);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(table, gbc);
        adminPanelKanan.add(table);

        adminPanelKanan.add(new JScrollPane(table));

        adminPanelKanan.setBorder(BorderFactory.createTitledBorder("Daftar Shift"));

        JPanel cariShiftPanel = new JPanel();
        cariShiftPanel.setLayout(gb);

        JLabel LCariNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LCariNIP, gbc);
        cariShiftPanel.add(LCariNIP);

        CariNIP = new JTextField(12);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(CariNIP, gbc);
        cariShiftPanel.add(CariNIP);
        CariNIP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                admin_entity.showTableOnNIP(model, CariNIP.getText());
            }
        });

        JLabel LAtau = new JLabel("Atau cari dengan");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 15, 5);
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LAtau, gbc);
        cariShiftPanel.add(LAtau);

        JLabel LCariTgl = new JLabel("Tanggal/Hari Kerja:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(LCariTgl, gbc);
        cariShiftPanel.add(LCariTgl);

        cariTgl = new JDateChooser();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(cariTgl, gbc);
        cariTgl.setDateFormatString("dd/MM/yyyy");
        cariTgl.setPreferredSize(new Dimension(50, 20));
        cariShiftPanel.add(cariTgl);
        cariTgl.getDate();

        JButton btCariBerdasarkanTanggal = new JButton("Cari Berdasarkan Tanggal");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(btCariBerdasarkanTanggal, gbc);
        cariShiftPanel.add(btCariBerdasarkanTanggal);

        btCariBerdasarkanTanggal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat tgl = new SimpleDateFormat("yyyy/MM/dd");
                String cv = tgl.format(cariTgl.getDate());
                admin_entity.showTableOnDate(model, cv);

            }
        });


        cariShiftPanel.setBorder(BorderFactory.createTitledBorder("Cari Absen"));

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

        cp.add(navPanel,  new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(panelCopyright,  new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(8, 2,
                1, 1), 0, 0));
        cp.add(adminPanelKiri,  new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(cariShiftPanel,  new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(adminPanelKanan,  new GridBagConstraints(2, 0, 1, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}