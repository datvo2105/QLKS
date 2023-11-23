/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BLL.DB;
import java.sql.SQLException;

/**
 *
 * @author vogiadat
 */
public class User {

	public List<BLL.User> getUsers(String search) {
		List list = new ArrayList<>();
		try {
			PreparedStatement statement = DB.getConnect().prepareStatement(
				"SELECT UA.USER_ID, UA.EMAIL, UA.ROLE_ID, R.ROLE_NAME, UA.USERNAME, UA.PASSWORD FROM TABLE(USER_PKG.GET_USER('')) UA JOIN ROLES R ON UA.ROLE_ID = R.ROLE_ID");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				BLL.User user = new BLL.User();
				user.setId(resultSet.getInt("USER_ID"));
				user.setEmail(resultSet.getString("EMAIL"));
				user.setRole_id(resultSet.getInt("ROLE_ID"));
				user.setRole_name(resultSet.getString("ROLE_NAME"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public Boolean createUser(BLL.User user) {
		try {
			PreparedStatement statement = DB.getConnect().prepareStatement(
				"{CALL USER_PKG.INSERT_USER(?, ?, ?, ?, ?)}");

			statement.setInt(0, user.getId());
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getRole_id());

			int rowsInserted = statement.executeUpdate();

			return rowsInserted > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public Boolean updateUser(BLL.User user) {
		try {
			PreparedStatement statement = DB.getConnect().prepareStatement(
				"{CALL ROOM_PKG.UPDATE_ROOM(?,?,?,?,?)}");

			statement.setInt(1, user.getId());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4,user.getEmail());
			statement.setInt(5, user.getRole_id());

			int rowsInserted = statement.executeUpdate();

			return rowsInserted > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
}
