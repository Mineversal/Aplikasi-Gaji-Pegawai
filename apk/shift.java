package apk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class shift extends JFrame implements ActionListener {
    public Label nip, nama, shift;
    static public  JTable table;
    public JTextField jamKeluar , menitKeluar , jamMasuk, menitMasuk;
    private boolean admin;
    private String Snip, Snama;
    DefaultTableModel model = new DefaultTableModel(new String[]{"Tanggal", "Nama Shift", "Jam Masuk","Jam Keluar"}, 0 );

    public shift(String NIP, String Nama, boolean adminP) {
        this.admin = adminP;
        this.Snama = Nama;
        this.Snip = NIP;
        Image icon = Toolkit.getDefaultToolkit().getImage((getClass().getResource("logo.png")));
        setIconImage(icon);
        setTitle("Aplikasi Absensi dan Laporan Gaji Pegawai | Shift dan Absensi");
        GUIShift();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void GUIShift() {



        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        Container cp = getContentPane();
        cp.setLayout(gb);

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

        nip = new Label(this.Snip);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        navPanel.add(nip);

        JLabel LNama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LNama, gbc);
        navPanel.add(LNama);

        nama = new Label(this.Snama);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(nama, gbc);
        navPanel.add(nama);

        JButton btShift = new JButton("Shift dan Absensi");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.ipady = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(btShift, gbc);


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
        if(this.admin) {
            JButton btAdmin = new JButton("Admin Panel");
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridwidth = 2;
            gbc.ipady = 2;
            gbc.gridx = 0;
            gbc.gridy = 3;
            gb.setConstraints(btAdmin, gbc);

            btAdmin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    admin adminGUI = new admin(Snip, Snama, admin);
                    adminGUI.setVisible(true);
                    dispose();

                }
            });

            navPanel.add(btAdmin);

        }

        navPanel.setBorder(BorderFactory.createTitledBorder("Navigasi"));

        JPanel shiftPanelKiri = new JPanel();
        shiftPanelKiri.setLayout(gb);


        table = new JTable(model);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(table, gbc);
        shiftPanelKiri.add(table);

        shiftPanelKiri.add(new JScrollPane(table));

        shiftPanelKiri.setBorder(BorderFactory.createTitledBorder("Daftar Absen"));

        JPanel shiftPanelKanan = new JPanel();
        shiftPanelKanan.setLayout(gb);

        shift_entity.getKoneksi(model, Snip);



        JLabel LblNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LblNIP, gbc);
        shiftPanelKanan.add(LblNIP);

        nip = new Label(this.Snip);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        shiftPanelKanan.add(nip);

        JLabel LblNama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LblNama, gbc);
        shiftPanelKanan.add(LblNama);

        nama = new Label(this.Snama);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(nama, gbc);
        shiftPanelKanan.add(nama);

        String data[] = new String[5];
        data = shift_entity.getUserPersonalData(this.Snip);

        JLabel LShift = new JLabel("Shift Hari Ini:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(LShift, gbc);
        shiftPanelKanan.add(LShift);

        shift = new Label(data[1]);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(shift, gbc);
        shiftPanelKanan.add(shift);

        JLabel LGol = new JLabel("Golongan:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(LGol, gbc);
        shiftPanelKanan.add(LGol);

        shift = new Label(data[0]);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(shift, gbc);
        shiftPanelKanan.add(shift);

        JLabel LTgl = new JLabel("maksimal telat adalah 10 menit");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gb.setConstraints(LTgl, gbc);
        shiftPanelKanan.add(LTgl);


        JLabel LJamMasuk = new JLabel("Jam Masuk:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gb.setConstraints(LJamMasuk, gbc);
        shiftPanelKanan.add(LJamMasuk);

        jamMasuk = new JTextField(2);
        jamMasuk.setHorizontalAlignment(JTextField.RIGHT);
        gbc.insets = new Insets(5,5,5,15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 35;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gb.setConstraints(jamMasuk, gbc);
        shiftPanelKanan.add(jamMasuk);

        JLabel LJm = new JLabel(":");
        gbc.insets = new Insets(5,15,5,0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 5;
        gb.setConstraints(LJm, gbc);
        shiftPanelKanan.add(LJm);

        menitMasuk = new JTextField(2);
        menitMasuk.setHorizontalAlignment(JTextField.RIGHT);
        gbc.insets = new Insets(5,0,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gb.setConstraints(menitMasuk, gbc);
        shiftPanelKanan.add(menitMasuk);

        JLabel LJamKeluar = new JLabel("Jam Keluar:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gb.setConstraints(LJamKeluar, gbc);
        shiftPanelKanan.add(LJamKeluar);

        jamKeluar = new JTextField(2);
        jamKeluar.setHorizontalAlignment(JTextField.RIGHT);
        gbc.insets = new Insets(5,5,5,15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gb.setConstraints(jamKeluar, gbc);
        shiftPanelKanan.add(jamKeluar);

        JLabel Lm = new JLabel(":");
        gbc.insets = new Insets(5,15,5,0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 6;
        gb.setConstraints(Lm, gbc);
        shiftPanelKanan.add(Lm);

        menitKeluar = new JTextField(2);
        menitKeluar.setHorizontalAlignment(JTextField.RIGHT);
        gbc.insets = new Insets(5,0,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 3;
        gbc.gridy = 6;
        gb.setConstraints(menitKeluar, gbc);
        shiftPanelKanan.add(menitKeluar);


        JButton btSubmitAbsensi = new JButton("Absen Hari Ini");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gb.setConstraints(btSubmitAbsensi, gbc);

        String jamShift = data[2];
        String jamKeluarShift = data[3];
        String namaShift = data[4];

        btSubmitAbsensi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shiftControl.ValidasiShift(jamMasuk.getText(), menitMasuk.getText(), jamKeluar.getText(), menitKeluar.getText(), jamShift , jamKeluarShift, Snip, namaShift)){
                    JOptionPane.showMessageDialog(null, "Absen berhasil !");
                    shift_entity.getKoneksi(model, Snip);
                }

            }
        });

        shiftPanelKanan.add(btSubmitAbsensi);

        shiftPanelKanan.setBorder(BorderFactory.createTitledBorder("Shift dan Absensi"));

        cp.add(navPanel,  new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(shiftPanelKanan,  new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(shiftPanelKiri,  new GridBagConstraints(1, 0, 1, 2, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}