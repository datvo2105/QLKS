package DAL;

import BLL.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vogiadat
 */
public class Booking {

	private String sql = "";
	private Connection conn = DB.getConnect();

	public List<BLL.Booking> getAllBooking(String search) {
		sql = "SELECT * FROM BOOKING WHERE BOOKING.USERNAME LIKE ?";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + search + "%");
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Booking booking = new BLL.Booking();
					booking.setId(rs.getInt("BOOKING_ID"));
					booking.setName(rs.getString("BOOKING_NAME"));
					booking.setRoomKey(rs.getString("BOOKING_ROOM_KEY"));
					booking.setUser(rs.getString("USERNAME"));
					booking.setRoomId(rs.getInt("ROOM_ID"));
					booking.setHours(rs.getDouble("BOOKING_HOURS"));
					list.add(booking);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return list;
	}

	public List<BLL.Booking> getBookingOfUser() {
		sql = "SELECT B*, R.ROOM_NAME FROM DEV.BOOKING B JOIN DEV.ROOM R ON B.ROOM_ID = R.ROOM_ID WHERE USERNAME LIKE ?";

		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + DB.user.toUpperCase() + "%");
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Booking booking = new BLL.Booking();
					booking.setId(rs.getInt("BOOKING_ID"));
					booking.setName(rs.getString("BOOKING_NAME"));
					booking.setRoomKey(rs.getString("BOOKING_ROOM_KEY"));
					booking.setUser(rs.getString("USERNAME"));
					booking.setRoomId(rs.getInt("ROOM_ID"));
					booking.setRoomName(rs.getString("ROOM_NAME"));
					booking.setHours(rs.getDouble("BOOKING_HOURS"));
					list.add(booking);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return list;
	}

	public Boolean createBooking(BLL.Booking booking) {
		sql = "{CALL DEV.BOOKING_PKG.INSERT_BOOKING( ?, ?, ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, booking.getName());
				sm.setString(2, booking.getRoomKey());
				sm.setString(3, booking.getUser());
				sm.setInt(4, booking.getRoomId());
				sm.setDouble(5, booking.getHours());

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

	public Boolean updateBooking(BLL.Booking booking) {
		sql = "{CALL DEV.BOOKING_PKG.UPDATE_BOOKING( ?, ?, ?, ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, booking.getId());
				sm.setString(2, booking.getName());
				sm.setString(3, booking.getRoomKey());
				sm.setString(4, booking.getUser());
				sm.setInt(5, booking.getRoomId());
				sm.setDouble(6, booking.getHours());

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

	public Boolean deleteBooking(BLL.Booking booking) {
		sql = "{CALL DEV.BOOKING_PKG.DELETE_BOOKING( ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, booking.getId());

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
