/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author vogiadat
 */
public class Receipt {
	int id;
	String created;
	int bookingId;
	double hours;
	double payment;
	String user;

	public Receipt() {
	}

	public Receipt(
	int id,
	String created,
	int bookingId,
	double hours,
	double payment,
	String user) {
		this.id = id;
		this.created = created;
		this.bookingId = bookingId;
		this.hours = hours;
		this.payment = payment;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(
	int id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(
	String created) {
		this.created = created;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(
	int bookingId) {
		this.bookingId = bookingId;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(
	double hours) {
		this.hours = hours;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(
	double payment) {
		this.payment = payment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(
	String user) {
		this.user = user;
	}

}