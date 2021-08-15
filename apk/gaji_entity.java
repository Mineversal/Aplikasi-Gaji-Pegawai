package apk;

import java.sql.*;

public class gaji_entity {

    private static  Connection koneksi = null;
    static public java.sql.ResultSet queryGaji(String NIP){
        try{
            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();

            //query buku tergantung pada publisher yg di tentukan
            ResultSet rs = state.executeQuery("SELECT golongan.jenis_golongan, gaji_lembur , gaji_pokok , COUNT(absen.NIP) AS jumlah_absen , SUM(absen.total_lembur) AS total_lembur FROM golongan JOIN golongan_pegawai ON golongan.jenis_golongan = golongan_pegawai.jenis_golongan JOIN absen ON golongan_pegawai.NIP = absen.NIP WHERE absen.NIP ='" + NIP + "' GROUP BY absen.NIP");

            return rs;
        }
        catch (SQLException t){
            System.out.print(t);
            return null;
        }
    }
}
