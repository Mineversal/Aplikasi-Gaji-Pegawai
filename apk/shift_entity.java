package apk;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class shift_entity {

    private static Connection koneksi = null;

    static String[] getUserPersonalData(String NIP){
        try {

            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();
            ResultSet tf = state.executeQuery("SELECT Shift.Nama_Shift , jenis_golongan , jam_masuk, jam_keluar FROM shift_pegawai JOIN golongan_pegawai ON shift_pegawai.NIP = golongan_pegawai.NIP JOIN Shift ON shift_pegawai.Nama_Shift = Shift.Nama_Shift WHERE shift_pegawai.NIP = '" + NIP + "'");
            if(tf.next()) {
                String data[] = new String[5];
                data[0] = tf.getString("jenis_golongan");
                data[2] = tf.getString("jam_masuk");
                data[3] = tf.getString("jam_keluar");
                data[4] = tf.getString("Nama_Shift");
                data[1] = tf.getString("Nama_Shift") + " ( " + tf.getString("jam_masuk") + " - " + tf.getString("jam_keluar") + " ) ";
                return data;
            }
            return null;


        }
        catch (SQLException t){
            System.out.print(t);

            System.out.print("test1");
            return null;
        }
    }

    static boolean insertAbsen(String NIP, Date tanggal, String namaShift, Time jam_masuk, Time jam_keluar, int total_lembur){
        try {

            //setting connection to databse

            koneksi = connection.connection;

            //check apakah sudah absensi pada hari ini
            Statement state1 = (Statement) koneksi.createStatement();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            ResultSet tf = state1.executeQuery("SELECT * FROM absen WHERE tanggal = '"+dtf.format(now)+"' AND NIP = '"+NIP+"'");
            if(tf.next()){
                JOptionPane.showMessageDialog(null, "Kamu sudah absen hari ini!");
                return false;
            }


            //create stament untuk query
            String query = " insert into absen (NIP, nama_shift, tanggal, jam_masuk, jam_keluar, total_lembur)"
                    + " values (?, ?, ?, ?, ?, ?)";
            PreparedStatement state = koneksi.prepareStatement(query);
            state.setString(1, NIP);
            state.setString(2, namaShift);
            state.setDate(3, tanggal);
            state.setTime(4, jam_masuk);
            state.setTime(5, jam_keluar);
            state.setInt(6, total_lembur);
            state.execute();
            return true;
        }
        catch (SQLException t){
            System.out.print(t);

            System.out.print("test2");
            return false;
        }
    }

    public static Connection getKoneksi(DefaultTableModel model, String NIP){
        try {
            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();

            //query buku tergantung pada publisher yg di tentukan
            ResultSet rs =  state.executeQuery("SELECT tanggal, nama_shift, jam_masuk, jam_keluar  FROM absen WHERE NIP ='"+NIP+"'");

            //overwrite model tabel
            model.setRowCount(0);
            while(rs.next()){
                String d = rs.getString("tanggal");
                String e = rs.getString("nama_shift");
                String f = rs.getString("jam_masuk");
                String g = rs.getString("jam_keluar");
                model.addRow(new Object[]{d, e, f, g});
            }
            shift.table.setModel(model);

        }
        catch (SQLException t){
            System.out.print(t);
            System.out.print("test3");

        }
        return koneksi;
    }
}
