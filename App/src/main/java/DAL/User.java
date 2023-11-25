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

/**
 *
 * @author vogiadat
 */
public class User {

	private String sql = "";
	private final Connection conn = DB.getConnect();

	public List<BLL.User> getAllUser(String search) {
		sql = "SELECT * FROM USER_INFOR WHERE USERNAME LIKE ?";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, '%' + search + '%');

				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.User user = new BLL.User();
					user.setId(rs.getInt("USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setEmail(rs.getString("MAIL"));
					user.setPassword(rs.getString("MAIL_PASSWORD"));
					list.add(user);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return list;
	}

	public BLL.User getInforUser() {
		sql = "SELECT * FROM USER_INFOR WHERE USERNAME LIKE ?";
		BLL.User user = new BLL.User();

		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + DB.user.toUpperCase() + "%");
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					user.setId(rs.getInt("USER_ID"));
					user.setUsername(rs.getString("USERNAME"));
					user.setEmail(rs.getString("MAIL"));
					user.setPassword(rs.getString("MAIL_PASSWORD"));
				}

			} catch (SQLException e) {
				System.err.println(e);
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return user;
	}
//	public Boolean createUser(BLL.User user) {
//		try {
//			PreparedStatement statement = DB.getConnect().prepareStatement(
//				"{CALL USER_PKG.INSERT_USER(?, ?, ?, ?, ?)}");
//
//			statement.setInt(0, user.getId());
//			statement.setString(1, user.getUsername());
//			statement.setString(2, user.getPassword());
//			statement.setString(3, user.getEmail());
//			statement.setInt(4, user.getRole_id());
//
//			int rowsInserted = statement.executeUpdate();
//
//			return rowsInserted > 0;
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//
//		return false;
//	}

	public Boolean updateUser(BLL.User user) {
		sql = "CALL DEV.USER_PKG.UPDATE_USER( ?, ?, ?, ?, ?)";
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
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return false;
	}
}
