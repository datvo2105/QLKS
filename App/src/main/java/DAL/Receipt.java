/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import BLL.DB;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vogiadat
 */
public class Receipt {

	private String sql = "";
	private Connection conn = DB.getConnect();

	public List<BLL.Receipt> getAllReceipt(String search) {
		sql = "SELECT R.* FROM RECEIPT R JOIN BOOKING B ON R.BOOKING_ID = B.BOOKING_ID WHERE B.USERNAME LIKE ? ";
		List list = new ArrayList<>();
		if (conn != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			try {
				PreparedStatement sm = conn.prepareStatement(sql);
				sm.setString(1, "%" + search + "%");
				ResultSet rs = sm.executeQuery();

				while (rs.next()) {
					BLL.Receipt receipt = new BLL.Receipt();
					receipt.setId(rs.getInt("RECEIPT_ID"));
					receipt.setCreated(formatter.format(rs.getDate("CREATED")));
					receipt.setBookingId(rs.getInt("BOOKING_ID"));
					receipt.setHours(rs.getDouble("TOTAL_HOURS"));
					receipt.setPayment(rs.getDouble("PAYMENT"));
					list.add(receipt);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Connect error!!!");
		}

		return list;
	}

	public Boolean createReceipt(BLL.Receipt receipt) {
		sql = "{CALL DEV.RECEIPT_PKG.INSERT_RECEIPT( ?, ?, ?, ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setString(1, receipt.getCreated());
				sm.setInt(2, receipt.getBookingId());
				sm.setDouble(3, receipt.getHours());
				sm.setDouble(4, receipt.getPayment());

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

	public Boolean deleteReceipt(BLL.Receipt receipt) {
		sql = "{CALL DEV.RECEIPT_PKG.DELETE_RECEIPT( ?)}";
		if (conn != null) {
			try {
				PreparedStatement sm = conn.prepareStatement(sql);

				sm.setInt(1, receipt.getId());

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
