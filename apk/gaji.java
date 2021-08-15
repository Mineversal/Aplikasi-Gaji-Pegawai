package apk;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

class gaji extends JFrame implements ActionListener {
    private String Snip, Snama;
    private boolean admin;
    JTextArea nip, nama, gol, lamakerja, lamalembur, gaji , lembur,  totalgaji, tgl;

    public gaji(String NIP, String Nama, boolean adminP) {
        this.Snip = NIP;
        this.Snama = Nama;
        this.admin = adminP;
        Image icon = Toolkit.getDefaultToolkit().getImage((getClass().getResource("logo.png")));
        setIconImage(icon);
        setTitle("Aplikasi Absensi dan Laporan Gaji Pegawai | Laporan Gaji");
        GUIGaji();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void GUIGaji() {
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

        navPanel.add(btGaji);

        if(admin) {
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

            btAdmin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    admin adminGUI = new admin(Snip, Snama, admin);
                    adminGUI.setVisible(true);
                    dispose();
                }
            });

        }

        navPanel.setBorder(BorderFactory.createTitledBorder("Navigasi"));

        JPanel gajiPanel = new JPanel();
        gajiPanel.setLayout(gb);

        JLabel Lnip = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(Lnip, gbc);
        gajiPanel.add(Lnip);

        nip = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        gajiPanel.add(nip);
        nip.setText(Snip);
        nip.setEditable(false);

        JLabel Lnama = new JLabel("Nama:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(Lnama, gbc);
        gajiPanel.add(Lnama);

        nama = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(nama, gbc);
        gajiPanel.add(nama);
        nama.setText(Snama);
        nama.setEditable(false);

        JLabel Lg = new JLabel("Golongan:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(Lg, gbc);
        gajiPanel.add(Lg);

        gol = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gb.setConstraints(gol, gbc);
        gajiPanel.add(gol);
        gol.setEditable(false);

        JLabel Lwaktubekerja = new JLabel("Lama Kerja:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gb.setConstraints(Lwaktubekerja, gbc);
        gajiPanel.add(Lwaktubekerja);

        lamakerja = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gb.setConstraints(lamakerja, gbc);
        gajiPanel.add(lamakerja);
        lamakerja.setEditable(false);

        JLabel Lwaktulembur = new JLabel("Lama Lembur:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gb.setConstraints(Lwaktulembur, gbc);
        gajiPanel.add(Lwaktulembur);

        lamalembur = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gb.setConstraints(lamalembur, gbc);
        gajiPanel.add(lamalembur);
        lamalembur.setEditable(false);

        JLabel Lgaji = new JLabel("Gaji:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gb.setConstraints(Lgaji, gbc);
        gajiPanel.add(Lgaji);

        gaji = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gb.setConstraints(gaji, gbc);
        gajiPanel.add(gaji);
        gaji.setEditable(false);

        JLabel Llembur = new JLabel("Gaji Lembur:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gb.setConstraints(Llembur, gbc);
        gajiPanel.add(Llembur);

        lembur = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gb.setConstraints(lembur, gbc);
        gajiPanel.add(lembur);
        lembur.setEditable(false);

        JLabel Ltotalgaji = new JLabel("Total Gaji:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gb.setConstraints(Ltotalgaji, gbc);
        gajiPanel.add(Ltotalgaji);

        totalgaji = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gb.setConstraints(totalgaji, gbc);
        gajiPanel.add(totalgaji);
        totalgaji.setEditable(false);

        JLabel Ltgl = new JLabel("Tanggal Hari Ini:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gb.setConstraints(Ltgl, gbc);
        gajiPanel.add(Ltgl);

        tgl = new JTextArea(1, 15);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gb.setConstraints(tgl, gbc);
        gajiPanel.add(tgl);
        tgl.setEditable(false);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        tgl.setText(dtf.format(now));

        JButton btProsesGaji = new JButton("Hitung Gaji");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 9;
        gb.setConstraints(btProsesGaji, gbc);

        btProsesGaji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gajiControl.validasiLaporanGaji(Snip, gol, lamakerja, lamalembur, gaji, lembur, totalgaji);
            }
        });

        gajiPanel.add(btProsesGaji);

        JButton btPrintGaji = new JButton("Print Gaji");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridy = 9;
        gb.setConstraints(btPrintGaji, gbc);

        btPrintGaji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream("RincianGajiPegawai.pdf"));

                    document.open();

                    PdfPTable table = new PdfPTable(8);
                    addTableHeader(table);
                    addRows(table);

                    document.add(table);
                    document.close();
                } catch (Exception t) {
                    System.out.println(t);
                }
            }
        });

        gajiPanel.add(btPrintGaji);

        gajiPanel.setBorder(BorderFactory.createTitledBorder("Laporan Gaji"));

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
        cp.add(gajiPanel,  new GridBagConstraints(1, 0, 2, 0, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(panelCopyright,  new GridBagConstraints(0, 1, 1, 1, 1.0, 0.4, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private void addTableHeader(PdfPTable table) {
        Stream.of("NIP", "Nama", "Golongan", "Lama Kerja", "Lama Lembur", "Gaji", "Bonus Lembur", "Total Gaji")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {
        table.addCell(nip.getText());
        table.addCell(nama.getText());
        table.addCell(gol.getText());
        table.addCell(lamakerja.getText());
        table.addCell(lamalembur.getText());
        table.addCell(gaji.getText());
        table.addCell(lembur.getText());
        table.addCell(totalgaji.getText());
    }
}
