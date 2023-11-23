/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vogiadat
 */
public class DB {
	
    public static Connection conn;
    public static String user = "dev";
    public static String pass = "1";
    public static String url = "jdbc:oracle:thin:@";
    public static String server = "localhost:1521:orcl";

    public static Connection connect() {
        try {
            if (user.equalsIgnoreCase("sys")) {
                user += " as sysdba";
            }
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url + server, user, pass);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    public static Connection getConnect() {
        if (conn != null) {
            return conn;
        }
        return connect();
    }

    public static Connection disConnect() {
        user = "developer";
        pass = "1";
        return connect();
    }
}
