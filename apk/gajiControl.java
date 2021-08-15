package apk;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gajiControl {

    public static void validasiLaporanGaji(String NIP, JTextArea golongan, JTextArea LamaKerja, JTextArea LamaLembur, JTextArea gajiPokok, JTextArea gajiLembur, JTextArea totalGaji){
        try {
            ResultSet rs = gaji_entity.queryGaji(NIP);
            rs.next();
            String golonganString = rs.getString("jenis_golongan");
            Double gaji_lembur = rs.getDouble("gaji_lembur");
            Double gaji_pokok = rs.getDouble("gaji_pokok");
            Integer jumlah_absen = rs.getInt("jumlah_absen");
            Integer total_lembur = rs.getInt("total_lembur");
            Double total_gaji = gaji_lembur * total_lembur + gaji_pokok * jumlah_absen;

            gaji_pokok = jumlah_absen * gaji_pokok;
            gaji_lembur = total_lembur * gaji_lembur;

            golongan.setText(golonganString);
            LamaKerja.setText(jumlah_absen + " Hari");
            LamaLembur.setText(total_lembur + " Jam");
            gajiPokok.setText("Rp. " + gaji_pokok);
            gajiLembur.setText("Rp. " + gaji_lembur);
            totalGaji.setText("Rp. " + total_gaji);

        }
        catch (SQLException E){
            System.out.println(E);
        }
    }
}
