package apk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class login extends JFrame implements ActionListener {
    private String NIP , Password;
    static JTextField nip;
    JPasswordField pass;

    public login() {
        Image icon = Toolkit.getDefaultToolkit().getImage((getClass().getResource("logo.png")));
        setIconImage(icon);
        setTitle("Aplikasi Absensi dan Laporan Gaji Pegawai | Login 111");
        GUIlogin();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void GUIlogin() {
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        Container cp = getContentPane();
        cp.setLayout(gb);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(gb);

        JLabel LNIP = new JLabel("NIP:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gb.setConstraints(LNIP, gbc);
        loginPanel.add(LNIP);

        nip = new JTextField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gb.setConstraints(nip, gbc);
        loginPanel.add(nip);

        JLabel LPass = new JLabel("Password:");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gb.setConstraints(LPass, gbc);
        loginPanel.add(LPass);

        pass = new JPasswordField(16);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gb.setConstraints(pass, gbc);
        loginPanel.add(pass);

        JButton btLogin = new JButton("Login");
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 4;
        gbc.ipady = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gb.setConstraints(btLogin, gbc);

        loginPanel.add(btLogin);

        btLogin.addActionListener(this);

        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));

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

        cp.add(loginPanel, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0,
                0, 0), 0, 0));
        cp.add(panelCopyright, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(8, 0,
                1, 0), 0, 0));
        cp.add(panelNama, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 2,
                0, 0), 0, 0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        NIP = nip.getText();
        Password = String.valueOf(pass.getPassword());
        boolean previlege = false;
        if(loginControl.validasiIDdanPassword(NIP, Password)){
            String data_user[] = new String[2];
            data_user = login_entity.fetchUsernameForNIP(NIP);
            if (data_user[1].equals("1")){
                previlege = true;
            }
            JOptionPane.showMessageDialog(null, "Selamat datang "+data_user[0]+" !");
            menu logedMenu = new menu(NIP, data_user[0],previlege);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "NIP atau Password salah");
        }
    }

}