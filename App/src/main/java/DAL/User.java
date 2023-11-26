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
public class User {

	private String sql = "";
	private final Connection conn = DB.getConnect();

	public List<BLL.User> getAllUser(String search) {
		sql = "SELECT * FROM ALL_USERS WHERE CREATED >= TO_DATE('18:22:48 22/11/2023', 'HH24:MI:SS DD/MM/YYYY') AND USERNAME LIKE ? ";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, '%' + search + '%');
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.User user = new BLL.User();
					user.setUser(rs.getString("USERNAME"));
					user.setCreated(rs.getString("CREATED"));
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

	public Boolean createUser(String username, String password, String email) {
		sql = "CALL DEV.USER_PKG.CREATE_USER( ?, ?, ?)";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, username);
				sm.setString(2, password);
				sm.setString(3, email);

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

	public Boolean createManager(String username, String password, String email) {
		sql = "CALL DEV.USER_PKG.CREATE_MANAGER( ?, ?, ?)";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, username);
				sm.setString(2, password);
				sm.setString(3, email);

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

	public Boolean deleteUser(String username) {
		sql = "CALL DEV.USER_PKG.DELETE_USER( ?)";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, username);

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
