/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.AES;
import BLL.DB;
import BLL.RSA;
import BLL.Receipt;
import com.amdelamar.jhash.Hash;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vogiadat
 */
public class MainFrame extends javax.swing.JFrame {

	/**
	 * Creates new form MainFrame
	 */
	private Connection conn;
	private final char[] pepper = "vogiadat".toCharArray();

	// Room
	private List<BLL.Room> listRoom = new ArrayList<>();
	private BLL.Room roomSelected = null;
	private final DAL.Room Room = new DAL.Room();

	private BLL.Room getInitRoom() {
		try {
			return new BLL.Room(
			Integer.parseInt(!booking_txtRoomId.getText().isEmpty() ? booking_txtRoomId.getText() : "-1"),
			booking_txtRoomName.getText().toUpperCase(),
			booking_txtRoomStatus.getSelectedItem().toString(),
			Double.parseDouble(booking_txtPrice.getText()),
			"",
			"");
		} catch (NumberFormatException e) {
			return null;
		}
	}

	// Booking
	private List<BLL.Booking> listBooking = new ArrayList<>();
	private List<BLL.Booking> userBooking = new ArrayList<>();
	private BLL.Booking bookingSelected = null;
	private final DAL.Booking Booking = new DAL.Booking();
	private String filterBooking = "";

	// Infor 
	private List<BLL.Infor> listInfor = new ArrayList<>();
	private BLL.Infor initUser = null;
	private DAL.Infor Infor = new DAL.Infor();

	// User
	private List<BLL.User> listUser = new ArrayList<>();
	private BLL.User userSelected = null;
	private DAL.User User = new DAL.User();

//	private BLL.User getInitUser() {
//		try {
//			int selectedRow = user_list.getSelectedRow();
//			int id = (int) user_list.getValueAt(selectedRow, 0);
//			return listUser.stream().filter(user -> user.getUser()== id).findFirst().get();
//		} catch (Exception e) {
//			return null;
//		}
//	}
	// Receipt
	private List<BLL.Receipt> listReceipt = new ArrayList<>();
	private BLL.Receipt receiptSelected = null;
	private DAL.Receipt Receipt = new DAL.Receipt();

	// ==================================================================================
	// ==================================================================================
	CardLayout cardLayout;

	public MainFrame() {
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
		cardLayout = (CardLayout) (panel_content.getLayout());
		initData();
	}

	private void initData() {
		// Booking Room
		listRoom = Room.getAllRoom(!"".equals(booking_txtSearch.getText()) ? booking_txtSearch.getText().toUpperCase() : room_txtSearch.getText().toUpperCase());
		DefaultTableModel model = (DefaultTableModel) booking_listRoom.getModel();
		model.setRowCount(0);
		for (BLL.Room room : listRoom) {
			model.addRow(new Object[]{
				room.getId(),
				room.getName().toUpperCase(),
				room.getPrice(),
				room.getStatus()});
		}

		// Room
		model = (DefaultTableModel) room_listRoom.getModel();
		model.setRowCount(0);
		for (BLL.Room room : listRoom) {
			model.addRow(new Object[]{
				room.getId(),
				room.getName().toUpperCase()
			});
		}

		// List Booking of user
		userBooking = Booking.getAllBooking(DB.user.toUpperCase(), filterBooking);
		model = (DefaultTableModel) infor_listBooking.getModel();
		model.setRowCount(0);
		for (BLL.Booking booking : userBooking) {
			model.addRow(new Object[]{
				booking.getId(),
				booking.getName(),
				booking.getRoomName(),
				booking.getRoomKey(),
				booking.getHours(),
				booking.getStatus()
			});
		}
		// Infor
		listInfor = Infor.getAllInfor("");
		model = (DefaultTableModel) user_list.getModel();
		model.setRowCount(0);
		for (BLL.Infor user : listInfor) {
			model.addRow(new Object[]{
				user.getId(),
				user.getUsername(),
				user.getEmail()});
		}

		// User
//		model = (DefaultTableModel) .getModel();
//		model.setRowCount(0);
//		for (BLL.User user : users) {
//			model.addRow(new Object[]{
//				user.getId(),
//				user.getUsername(),
//				user.getEmail(),
//				user.getRole_name()});
//		}
//		model = (DefaultTableModel) .getModel();
//		model.setRowCount(0);
		// Receipt 
		listReceipt = Receipt.getAllReceipt(DB.isUser ? DB.user.toUpperCase() : "");
		model = (DefaultTableModel) receipt_list.getModel();
		model.setRowCount(0);
		for (BLL.Receipt receipt : listReceipt) {
			model.addRow(new Object[]{
				receipt.getId(),
				receipt.getCreated(),
				receipt.getBookingId(),
				receipt.getHours(),
				receipt.getPayment()
			});
		}

	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panel_main = new javax.swing.JLayeredPane();
                home_btnClose = new javax.swing.JButton();
                panel_sidebar = new javax.swing.JLayeredPane();
                sidebar_home = new javax.swing.JPanel();
                sidebar_lbHome = new javax.swing.JLabel();
                sidebar_booking = new javax.swing.JPanel();
                sidebar_lbBooking = new javax.swing.JLabel();
                sidebar_room = new javax.swing.JPanel();
                sidebar_lbRoom = new javax.swing.JLabel();
                sidebar_staff = new javax.swing.JPanel();
                sidebar_lbStaff = new javax.swing.JLabel();
                sidebar_receipt = new javax.swing.JPanel();
                sidebar_lbReceipt = new javax.swing.JLabel();
                sidebar_sepSidabar = new javax.swing.JSeparator();
                sidebar_information = new javax.swing.JPanel();
                sidebar_lbInformation = new javax.swing.JLabel();
                sidebar_logout = new javax.swing.JPanel();
                sidebar_lbLogout = new javax.swing.JLabel();
                panel_content = new javax.swing.JLayeredPane();
                content_home = new javax.swing.JPanel();
                home_lbHome = new javax.swing.JLabel();
                content_booking = new javax.swing.JPanel();
                booking_lbBooking = new javax.swing.JLabel();
                booking_section = new javax.swing.JSplitPane();
                booking_table = new javax.swing.JScrollPane();
                booking_listRoom = new javax.swing.JTable();
                booking_infor = new javax.swing.JPanel();
                booking_lbInfor = new javax.swing.JLabel();
                booking_sepInfor = new javax.swing.JSeparator();
                booking_txtSearch = new javax.swing.JTextField();
                booking_sepSearch = new javax.swing.JSeparator();
                booking_txtRoomId = new javax.swing.JTextField();
                booking_txtRoomName = new javax.swing.JTextField();
                booking_txtPrice = new javax.swing.JTextField();
                booking_searchActions = new javax.swing.JPanel();
                booking_btnRefresh = new javax.swing.JButton();
                booking_btnSearch = new javax.swing.JButton();
                booking_txtRoomStatus = new javax.swing.JComboBox<>();
                booking_actions = new javax.swing.JPanel();
                booking_staff = new javax.swing.JPanel();
                booking_btnAdd = new javax.swing.JButton();
                booking_btnUpdate = new javax.swing.JButton();
                booking_btnDelete = new javax.swing.JButton();
                booking_txtHours = new javax.swing.JTextField();
                booking_btnBooking = new javax.swing.JButton();
                content_room = new javax.swing.JPanel();
                room_lbRoom = new javax.swing.JLabel();
                room_section = new javax.swing.JSplitPane();
                room_table = new javax.swing.JScrollPane();
                room_listRoom = new javax.swing.JTable();
                room_infor = new javax.swing.JPanel();
                room_lbInfor = new javax.swing.JLabel();
                room_sepInfor = new javax.swing.JSeparator();
                room_txtSearch = new javax.swing.JTextField();
                room_searchActions = new javax.swing.JPanel();
                room_btnRefresh = new javax.swing.JButton();
                room_btnSearch = new javax.swing.JButton();
                room_sepSearch = new javax.swing.JSeparator();
                room_txtRoomId = new javax.swing.JTextField();
                room_txtRoomName = new javax.swing.JTextField();
                room_fieldKey = new javax.swing.JScrollPane();
                room_txtKey = new javax.swing.JTextArea();
                room_actions = new javax.swing.JPanel();
                room_btnCheckIn = new javax.swing.JButton();
                room_btnCheckOut = new javax.swing.JButton();
                content_receipt = new javax.swing.JPanel();
                receipt_lbReceipt = new javax.swing.JLabel();
                receipt_section = new javax.swing.JSplitPane();
                receipt_table = new javax.swing.JScrollPane();
                receipt_list = new javax.swing.JTable();
                receipt_infor = new javax.swing.JPanel();
                receipt_lbInfor = new javax.swing.JLabel();
                receipt_sepInfor = new javax.swing.JSeparator();
                receipt_txtSearch = new javax.swing.JTextField();
                receipt_searchActions = new javax.swing.JPanel();
                receipt_btnRefresh = new javax.swing.JButton();
                receipt_btnSearch = new javax.swing.JButton();
                receipt_sepSearch = new javax.swing.JSeparator();
                receipt_txtReciptId = new javax.swing.JTextField();
                receipt_txtCreated = new javax.swing.JTextField();
                receipt_txtBookingId = new javax.swing.JTextField();
                receipt_txtHours = new javax.swing.JTextField();
                receipt_txtPayment = new javax.swing.JTextField();
                content_user = new javax.swing.JPanel();
                user_lbUser = new javax.swing.JLabel();
                user_section = new javax.swing.JSplitPane();
                user_table = new javax.swing.JScrollPane();
                user_list = new javax.swing.JTable();
                user_infor = new javax.swing.JPanel();
                user_lbInfor = new javax.swing.JLabel();
                user_sepInfor = new javax.swing.JSeparator();
                user_txtSearch = new javax.swing.JTextField();
                user_sepSearch = new javax.swing.JSeparator();
                user_searchActions = new javax.swing.JPanel();
                user_btnRefresh = new javax.swing.JButton();
                user_btnSearch = new javax.swing.JButton();
                user_txtEmail = new javax.swing.JTextField();
                user_actions = new javax.swing.JPanel();
                user_btnAdd = new javax.swing.JButton();
                user_btnDelete = new javax.swing.JButton();
                user_txtRole = new javax.swing.JComboBox<>();
                user_txtUsername = new javax.swing.JTextField();
                user_txtPassword = new javax.swing.JPasswordField();
                content_information = new javax.swing.JPanel();
                infor_lbInfor = new javax.swing.JLabel();
                panel_information = new javax.swing.JPanel();
                infor_txtUser = new javax.swing.JTextField();
                infor_txtEmail = new javax.swing.JTextField();
                infor_txtPassword = new javax.swing.JPasswordField();
                infor_btnUpdate = new javax.swing.JButton();
                infor_sepUser = new javax.swing.JSeparator();
                panel_history = new javax.swing.JPanel();
                infor_txtBookingStatus = new javax.swing.JComboBox<>();
                infor_btnRefresh = new javax.swing.JButton();
                infor_table = new javax.swing.JScrollPane();
                infor_listBooking = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(133, 212, 241));
                setUndecorated(true);

                panel_main.setBackground(new java.awt.Color(255, 255, 255));
                panel_main.setOpaque(true);

                home_btnClose.setBackground(new java.awt.Color(255, 0, 0));
                home_btnClose.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
                home_btnClose.setForeground(new java.awt.Color(255, 255, 255));
                home_btnClose.setText("X");
                home_btnClose.setAlignmentY(0.0F);
                home_btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                home_btnClose.setMargin(new java.awt.Insets(0, 0, 0, 0));
                home_btnClose.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                home_btnCloseActionPerformed(evt);
                        }
                });

                panel_sidebar.setBackground(new java.awt.Color(25, 118, 211));
                panel_sidebar.setOpaque(true);
                panel_sidebar.setPreferredSize(new java.awt.Dimension(300, 300));

                sidebar_home.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_home.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_home.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_homeMousePressed(evt);
                        }
                });

                sidebar_lbHome.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbHome.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbHome.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbHome.setText("HOME");

                javax.swing.GroupLayout sidebar_homeLayout = new javax.swing.GroupLayout(sidebar_home);
                sidebar_home.setLayout(sidebar_homeLayout);
                sidebar_homeLayout.setHorizontalGroup(
                        sidebar_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_homeLayout.setVerticalGroup(
                        sidebar_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_booking.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_booking.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_booking.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_booking.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_bookingMousePressed(evt);
                        }
                });

                sidebar_lbBooking.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbBooking.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbBooking.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbBooking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbBooking.setText(DB.isUser ? "BOOKING" : "ROOM");

                javax.swing.GroupLayout sidebar_bookingLayout = new javax.swing.GroupLayout(sidebar_booking);
                sidebar_booking.setLayout(sidebar_bookingLayout);
                sidebar_bookingLayout.setHorizontalGroup(
                        sidebar_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbBooking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_bookingLayout.setVerticalGroup(
                        sidebar_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbBooking, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_room.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_room.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_room.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_room.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_roomMousePressed(evt);
                        }
                });

                sidebar_lbRoom.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbRoom.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbRoom.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbRoom.setText("ROOM");

                javax.swing.GroupLayout sidebar_roomLayout = new javax.swing.GroupLayout(sidebar_room);
                sidebar_room.setLayout(sidebar_roomLayout);
                sidebar_roomLayout.setHorizontalGroup(
                        sidebar_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_roomLayout.setVerticalGroup(
                        sidebar_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_staff.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_staff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_staff.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_staff.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_staffMousePressed(evt);
                        }
                });

                sidebar_lbStaff.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbStaff.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbStaff.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbStaff.setText("USER");

                javax.swing.GroupLayout sidebar_staffLayout = new javax.swing.GroupLayout(sidebar_staff);
                sidebar_staff.setLayout(sidebar_staffLayout);
                sidebar_staffLayout.setHorizontalGroup(
                        sidebar_staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                sidebar_staffLayout.setVerticalGroup(
                        sidebar_staffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_receipt.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_receipt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_receipt.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_receipt.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_receiptMousePressed(evt);
                        }
                });

                sidebar_lbReceipt.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbReceipt.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbReceipt.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbReceipt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbReceipt.setText("RECEIPT");

                javax.swing.GroupLayout sidebar_receiptLayout = new javax.swing.GroupLayout(sidebar_receipt);
                sidebar_receipt.setLayout(sidebar_receiptLayout);
                sidebar_receiptLayout.setHorizontalGroup(
                        sidebar_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbReceipt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_receiptLayout.setVerticalGroup(
                        sidebar_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbReceipt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_sepSidabar.setBackground(new java.awt.Color(255, 255, 255));
                sidebar_sepSidabar.setForeground(new java.awt.Color(255, 255, 255));

                sidebar_information.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_information.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_information.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_information.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_informationMousePressed(evt);
                        }
                });

                sidebar_lbInformation.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbInformation.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbInformation.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbInformation.setText("INFORMATION");

                javax.swing.GroupLayout sidebar_informationLayout = new javax.swing.GroupLayout(sidebar_information);
                sidebar_information.setLayout(sidebar_informationLayout);
                sidebar_informationLayout.setHorizontalGroup(
                        sidebar_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_informationLayout.setVerticalGroup(
                        sidebar_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                sidebar_logout.setBackground(new java.awt.Color(25, 118, 211));
                sidebar_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                sidebar_logout.setPreferredSize(new java.awt.Dimension(0, 80));
                sidebar_logout.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                sidebar_logoutMousePressed(evt);
                        }
                });

                sidebar_lbLogout.setBackground(new java.awt.Color(133, 212, 241));
                sidebar_lbLogout.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                sidebar_lbLogout.setForeground(new java.awt.Color(255, 255, 255));
                sidebar_lbLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                sidebar_lbLogout.setText("LOGOUT");

                javax.swing.GroupLayout sidebar_logoutLayout = new javax.swing.GroupLayout(sidebar_logout);
                sidebar_logout.setLayout(sidebar_logoutLayout);
                sidebar_logoutLayout.setHorizontalGroup(
                        sidebar_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                );
                sidebar_logoutLayout.setVerticalGroup(
                        sidebar_logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_lbLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                );

                panel_sidebar.setLayer(sidebar_home, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_booking, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_room, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_staff, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_receipt, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_sepSidabar, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_information, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_sidebar.setLayer(sidebar_logout, javax.swing.JLayeredPane.DEFAULT_LAYER);

                javax.swing.GroupLayout panel_sidebarLayout = new javax.swing.GroupLayout(panel_sidebar);
                panel_sidebar.setLayout(panel_sidebarLayout);
                panel_sidebarLayout.setHorizontalGroup(
                        panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar_home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(sidebar_sepSidabar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_booking, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_room, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_receipt, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_staff, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_logout, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(sidebar_information, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)))
                );
                panel_sidebarLayout.setVerticalGroup(
                        panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_sidebarLayout.createSequentialGroup()
                                .addComponent(sidebar_home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sidebar_sepSidabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addComponent(sidebar_booking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(sidebar_room, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(sidebar_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_sidebarLayout.createSequentialGroup()
                                        .addGap(160, 160, 160)
                                        .addComponent(sidebar_staff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_sidebarLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sidebar_logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)))
                        .addGroup(panel_sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_sidebarLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sidebar_information, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)))
                );

                panel_content.setBackground(new java.awt.Color(204, 255, 255));
                panel_content.setOpaque(true);
                panel_content.setLayout(new java.awt.CardLayout());

                content_home.setBackground(new java.awt.Color(204, 255, 255));

                home_lbHome.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                home_lbHome.setForeground(new java.awt.Color(25, 118, 211));
                home_lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                home_lbHome.setText("Quản Lý Khách Sạn");
                home_lbHome.setAlignmentX(0.5F);

                javax.swing.GroupLayout content_homeLayout = new javax.swing.GroupLayout(content_home);
                content_home.setLayout(content_homeLayout);
                content_homeLayout.setHorizontalGroup(
                        content_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_homeLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(home_lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                                .addGap(93, 93, 93))
                );
                content_homeLayout.setVerticalGroup(
                        content_homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_homeLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(home_lbHome, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                                .addGap(174, 174, 174))
                );

                panel_content.add(content_home, "content_home");

                content_booking.setBackground(new java.awt.Color(204, 255, 255));

                booking_lbBooking.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                booking_lbBooking.setForeground(new java.awt.Color(25, 118, 211));
                booking_lbBooking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                booking_lbBooking.setText("Booking");
                booking_lbBooking.setAlignmentX(0.5F);

                booking_section.setBackground(new java.awt.Color(255, 255, 255));

                booking_table.setBackground(new java.awt.Color(255, 255, 255));
                booking_table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

                booking_listRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                booking_listRoom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
                booking_listRoom.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null},
                                {null, null, null, null}
                        },
                        new String [] {
                                "Room ID", "Name", "Price", "Status"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                booking_listRoom.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                booking_listRoomMousePressed(evt);
                        }
                });
                booking_table.setViewportView(booking_listRoom);

                booking_section.setLeftComponent(booking_table);

                booking_infor.setBackground(new java.awt.Color(255, 255, 255));
                booking_infor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                booking_infor.setPreferredSize(new java.awt.Dimension(300, 136));

                booking_lbInfor.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
                booking_lbInfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                booking_lbInfor.setText("Information Room");

                booking_txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtSearch.setPreferredSize(new java.awt.Dimension(64, 30));

                booking_txtRoomId.setEditable(false);
                booking_txtRoomId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtRoomId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                booking_txtRoomName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtRoomName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                booking_txtPrice.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtPrice.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Price", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                booking_searchActions.setBackground(new java.awt.Color(255, 255, 255));
                booking_searchActions.setPreferredSize(new java.awt.Dimension(100, 30));
                booking_searchActions.setLayout(new java.awt.GridLayout(1, 0));

                booking_btnRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                booking_btnRefresh.setText("Refresh");
                booking_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnRefreshActionPerformed(evt);
                        }
                });
                booking_searchActions.add(booking_btnRefresh);

                booking_btnSearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                booking_btnSearch.setText("Search");
                booking_btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnSearchActionPerformed(evt);
                        }
                });
                booking_searchActions.add(booking_btnSearch);

                booking_txtRoomStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtRoomStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empty", "Booked" }));
                booking_txtRoomStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                booking_actions.setBackground(new java.awt.Color(255, 255, 255));
                booking_actions.setPreferredSize(new java.awt.Dimension(100, 30));
                booking_actions.setLayout(new java.awt.CardLayout());

                booking_staff.setBackground(new java.awt.Color(255, 255, 255));
                booking_staff.setPreferredSize(new java.awt.Dimension(100, 30));
                booking_staff.setLayout(new java.awt.GridLayout(1, 0));

                booking_btnAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                booking_btnAdd.setText("Add");
                booking_btnAdd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnAddActionPerformed(evt);
                        }
                });
                booking_staff.add(booking_btnAdd);

                booking_btnUpdate.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                booking_btnUpdate.setText("Update");
                booking_btnUpdate.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnUpdateActionPerformed(evt);
                        }
                });
                booking_staff.add(booking_btnUpdate);

                booking_btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                booking_btnDelete.setText("Delete");
                booking_btnDelete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnDeleteActionPerformed(evt);
                        }
                });
                booking_staff.add(booking_btnDelete);

                booking_actions.add(booking_staff, "card2");
                if(DB.isUser) {
                        booking_actions.setVisible(false);
                        booking_btnBooking.setVisible(true);
                } else {
                        booking_btnBooking.setVisible(false);
                        booking_actions.setVisible(true);
                }

                booking_txtHours.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                booking_txtHours.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hours", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                booking_btnBooking.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                booking_btnBooking.setText("Booking");
                booking_btnBooking.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                booking_btnBookingActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout booking_inforLayout = new javax.swing.GroupLayout(booking_infor);
                booking_infor.setLayout(booking_inforLayout);
                booking_inforLayout.setHorizontalGroup(
                        booking_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(booking_sepInfor)
                        .addGroup(booking_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(booking_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(booking_lbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addComponent(booking_sepSearch)
                                        .addComponent(booking_txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(booking_searchActions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(booking_actions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(booking_txtRoomId, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(booking_txtRoomStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(booking_txtHours)
                                        .addComponent(booking_txtRoomName, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(booking_txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(booking_btnBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                );
                booking_inforLayout.setVerticalGroup(
                        booking_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(booking_inforLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(booking_lbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking_sepInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(booking_txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking_searchActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking_sepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking_txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booking_txtRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booking_txtRoomStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booking_txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(booking_txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(booking_btnBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(booking_actions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                );

                if (DB.isUser) {
                        booking_txtHours.setVisible(true);
                } else {
                        booking_txtHours.setVisible(false);
                }

                booking_section.setRightComponent(booking_infor);

                javax.swing.GroupLayout content_bookingLayout = new javax.swing.GroupLayout(content_booking);
                content_booking.setLayout(content_bookingLayout);
                content_bookingLayout.setHorizontalGroup(
                        content_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_bookingLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(content_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_bookingLayout.createSequentialGroup()
                                                .addComponent(booking_lbBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(content_bookingLayout.createSequentialGroup()
                                                .addComponent(booking_section, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addGap(5, 5, 5))))
                );
                content_bookingLayout.setVerticalGroup(
                        content_bookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_bookingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(booking_lbBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(booking_section, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                );

                panel_content.add(content_booking, "content_booking");

                content_room.setBackground(new java.awt.Color(204, 255, 255));

                room_lbRoom.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                room_lbRoom.setForeground(new java.awt.Color(25, 118, 211));
                room_lbRoom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                room_lbRoom.setText("Room");
                room_lbRoom.setAlignmentX(0.5F);

                room_section.setBackground(new java.awt.Color(255, 255, 255));

                room_table.setBackground(new java.awt.Color(255, 255, 255));
                room_table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

                room_listRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                room_listRoom.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
                room_listRoom.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null}
                        },
                        new String [] {
                                "Room ID", "Name"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                room_listRoom.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                room_listRoomMousePressed(evt);
                        }
                });
                room_table.setViewportView(room_listRoom);

                room_section.setLeftComponent(room_table);

                room_infor.setBackground(new java.awt.Color(255, 255, 255));
                room_infor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                room_infor.setPreferredSize(new java.awt.Dimension(300, 136));

                room_lbInfor.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
                room_lbInfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                room_lbInfor.setText("Information Room");

                room_txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                room_txtSearch.setPreferredSize(new java.awt.Dimension(64, 30));

                room_searchActions.setPreferredSize(new java.awt.Dimension(152, 30));
                room_searchActions.setLayout(new java.awt.GridLayout(1, 0));

                room_btnRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                room_btnRefresh.setText("Refresh");
                room_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                room_btnRefreshActionPerformed(evt);
                        }
                });
                room_searchActions.add(room_btnRefresh);

                room_btnSearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                room_btnSearch.setText("Search");
                room_btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                room_btnSearchActionPerformed(evt);
                        }
                });
                room_searchActions.add(room_btnSearch);

                room_txtRoomId.setEditable(false);
                room_txtRoomId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                room_txtRoomId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Room Id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                room_txtRoomName.setEditable(false);
                room_txtRoomName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                room_txtRoomName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                room_fieldKey.setBorder(null);

                room_txtKey.setColumns(20);
                room_txtKey.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                room_txtKey.setRows(8);
                room_txtKey.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Key", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
                room_fieldKey.setViewportView(room_txtKey);

                room_actions.setBackground(new java.awt.Color(255, 255, 255));
                room_actions.setName("room_actions"); // NOI18N
                room_actions.setPreferredSize(new java.awt.Dimension(88, 30));
                room_actions.setLayout(new java.awt.CardLayout());

                room_btnCheckIn.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                room_btnCheckIn.setText("Check-in");
                room_btnCheckIn.setName("checkIn"); // NOI18N
                room_btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                room_btnCheckInActionPerformed(evt);
                        }
                });
                room_actions.add(room_btnCheckIn, "checkIn");
                room_btnCheckIn.getAccessibleContext().setAccessibleName("checkIn");

                room_btnCheckOut.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                room_btnCheckOut.setText("Check-out");
                room_btnCheckOut.setName("checkOut"); // NOI18N
                room_btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                room_btnCheckOutActionPerformed(evt);
                        }
                });
                room_actions.add(room_btnCheckOut, "checkOut");
                room_btnCheckOut.getAccessibleContext().setAccessibleName("checkOut");

                javax.swing.GroupLayout room_inforLayout = new javax.swing.GroupLayout(room_infor);
                room_infor.setLayout(room_inforLayout);
                room_inforLayout.setHorizontalGroup(
                        room_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(room_sepInfor)
                        .addComponent(room_sepSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(room_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(room_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(room_lbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addComponent(room_txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(room_actions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(room_txtRoomName)
                                        .addComponent(room_fieldKey)
                                        .addComponent(room_searchActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(room_txtRoomId))
                                .addGap(5, 5, 5))
                );
                room_inforLayout.setVerticalGroup(
                        room_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(room_inforLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(room_lbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(room_sepInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(room_txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(room_searchActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(room_sepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(room_txtRoomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(room_txtRoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(room_fieldKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                                .addComponent(room_actions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                );

                room_actions.getAccessibleContext().setAccessibleName("room_actions");

                room_section.setRightComponent(room_infor);

                javax.swing.GroupLayout content_roomLayout = new javax.swing.GroupLayout(content_room);
                content_room.setLayout(content_roomLayout);
                content_roomLayout.setHorizontalGroup(
                        content_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_roomLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(room_lbRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(content_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_roomLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(room_section, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );
                content_roomLayout.setVerticalGroup(
                        content_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_roomLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(room_lbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(648, Short.MAX_VALUE))
                        .addGroup(content_roomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_roomLayout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(room_section, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );

                panel_content.add(content_room, "content_room");

                content_receipt.setBackground(new java.awt.Color(204, 255, 255));

                receipt_lbReceipt.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                receipt_lbReceipt.setForeground(new java.awt.Color(25, 118, 211));
                receipt_lbReceipt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                receipt_lbReceipt.setText("Receipt");
                receipt_lbReceipt.setAlignmentX(0.5F);

                receipt_section.setBackground(new java.awt.Color(255, 255, 255));

                receipt_table.setBackground(new java.awt.Color(255, 255, 255));
                receipt_table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

                receipt_list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                receipt_list.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
                receipt_list.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null},
                                {null, null, null, null, null}
                        },
                        new String [] {
                                "Receipt ID", "Created", "Booking Id", "Total Hours", "Payment"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                receipt_list.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                receipt_listMousePressed(evt);
                        }
                });
                receipt_table.setViewportView(receipt_list);

                receipt_section.setLeftComponent(receipt_table);

                receipt_infor.setBackground(new java.awt.Color(255, 255, 255));
                receipt_infor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                receipt_infor.setPreferredSize(new java.awt.Dimension(300, 136));

                receipt_lbInfor.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
                receipt_lbInfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                receipt_lbInfor.setText("Information Receipt");

                receipt_txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtSearch.setPreferredSize(new java.awt.Dimension(64, 30));

                receipt_searchActions.setPreferredSize(new java.awt.Dimension(152, 30));
                receipt_searchActions.setLayout(new java.awt.GridLayout(1, 0));

                receipt_btnRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                receipt_btnRefresh.setText("Refresh");
                receipt_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                receipt_btnRefreshActionPerformed(evt);
                        }
                });
                receipt_searchActions.add(receipt_btnRefresh);

                receipt_btnSearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                receipt_btnSearch.setText("Search");
                receipt_btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                receipt_btnSearchActionPerformed(evt);
                        }
                });
                receipt_searchActions.add(receipt_btnSearch);

                receipt_txtReciptId.setEditable(false);
                receipt_txtReciptId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtReciptId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Receipt Id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                receipt_txtCreated.setEditable(false);
                receipt_txtCreated.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtCreated.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Created", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                receipt_txtBookingId.setEditable(false);
                receipt_txtBookingId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtBookingId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Booking Id", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                receipt_txtHours.setEditable(false);
                receipt_txtHours.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtHours.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total Hours", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                receipt_txtPayment.setEditable(false);
                receipt_txtPayment.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                receipt_txtPayment.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                javax.swing.GroupLayout receipt_inforLayout = new javax.swing.GroupLayout(receipt_infor);
                receipt_infor.setLayout(receipt_inforLayout);
                receipt_inforLayout.setHorizontalGroup(
                        receipt_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(receipt_sepInfor)
                        .addComponent(receipt_sepSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(receipt_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(receipt_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(receipt_lbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                        .addComponent(receipt_txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(receipt_txtCreated)
                                        .addComponent(receipt_txtReciptId, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(receipt_searchActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(receipt_txtBookingId)
                                        .addComponent(receipt_txtHours)
                                        .addComponent(receipt_txtPayment))
                                .addGap(5, 5, 5))
                );
                receipt_inforLayout.setVerticalGroup(
                        receipt_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(receipt_inforLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(receipt_lbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receipt_sepInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receipt_txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receipt_searchActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receipt_sepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receipt_txtReciptId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(receipt_txtCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(receipt_txtBookingId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(receipt_txtHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(receipt_txtPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(256, Short.MAX_VALUE))
                );

                receipt_section.setRightComponent(receipt_infor);

                javax.swing.GroupLayout content_receiptLayout = new javax.swing.GroupLayout(content_receipt);
                content_receipt.setLayout(content_receiptLayout);
                content_receiptLayout.setHorizontalGroup(
                        content_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, content_receiptLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(receipt_lbReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(content_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_receiptLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(receipt_section, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );
                content_receiptLayout.setVerticalGroup(
                        content_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_receiptLayout.createSequentialGroup()
                                .addComponent(receipt_lbReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 654, Short.MAX_VALUE))
                        .addGroup(content_receiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_receiptLayout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(receipt_section, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );

                panel_content.add(content_receipt, "content_receipt");

                content_user.setBackground(new java.awt.Color(204, 255, 255));

                user_lbUser.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                user_lbUser.setForeground(new java.awt.Color(25, 118, 211));
                user_lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                user_lbUser.setText("User");
                user_lbUser.setAlignmentX(0.5F);

                user_section.setBackground(new java.awt.Color(255, 255, 255));

                user_table.setBackground(new java.awt.Color(255, 255, 255));
                user_table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

                user_list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                user_list.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
                user_list.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        new String [] {
                                "User ID", "Username", "Email"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                user_list.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                user_listMousePressed(evt);
                        }
                });
                user_table.setViewportView(user_list);

                user_section.setLeftComponent(user_table);

                user_infor.setBackground(new java.awt.Color(255, 255, 255));
                user_infor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                user_infor.setPreferredSize(new java.awt.Dimension(300, 136));

                user_lbInfor.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
                user_lbInfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                user_lbInfor.setText("Information User");

                user_txtSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                user_txtSearch.setPreferredSize(new java.awt.Dimension(64, 30));

                user_searchActions.setBackground(new java.awt.Color(255, 255, 255));
                user_searchActions.setPreferredSize(new java.awt.Dimension(100, 30));
                user_searchActions.setLayout(new java.awt.GridLayout(1, 0));

                user_btnRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                user_btnRefresh.setText("Refresh");
                user_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                user_btnRefreshActionPerformed(evt);
                        }
                });
                user_searchActions.add(user_btnRefresh);

                user_btnSearch.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                user_btnSearch.setText("Search");
                user_btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                user_btnSearchActionPerformed(evt);
                        }
                });
                user_searchActions.add(user_btnSearch);

                user_txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                user_txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                user_actions.setBackground(new java.awt.Color(255, 255, 255));
                user_actions.setPreferredSize(new java.awt.Dimension(100, 30));
                user_actions.setLayout(new java.awt.GridLayout(1, 0));

                user_btnAdd.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                user_btnAdd.setText("Add ");
                user_btnAdd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                user_btnAddActionPerformed(evt);
                        }
                });
                user_actions.add(user_btnAdd);

                user_btnDelete.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                user_btnDelete.setText("Detele");
                user_btnDelete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                user_btnDeleteActionPerformed(evt);
                        }
                });
                user_actions.add(user_btnDelete);

                user_txtRole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                user_txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "MANAGER" }));
                user_txtRole.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                user_txtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                user_txtUsername.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                user_txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                user_txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                javax.swing.GroupLayout user_inforLayout = new javax.swing.GroupLayout(user_infor);
                user_infor.setLayout(user_inforLayout);
                user_inforLayout.setHorizontalGroup(
                        user_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(user_sepInfor)
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(user_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(user_lbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
                                        .addComponent(user_sepSearch)
                                        .addComponent(user_txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(user_searchActions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(user_txtUsername)
                                .addGap(5, 5, 5))
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(user_txtEmail)
                                .addGap(5, 5, 5))
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(user_txtPassword)
                                .addGap(5, 5, 5))
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(user_txtRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                        .addGroup(user_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(user_inforLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(user_actions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );
                user_inforLayout.setVerticalGroup(
                        user_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(user_inforLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(user_lbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user_sepInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(user_txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user_searchActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user_sepSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user_txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(user_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(user_txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(user_txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(user_inforLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_inforLayout.createSequentialGroup()
                                        .addContainerGap(611, Short.MAX_VALUE)
                                        .addComponent(user_actions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                );

                user_actions.setVisible((DB.user.equalsIgnoreCase("DEV") || DB.user.equalsIgnoreCase("SYS") )? true: false);
                user_txtRole.setVisible((DB.user.equalsIgnoreCase("DEV") || DB.user.equalsIgnoreCase("SYS") )? true: false);

                user_section.setRightComponent(user_infor);

                javax.swing.GroupLayout content_userLayout = new javax.swing.GroupLayout(content_user);
                content_user.setLayout(content_userLayout);
                content_userLayout.setHorizontalGroup(
                        content_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(user_lbUser, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                        .addGroup(content_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_userLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(user_section, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );
                content_userLayout.setVerticalGroup(
                        content_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_userLayout.createSequentialGroup()
                                .addComponent(user_lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 653, Short.MAX_VALUE))
                        .addGroup(content_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(content_userLayout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(user_section, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );

                panel_content.add(content_user, "content_staff");

                content_information.setBackground(new java.awt.Color(204, 255, 255));

                infor_lbInfor.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
                infor_lbInfor.setForeground(new java.awt.Color(25, 118, 211));
                infor_lbInfor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                infor_lbInfor.setText("Information");
                infor_lbInfor.setAlignmentX(0.5F);

                panel_information.setBackground(new java.awt.Color(255, 255, 255));

                infor_txtUser.setEditable(false);
                infor_txtUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                infor_txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                infor_txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                infor_txtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                infor_txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                infor_txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                infor_btnUpdate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                infor_btnUpdate.setText("Update");
                infor_btnUpdate.setToolTipText("");
                infor_btnUpdate.setPreferredSize(new java.awt.Dimension(75, 30));
                infor_btnUpdate.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                infor_btnUpdateActionPerformed(evt);
                        }
                });

                panel_history.setBackground(new java.awt.Color(255, 255, 255));

                infor_txtBookingStatus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                infor_txtBookingStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pending", "CheckIn", "CheckOut" }));
                infor_txtBookingStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

                infor_btnRefresh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
                infor_btnRefresh.setText("Refresh");
                infor_btnRefresh.setPreferredSize(new java.awt.Dimension(80, 42));
                infor_btnRefresh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                infor_btnRefreshActionPerformed(evt);
                        }
                });

                infor_table.setBackground(new java.awt.Color(255, 255, 255));
                infor_table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

                infor_listBooking.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                infor_listBooking.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
                infor_listBooking.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                        },
                        new String [] {
                                "Booking ID", "Booking Name", "Room", "Room Key", "Booking Hours", "Status"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false, true, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                infor_listBooking.setInheritsPopupMenu(true);
                infor_table.setViewportView(infor_listBooking);

                javax.swing.GroupLayout panel_historyLayout = new javax.swing.GroupLayout(panel_history);
                panel_history.setLayout(panel_historyLayout);
                panel_historyLayout.setHorizontalGroup(
                        panel_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_historyLayout.createSequentialGroup()
                                .addGroup(panel_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infor_table, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                                        .addGroup(panel_historyLayout.createSequentialGroup()
                                                .addComponent(infor_txtBookingStatus, 0, 545, Short.MAX_VALUE)
                                                .addGap(0, 0, 0)
                                                .addComponent(infor_btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, 0))
                );
                panel_historyLayout.setVerticalGroup(
                        panel_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_historyLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addGroup(panel_historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infor_txtBookingStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(infor_btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infor_table, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
                );

                javax.swing.GroupLayout panel_informationLayout = new javax.swing.GroupLayout(panel_information);
                panel_information.setLayout(panel_informationLayout);
                panel_informationLayout.setHorizontalGroup(
                        panel_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_informationLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panel_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infor_txtUser, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infor_txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infor_txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(infor_btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                        .addComponent(infor_sepUser)
                        .addGroup(panel_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_informationLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(panel_history, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );
                panel_informationLayout.setVerticalGroup(
                        panel_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel_informationLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(infor_txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(infor_txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(infor_txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(infor_btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infor_sepUser, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(405, Short.MAX_VALUE))
                        .addGroup(panel_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_informationLayout.createSequentialGroup()
                                        .addGap(225, 225, 225)
                                        .addComponent(panel_history, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                );

                infor_txtUser.setText(DB.user.toUpperCase());
                panel_history.setVisible((DB.isUser || DB.user.equalsIgnoreCase("DEV") || DB.user.equalsIgnoreCase("SYS")) ? true : false);

                javax.swing.GroupLayout content_informationLayout = new javax.swing.GroupLayout(content_information);
                content_information.setLayout(content_informationLayout);
                content_informationLayout.setHorizontalGroup(
                        content_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_informationLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(content_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infor_lbInfor, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
                                        .addComponent(panel_information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5))
                );
                content_informationLayout.setVerticalGroup(
                        content_informationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(content_informationLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(infor_lbInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel_information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
                );

                panel_content.add(content_information, "content_information");

                panel_main.setLayer(home_btnClose, javax.swing.JLayeredPane.DRAG_LAYER);
                panel_main.setLayer(panel_sidebar, javax.swing.JLayeredPane.DEFAULT_LAYER);
                panel_main.setLayer(panel_content, javax.swing.JLayeredPane.DEFAULT_LAYER);

                javax.swing.GroupLayout panel_mainLayout = new javax.swing.GroupLayout(panel_main);
                panel_main.setLayout(panel_mainLayout);
                panel_mainLayout.setHorizontalGroup(
                        panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_mainLayout.createSequentialGroup()
                                .addComponent(panel_sidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(panel_content))
                        .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_mainLayout.createSequentialGroup()
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(home_btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)))
                );
                panel_mainLayout.setVerticalGroup(
                        panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_content)
                        .addComponent(panel_sidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                        .addGroup(panel_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel_mainLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(home_btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
                );

                if (DB.isUser ) {
                        sidebar_staff.setVisible(false);
                        sidebar_room.setVisible(true);
                } else {
                        sidebar_staff.setVisible(true);
                        sidebar_room.setVisible(false);
                }

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_main)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel_main)
                );
        }// </editor-fold>//GEN-END:initComponents

        private void user_btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnDeleteActionPerformed
		String username = user_txtUsername.getText().toUpperCase();

		if (User.deleteUser(username)) {
			try {
				JOptionPane.showMessageDialog(rootPane, "Create success!!!");
			} catch (HeadlessException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
        }//GEN-LAST:event_user_btnDeleteActionPerformed

        private void user_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnAddActionPerformed
		String username = user_txtUsername.getText().toUpperCase();
		String password = user_txtPassword.getText().isBlank()? "1" : user_txtPassword.getText();
		String email = user_txtEmail.getText();
		String role = String.valueOf(user_txtRole.getSelectedItem());

		if (User.createUser(role, username, password, email)) {
			try {
				JOptionPane.showMessageDialog(rootPane, "Create success!!!");
			} catch (HeadlessException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
        }//GEN-LAST:event_user_btnAddActionPerformed

        private void user_btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnSearchActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_user_btnSearchActionPerformed

        private void user_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnRefreshActionPerformed
		this.initData();
        }//GEN-LAST:event_user_btnRefreshActionPerformed

        private void user_listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_listMousePressed
        }//GEN-LAST:event_user_listMousePressed

        private void receipt_btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_btnSearchActionPerformed
        }//GEN-LAST:event_receipt_btnSearchActionPerformed

        private void receipt_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receipt_btnRefreshActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_receipt_btnRefreshActionPerformed

        private void receipt_listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receipt_listMousePressed
		try {
			int selectedRow = receipt_list.getSelectedRow();
			int id = (int) receipt_list.getValueAt(selectedRow, 0);
			receiptSelected = listReceipt.stream().filter(r -> r.getId() == id).findFirst().get();

			receipt_txtReciptId.setText(String.valueOf(receiptSelected.getId()));
			receipt_txtCreated.setText(receiptSelected.getCreated());
			receipt_txtBookingId.setText(String.valueOf(receiptSelected.getBookingId()));
			receipt_txtHours.setText(String.valueOf(receiptSelected.getHours()));
			receipt_txtPayment.setText(String.valueOf(receiptSelected.getPayment()));
		} catch (Exception e) {
			receiptSelected = null;
		}
        }//GEN-LAST:event_receipt_listMousePressed

        private void room_btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_btnCheckOutActionPerformed
		CardLayout btnAction = (CardLayout) (room_actions.getLayout());
		int roomId = Integer.parseInt(room_txtRoomId.getText());
		roomSelected = listRoom.stream().filter(r -> r.getId() == roomId).findFirst().get();
		BLL.Booking booking = userBooking.stream().filter(b -> b.getRoomKey().equals(room_txtKey.getText())).findFirst().get();

		roomSelected.setPubKey("");
		roomSelected.setPriKey("");
		roomSelected.setStatus("Empty");
		booking.setStatus("CheckOut");

		if (Room.updateRoom(roomSelected) && Booking.updateBooking(booking)) {
			room_txtRoomId.setText("");
			room_txtRoomName.setText("");
			room_txtKey.setText("");

			if (booking.getStatus().equals("CheckOut")) {
				SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

				BLL.Receipt receipt = new Receipt();
				receipt.setCreated(formatter.format(new Date()));
				receipt.setBookingId(booking.getId());
				receipt.setHours(booking.getHours());
				receipt.setPayment(roomSelected.getPrice() * booking.getHours());
				if (Receipt.createReceipt(receipt)) {
					btnAction.show(room_actions, "checkIn");
					JOptionPane.showMessageDialog(null, "Check-out Success");
					this.initData();
				}
			}
		} else {

			JOptionPane.showMessageDialog(null, "Check-out Failed!!");
		}
        }//GEN-LAST:event_room_btnCheckOutActionPerformed

        private void room_btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_btnCheckInActionPerformed
		CardLayout btnAction = (CardLayout) (room_actions.getLayout());
		BLL.Room room = roomSelected;
		BLL.Booking booking = userBooking.stream().filter(b -> b.getRoomKey().equals(room_txtKey.getText())).findFirst().get();

		if (room == null) {
			return;
		}

		try {
			RSA rsa = new RSA();
			String priKey = room.getPriKey();
			String roomId = String.valueOf(room.getId());

			String roomKey = rsa.decryptRSA(priKey, room_txtKey.getText());
			if (Hash.password(roomId.toCharArray()).pepper(pepper).algorithm(com.amdelamar.jhash.algorithms.Type.BCRYPT).verify(roomKey)) {
				booking.setStatus("CheckIn");
				Booking.updateBooking(booking);
				btnAction.show(room_actions, "checkOut");
				JOptionPane.showMessageDialog(panel_content, "Checkin Success!!");
				this.initData();
			}
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(panel_content, "Checkin Error!!");
			Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
        }//GEN-LAST:event_room_btnCheckInActionPerformed

        private void room_btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_btnSearchActionPerformed
		this.initData();
        }//GEN-LAST:event_room_btnSearchActionPerformed

        private void room_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_btnRefreshActionPerformed
		room_txtSearch.setText("");
		room_txtRoomId.setText("");
		room_txtRoomName.setText("");
		room_txtKey.setText("");
		this.initData();
        }//GEN-LAST:event_room_btnRefreshActionPerformed

        private void room_listRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_listRoomMousePressed
		try {
			int selectedRow = room_listRoom.getSelectedRow();
			int id = (int) room_listRoom.getValueAt(selectedRow, 0);
			roomSelected = listRoom.stream().filter(r -> r.getId() == id).findFirst().get();

			room_txtRoomId.setText(String.valueOf(roomSelected.getId()));
			room_txtRoomName.setText(roomSelected.getName());
		} catch (Exception e) {
			roomSelected = null;
		}
        }//GEN-LAST:event_room_listRoomMousePressed

        private void booking_btnBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnBookingActionPerformed

		BLL.Room room = getInitRoom();

		if (roomSelected == null || room == null) {
			return;
		}

		if (booking_txtHours.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Booking Hours inValid!!!");
			booking_txtHours.requestFocus();
		} else {

			try {
				RSA rsa = new RSA();
				String pubKey = rsa.setPubKey();
				String priKey = rsa.setPriKey();
				room.setPubKey(pubKey);
				room.setPriKey(priKey);
				booking_txtRoomStatus.setSelectedIndex(1);
				room.setStatus("Booked");
				boolean createKey = Room.updateRoom(room);
				String roomId = String.valueOf(room.getId());
				String hashRoomId = Hash.password(roomId.toCharArray()).pepper(pepper).algorithm(com.amdelamar.jhash.algorithms.Type.BCRYPT).create();
				if (createKey) {
					BLL.Booking booking = new BLL.Booking();
					booking.setName("BOOKING " + room.getName());
					booking.setRoomKey(rsa.encryptRSA(pubKey, hashRoomId));
					booking.setUser(DB.user.toUpperCase());
					booking.setRoomId(room.getId());
					booking.setHours(Double.parseDouble(booking_txtHours.getText()));

					JOptionPane.showMessageDialog(null, Booking.createBooking(booking) ? "Booking success" : "Booking fail!");
					this.initData();
				}

			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			} catch (Exception ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
        }//GEN-LAST:event_booking_btnBookingActionPerformed

        private void booking_btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnDeleteActionPerformed
		BLL.Room room = getInitRoom();
		if (room == null) {
			return;
		}

		JOptionPane.showMessageDialog(null, Room.deleteRoom(room) ? "Delete success" : "Delete fail!");
		this.initData();
        }//GEN-LAST:event_booking_btnDeleteActionPerformed

        private void booking_btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnUpdateActionPerformed
		BLL.Room room = getInitRoom();

		if (roomSelected == null || room == null) {
			return;
		}

		room.setPubKey(roomSelected.getPubKey() == null ? "" : roomSelected.getPubKey());
		room.setPriKey(roomSelected.getPriKey() == null ? "" : roomSelected.getPriKey());

		JOptionPane.showMessageDialog(null, Room.updateRoom(room) ? "Update success" : "Update fail!");
		this.initData();
        }//GEN-LAST:event_booking_btnUpdateActionPerformed

        private void booking_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnAddActionPerformed
		BLL.Room room = getInitRoom();
		if (room == null) {
			return;
		}

		JOptionPane.showMessageDialog(null, Room.createRoom(room) ? "Create success" : "Create fail!");
		this.initData();
        }//GEN-LAST:event_booking_btnAddActionPerformed


        private void booking_btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnSearchActionPerformed
		this.initData();
        }//GEN-LAST:event_booking_btnSearchActionPerformed

        private void booking_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booking_btnRefreshActionPerformed
		booking_txtSearch.setText("");
		booking_txtRoomId.setText("");
		booking_txtRoomName.setText("");
		booking_txtPrice.setText("");
		booking_txtHours.setText("");
		booking_txtRoomStatus.setSelectedIndex(0);
		this.initData();
        }//GEN-LAST:event_booking_btnRefreshActionPerformed

        private void infor_btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infor_btnUpdateActionPerformed
		BLL.Infor user = initUser;
		if (user == null) {
			return;
		} else {
			try {
				AES aes = new AES();
				String key = aes.stringKey();
				String password = infor_txtPassword.getText();
				user.setEmail(infor_txtEmail.getText());
				user.setPassword(aes.encryptAES(password, key));
				user.setKey(key);

				JOptionPane.showMessageDialog(null, Infor.updateInfor(user) ? "Update success" : "Update fail");
			} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
				Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

        }//GEN-LAST:event_infor_btnUpdateActionPerformed

        private void booking_listRoomMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booking_listRoomMousePressed
		try {
			int selectedRow = booking_listRoom.getSelectedRow();
			int id = (int) booking_listRoom.getValueAt(selectedRow, 0);
			roomSelected = listRoom.stream().filter(r -> r.getId() == id).findFirst().get();

			booking_txtRoomId.setText(String.valueOf(roomSelected.getId()));
			booking_txtRoomName.setText(roomSelected.getName());
			booking_txtRoomStatus.setSelectedItem(roomSelected.getStatus());
			booking_txtPrice.setText(String.valueOf(roomSelected.getPrice()));
		} catch (Exception e) {
			roomSelected = null;
		}
        }//GEN-LAST:event_booking_listRoomMousePressed

        private void infor_btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infor_btnRefreshActionPerformed
		filterBooking = String.valueOf(infor_txtBookingStatus.getSelectedItem()).equals("All") ? "" : String.valueOf(infor_txtBookingStatus.getSelectedItem());
		this.initData();
        }//GEN-LAST:event_infor_btnRefreshActionPerformed

	private void setSidebarColor(JPanel panel) {
		panel.setBackground(new Color(133, 212, 241));
	}

	private void resetSidebarColor(JPanel panel) {
		panel.setBackground(new Color(25, 118, 211));
	}

	private void home_btnCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_home_btnCloseActionPerformed
		this.dispose();
	}

	private void sidebar_homeMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_homeMousePressed
		setSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_information);
		cardLayout.show(panel_content, "content_home");
	}// GEN-LAST:event_sidebar_homeMousePressed

	private void sidebar_bookingMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_bookingMousePressed
		setSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_information);
		cardLayout.show(panel_content, "content_booking");
	}// GEN-LAST:event_sidebar_bookingMousePressed

	private void sidebar_roomMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_roomMousePressed
		setSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_information);
		cardLayout.show(panel_content, "content_room");
	}// GEN-LAST:event_sidebar_roomMousePressed

	private void sidebar_receiptMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_receiptMousePressed
		setSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_information);
		cardLayout.show(panel_content, "content_receipt");
	}// GEN-LAST:event_sidebar_receiptMousePressed

	private void sidebar_staffMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_staffMousePressed
		setSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_information);
		cardLayout.show(panel_content, "content_staff");
	}// GEN-LAST:event_sidebar_staffMousePressed

	private void sidebar_logoutMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sidebar_logoutMousePressed
		setSidebarColor(sidebar_logout);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_booking);
		resetSidebarColor(sidebar_information);
		conn = DB.disConnect();
		try {
			if (conn != null) {
				JOptionPane.showMessageDialog(rootPane, "Logout success!!!");
				this.dispose();
				new Authencation().setVisible(rootPaneCheckingEnabled);
			} else {
				JOptionPane.showMessageDialog(null, "Logout fail!!!");
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}// GEN-LAST:event_sidebar_logoutMousePressed

	private void sidebar_informationMousePressed(java.awt.event.MouseEvent evt) {
		setSidebarColor(sidebar_information);
		resetSidebarColor(sidebar_receipt);
		resetSidebarColor(sidebar_home);
		resetSidebarColor(sidebar_room);
		resetSidebarColor(sidebar_staff);
		resetSidebarColor(sidebar_booking);
		cardLayout.show(panel_content, "content_information");
		initUser = listInfor.stream().filter(u -> u.getUsername().equals(DB.user.toUpperCase())).findFirst().get();
		infor_txtEmail.setText(initUser != null ? initUser.getEmail() : "");
	}

	/**
	 * @param args the command line arguments
	 */
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel booking_actions;
        private javax.swing.JButton booking_btnAdd;
        private javax.swing.JButton booking_btnBooking;
        private javax.swing.JButton booking_btnDelete;
        private javax.swing.JButton booking_btnRefresh;
        private javax.swing.JButton booking_btnSearch;
        private javax.swing.JButton booking_btnUpdate;
        private javax.swing.JPanel booking_infor;
        private javax.swing.JLabel booking_lbBooking;
        private javax.swing.JLabel booking_lbInfor;
        private javax.swing.JTable booking_listRoom;
        private javax.swing.JPanel booking_searchActions;
        private javax.swing.JSplitPane booking_section;
        private javax.swing.JSeparator booking_sepInfor;
        private javax.swing.JSeparator booking_sepSearch;
        private javax.swing.JPanel booking_staff;
        private javax.swing.JScrollPane booking_table;
        private javax.swing.JTextField booking_txtHours;
        private javax.swing.JTextField booking_txtPrice;
        private javax.swing.JTextField booking_txtRoomId;
        private javax.swing.JTextField booking_txtRoomName;
        private javax.swing.JComboBox<String> booking_txtRoomStatus;
        private javax.swing.JTextField booking_txtSearch;
        private javax.swing.JPanel content_booking;
        private javax.swing.JPanel content_home;
        private javax.swing.JPanel content_information;
        private javax.swing.JPanel content_receipt;
        private javax.swing.JPanel content_room;
        private javax.swing.JPanel content_user;
        private javax.swing.JButton home_btnClose;
        private javax.swing.JLabel home_lbHome;
        private javax.swing.JButton infor_btnRefresh;
        private javax.swing.JButton infor_btnUpdate;
        private javax.swing.JLabel infor_lbInfor;
        private javax.swing.JTable infor_listBooking;
        private javax.swing.JSeparator infor_sepUser;
        private javax.swing.JScrollPane infor_table;
        private javax.swing.JComboBox<String> infor_txtBookingStatus;
        private javax.swing.JTextField infor_txtEmail;
        private javax.swing.JTextField infor_txtPassword;
        private javax.swing.JTextField infor_txtUser;
        private javax.swing.JLayeredPane panel_content;
        private javax.swing.JPanel panel_history;
        private javax.swing.JPanel panel_information;
        private javax.swing.JLayeredPane panel_main;
        private javax.swing.JLayeredPane panel_sidebar;
        private javax.swing.JButton receipt_btnRefresh;
        private javax.swing.JButton receipt_btnSearch;
        private javax.swing.JPanel receipt_infor;
        private javax.swing.JLabel receipt_lbInfor;
        private javax.swing.JLabel receipt_lbReceipt;
        private javax.swing.JTable receipt_list;
        private javax.swing.JPanel receipt_searchActions;
        private javax.swing.JSplitPane receipt_section;
        private javax.swing.JSeparator receipt_sepInfor;
        private javax.swing.JSeparator receipt_sepSearch;
        private javax.swing.JScrollPane receipt_table;
        private javax.swing.JTextField receipt_txtBookingId;
        private javax.swing.JTextField receipt_txtCreated;
        private javax.swing.JTextField receipt_txtHours;
        private javax.swing.JTextField receipt_txtPayment;
        private javax.swing.JTextField receipt_txtReciptId;
        private javax.swing.JTextField receipt_txtSearch;
        private javax.swing.JPanel room_actions;
        private javax.swing.JButton room_btnCheckIn;
        private javax.swing.JButton room_btnCheckOut;
        private javax.swing.JButton room_btnRefresh;
        private javax.swing.JButton room_btnSearch;
        private javax.swing.JScrollPane room_fieldKey;
        private javax.swing.JPanel room_infor;
        private javax.swing.JLabel room_lbInfor;
        private javax.swing.JLabel room_lbRoom;
        private javax.swing.JTable room_listRoom;
        private javax.swing.JPanel room_searchActions;
        private javax.swing.JSplitPane room_section;
        private javax.swing.JSeparator room_sepInfor;
        private javax.swing.JSeparator room_sepSearch;
        private javax.swing.JScrollPane room_table;
        private javax.swing.JTextArea room_txtKey;
        private javax.swing.JTextField room_txtRoomId;
        private javax.swing.JTextField room_txtRoomName;
        private javax.swing.JTextField room_txtSearch;
        private javax.swing.JPanel sidebar_booking;
        private javax.swing.JPanel sidebar_home;
        private javax.swing.JPanel sidebar_information;
        private javax.swing.JLabel sidebar_lbBooking;
        private javax.swing.JLabel sidebar_lbHome;
        private javax.swing.JLabel sidebar_lbInformation;
        private javax.swing.JLabel sidebar_lbLogout;
        private javax.swing.JLabel sidebar_lbReceipt;
        private javax.swing.JLabel sidebar_lbRoom;
        private javax.swing.JLabel sidebar_lbStaff;
        private javax.swing.JPanel sidebar_logout;
        private javax.swing.JPanel sidebar_receipt;
        private javax.swing.JPanel sidebar_room;
        private javax.swing.JSeparator sidebar_sepSidabar;
        private javax.swing.JPanel sidebar_staff;
        private javax.swing.JPanel user_actions;
        private javax.swing.JButton user_btnAdd;
        private javax.swing.JButton user_btnDelete;
        private javax.swing.JButton user_btnRefresh;
        private javax.swing.JButton user_btnSearch;
        private javax.swing.JPanel user_infor;
        private javax.swing.JLabel user_lbInfor;
        private javax.swing.JLabel user_lbUser;
        private javax.swing.JTable user_list;
        private javax.swing.JPanel user_searchActions;
        private javax.swing.JSplitPane user_section;
        private javax.swing.JSeparator user_sepInfor;
        private javax.swing.JSeparator user_sepSearch;
        private javax.swing.JScrollPane user_table;
        private javax.swing.JTextField user_txtEmail;
        private javax.swing.JTextField user_txtPassword;
        private javax.swing.JComboBox<String> user_txtRole;
        private javax.swing.JTextField user_txtSearch;
        private javax.swing.JTextField user_txtUsername;
        // End of variables declaration//GEN-END:variables

}
