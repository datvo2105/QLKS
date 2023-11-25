/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.util.Date;

/**
 *
 * @author vogiadat
 */
public class Receipt {
	int id;
	Date created;
	int bookingId;
	double hours;
	double payment;

	public Receipt() {
	}

	public Receipt(
	int id,
	Date created,
	int bookingId,
	double hours,
	double payment) {
		this.id = id;
		this.created = created;
		this.bookingId = bookingId;
		this.hours = hours;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(
	int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(
	Date created) {
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
	
	
}
