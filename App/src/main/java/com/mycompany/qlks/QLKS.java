/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.qlks;

import java.awt.HeadlessException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import BLL.DB;
import GUI.Connect;
import GUI.MainFrame;

/**
 *
 * @author vogiadat
 */
public class QLKS {

    public static void main(String[] args) {

//        new Connect().setVisible(true);
        //DB.server = "192.168.110.96:1521:qlks";
	DB.server = "localhost:1521:ks";
        DB.user = "dev";
        DB.pass = "1";
        Connection conn = DB.getConnect();
        try {
            System.err.println(DB.url + DB.server);
            System.err.println(DB.user);
            System.err.println(DB.pass);
            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Connecting Oracle...");
                // new Authencation().setVisible(true);
                new MainFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Connect fail!!!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
