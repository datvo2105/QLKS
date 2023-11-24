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
		if (conn != null) {
			try {
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
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return list;
	}

	public Boolean createRoom(BLL.Room room) {
		sql = "{CALL DEV.ROOM_PKG.INSERT_ROOM( ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, room.getName());
				sm.setString(2, room.getStatus());
				sm.setDouble(3, room.getPrice());

				int rowsInserted = sm.executeUpdate();

				return rowsInserted > 0;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return false;
	}

	public Boolean updateRoom(BLL.Room room) {
		sql = "{CALL DEV.ROOM_PKG.UPDATE_ROOM( ?, ?, ?, ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, room.getId());
				sm.setString(2, room.getName());
				sm.setString(3, room.getStatus());
				sm.setDouble(4, room.getPrice());
				sm.setString(5, room.getPubKey());
				sm.setString(6, room.getPriKey());

				int rowsInserted = sm.executeUpdate();

				return rowsInserted > 0;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return false;
	}

	public Boolean deleteRoom(BLL.Room room) {
		sql = "{CALL ROOM_PKG.DELETE_ROOM( ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, room.getId());

				int rowsInserted = sm.executeUpdate();

				return rowsInserted > 0;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("Connect error!!!");
		}
		return false;
	}
}
