package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BLL.DB;
import java.sql.Connection;
import java.sql.SQLException;

public class Room {

	private String sql = "";
	private Connection conn = DB.getConnect();

	public List<BLL.Room> getAllRoom(String search) {
		sql = "SELECT * FROM ROOM WHERE ROOM.ROOM_NAME LIKE ?";
		List list = new ArrayList<>();
		try {
			if (conn != null) {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + search + "%");
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Room room = new BLL.Room();
					room.setId(rs.getInt("ROOM_ID"));
					room.setName(rs.getString("ROOM_NAME"));
					room.setStatus(rs.getString("STATUS"));
					room.setPrice(rs.getDouble("PRICE"));
					room.setPubKey(rs.getString("PUBLIC_KEY"));
					room.setPriKey(rs.getString("PRIVATE_KEY"));
					list.add(room);
				}
			} else {
				System.out.println("Connect error!!!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public Boolean createRoom(BLL.Room room) {
		try {
			PreparedStatement statement = DB.getConnect().prepareStatement(
				"{CALL ROOM_PKG.INSERT_ROOM(?,?,?)}");

			statement.setString(1, room.getName());
			statement.setString(2, room.getStatus());
			statement.setDouble(3, room.getPrice());

			int rowsInserted = statement.executeUpdate();

			return rowsInserted > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public Boolean updateRoom(BLL.Room room) {
		try {
			PreparedStatement statement = DB.getConnect().prepareStatement(
				"{CALL ROOM_PKG.UPDATE_ROOM(?,?,?,?,?,?)}");

			statement.setInt(1, room.getId());
			statement.setString(2, room.getName());
			statement.setString(3, room.getStatus());
			statement.setDouble(4, room.getPrice());
			statement.setString(5, room.getPubKey());
			statement.setString(6, room.getPriKey());

			int rowsInserted = statement.executeUpdate();

			return rowsInserted > 0;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
}
