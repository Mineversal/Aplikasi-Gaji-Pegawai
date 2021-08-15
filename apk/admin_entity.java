package apk;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class admin_entity {
    private static Connection koneksi = null;

    static String[] getShiftFromDatabase(){
        try {

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();
            ResultSet rs = state.executeQuery("SELECT COUNT(Nama_Shift) AS jumlah FROM Shift");
            rs.next();
            String[] data = new String[rs.getInt("jumlah")];

            rs = state.executeQuery("SELECT * FROM Shift");
            int count = 0;
            while (rs.next()){
                data[count] = rs.getString("Nama_Shift") ;
                count += 1;
            }
            return data;



        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }

    }

    static public Connection showTableOnNIP(DefaultTableModel model, String NIP){
        try {
            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();

            //query buku tergantung pada publisher yg di tentukan
            ResultSet rs =  state.executeQuery("SELECT NIP, tanggal, nama_shift, jam_masuk, jam_keluar  FROM absen WHERE NIP ='"+NIP+"'");

            //overwrite model tabel
            model.setRowCount(0);

            while(rs.next()){
                String d = rs.getString("tanggal");
                String e = rs.getString("nama_shift");
                String f = rs.getString("jam_masuk");
                String g = rs.getString("jam_keluar");
                String h = rs.getString("NIP");
                model.addRow(new Object[]{h, d, e, f, g});

            }
            admin.table.setModel(model);


            koneksi.close();
        }
        catch (SQLException t){
            System.out.print(t);

        }
        return koneksi;

    }

    static public Connection showTableOnDate(DefaultTableModel model, String tgl){
        try {
            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();

            //query buku tergantung pada publisher yg di tentukan
            ResultSet rs =  state.executeQuery("SELECT NIP, tanggal, nama_shift, jam_masuk, jam_keluar  FROM absen WHERE tanggal ='"+tgl+"'");

            //overwrite model tabel
            model.setRowCount(0);

            while(rs.next()){
                String d = rs.getString("tanggal");
                String e = rs.getString("nama_shift");
                String f = rs.getString("jam_masuk");
                String g = rs.getString("jam_keluar");
                String h = rs.getString("NIP");
                model.addRow(new Object[]{h, d, e, f, g});

            }
            admin.table.setModel(model);


            koneksi.close();
        }
        catch (SQLException t){
            System.out.print(t);

        }
        return koneksi;

    }

    static public boolean pergantianShift(String NIP, String shift){
        try {

            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            String query = " UPDATE shift_pegawai SET Nama_Shift = '"+shift+"' WHERE NIP = '"+NIP+"';";
            PreparedStatement state = koneksi.prepareStatement(query);

            //execute
            state.executeUpdate();
            koneksi.close();
            return true;
        }
        catch (SQLException t){
            System.out.print(t);
            return false;
        }
    }
}