package apk;
import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class shiftControl {
    static LocalTime jam_masuk_time , jam_keluar_time;
    static boolean ValidasiShift (String jamMasuk, String menitMasuk, String jamKeluar, String menitKeluar, String shiftMasuk, String shiftKeluar , String NIP, String NamaShift){


        String jamMasukShift[] = shiftMasuk.split (":");
        String jamKeluarShift[] = shiftKeluar.split(":");

        int jamMasukShift1 = Integer.parseInt(jamMasukShift[0]) * 60;
        int jamKeluarShift1 = Integer.parseInt(jamKeluarShift[0]) * 60;

        int jamMasuk1 = Integer.parseInt(jamMasuk) * 60 + Integer.parseInt(menitMasuk);
        int jamKeluar2 = Integer.parseInt(jamKeluar) * 60 + Integer.parseInt(menitKeluar);

        int num1 = (Integer.parseInt(jamMasuk) + 7) % 24;
        int num2 = (Integer.parseInt(jamKeluar) + 7) % 24;

        if (jamMasuk1 < (jamMasukShift1-10) || jamMasuk1 > (jamMasukShift1+10)){
            JOptionPane.showMessageDialog(null, "Jam masuk terlalu cepat ! atau kamu telat !");
            return false;
        }
        int total_lembur = 0;
        if (jamKeluar2 < jamKeluarShift1){
            int count = 0;
            int numSebelum = Integer.parseInt(jamKeluar);
            int numSesudah = Integer.parseInt(jamKeluarShift[0]);
            while (numSebelum != numSesudah){
                count += 1 ;
                numSesudah +=1;
                numSesudah = numSesudah %24;
            }
            total_lembur = count;
        }
        else {
            total_lembur = (jamKeluar2 - jamKeluarShift1) / 60;
        }
        //PARSING to 0x
        if (num2 < 10){
            String num2_new = "0" + num2;
            String string_jam_keluar = num2_new + ":" + menitKeluar;
            jam_keluar_time = LocalTime.parse(string_jam_keluar);
        }
        else {
            String string_jam_keluar = num2 + ":" + menitKeluar;
            jam_keluar_time = LocalTime.parse(string_jam_keluar);
        }

        if (num1 < 10){
            String num1_new = "0"+num1;
            String string_jam_masuk = num1_new + ":" + menitMasuk;
            jam_masuk_time = LocalTime.parse(string_jam_masuk);
        }
        else {
            String string_jam_masuk = num1 + ":" + menitMasuk;
            jam_masuk_time = LocalTime.parse(string_jam_masuk);
        }


        return shift_entity.insertAbsen(NIP, CurrentDateTime(),NamaShift, Time.valueOf(jam_masuk_time), Time.valueOf(jam_keluar_time), total_lembur);
    }
    static public Date CurrentDateTime() {
        java.time.LocalDate date = java.time.LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        return sqlDate;
    }

}



