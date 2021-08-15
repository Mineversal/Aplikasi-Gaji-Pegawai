package apk;
import javax.swing.*;
import java.sql.*;

public class login_entity {
    private static Connection koneksi = null;

    static boolean matchingUserInDatabase(String NIP, String pwd) {
        try {
            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();
            ResultSet tf = state.executeQuery("SELECT NIP, Password FROM pegawai WHERE NIP = '"+NIP+"' AND Password = '"+pwd+"'");
            if (tf.next()){
                return true;
            }
            else{
                return false;
            }


        }
        catch (SQLException t){
            System.out.print(t);

            return false;
        }
    }

    static String[] fetchUsernameForNIP(String NIP){
        try {
            //setting connection to databse

            koneksi = connection.connection;

            //create stament untuk query
            Statement state = (Statement) koneksi.createStatement();
            ResultSet tf = state.executeQuery("SELECT Nama , admin FROM pegawai WHERE NIP ='" + NIP + "'");
            tf.next();
            String data[] = new String[2];
            data[0] = tf.getString("Nama");
            data[1] = tf.getString("admin");

            return data;


        }
        catch (SQLException t){
            System.out.print(t);

            return null;
        }
    }


}

