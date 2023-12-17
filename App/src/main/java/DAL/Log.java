/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vogiadat
 */
public class Log {

	private String sql = "";
	private final Connection conn = DB.getConnect();

	public List<BLL.Log> getLog() {
		sql = "SELECT * FROM DEV.LOGIN_LOG";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Log log = new BLL.Log();

					log.setUser(rs.getString("USERNAME"));
					log.setTime(rs.getString("LOGIN_TIME"));
					log.setIp(rs.getString("IP_ADDRESS"));
					list.add(log);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect fail!");
		}

		return list;
	}

}
