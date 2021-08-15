package apk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    static Connection connection;

    public static void setConnection(){
        try {
            //setting connection to databse
            String url = "jdbc:mysql://107.167.80.195:3306/minevers_RPL?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "minevers_root";
            String pass = "user@mineversal.c0m";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (SQLException t){
            System.out.println(t);
        }
    }
}
