/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import BLL.DB;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vogiadat
 */
public class Infor {

	private String sql = "";
	private final Connection conn = DB.getConnect();

	public List<BLL.Infor> getAllInfor(String search) {
		sql = "SELECT * FROM DEV.USER_INFOR WHERE USERNAME LIKE ?";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, '%' + search + '%');

				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Infor user = new BLL.Infor();
					user.setId(rs.getInt("USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setEmail(rs.getString("MAIL"));
					user.setPassword(rs.getString("MAIL_PASSWORD"));
					list.add(user);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect fail!");
		}

		return list;
	}

	public Boolean updateInfor(BLL.Infor user) {
		sql = "CALL DEV.UPDATE_INFOR( ?, ?, ?, ?, ?)";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, user.getId());
				sm.setString(2, user.getUsername());
				sm.setString(3, user.getEmail());
				sm.setString(4, user.getPassword());
				sm.setString(5, user.getKey());

				sm.executeUpdate();

				return true;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect fail!");
		}

		return false;
	}
}
