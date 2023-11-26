package DAL;

import BLL.DB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
	private final Connection conn = DB.getConnect();

	public List<BLL.Booking> getAllBooking(String search, String filter) {
		sql = "SELECT B.*, R.ROOM_NAME FROM DEV.BOOKING B JOIN DEV.ROOM R ON B.ROOM_ID = R.ROOM_ID WHERE USERNAME LIKE ? AND B.STATUS LIKE ?";
		List list = new ArrayList<>();
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + search + "%");
				sm.setString(2, "%" + filter + "%");
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
					booking.setStatus(rs.getString("STATUS"));
					list.add(booking);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect error!!!");
		}

		return list;
	}

	public Boolean createBooking(BLL.Booking booking) {
		sql = "{CALL DEV.INSERT_BOOKING( ?, ?, ?, ?, ?)}";
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
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect error!!!");
		}

		return false;
	}

	public Boolean updateBooking(BLL.Booking booking) {
		sql = "{CALL DEV.UPDATE_BOOKING( ?, ?, ?, ?, ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, booking.getId());
				sm.setString(2, booking.getName());
				sm.setString(3, booking.getRoomKey());
				sm.setString(4, booking.getUser());
				sm.setInt(5, booking.getRoomId());
				sm.setDouble(6, booking.getHours());
				sm.setString(7, booking.getStatus());

				int rowsInserted = sm.executeUpdate();

				return rowsInserted > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect error!!!");
		}

		return false;
	}

	public Boolean deleteBooking(BLL.Booking booking) {
		sql = "{CALL DEV.DELETE_BOOKING( ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, booking.getId());

				int rowsInserted = sm.executeUpdate();

				return rowsInserted > 0;
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Connect error!!!");
		}

		return false;
	}
}
