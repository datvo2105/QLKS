/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author vogiadat
 */
public class Booking {

	int id;
	String name;
	String roomKey;
	String user;
	int roomId;
	double hours;

	public Booking() {
	}

	public Booking(
	int id,
	String name,
	String roomKey,
	String user,
	int roomId,
	double hours) {
		this.id = id;
		this.name = name;
		this.roomKey = roomKey;
		this.user = user;
		this.roomId = roomId;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(
	int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(
	String name) {
		this.name = name;
	}

	public String getRoomKey() {
		return roomKey;
	}

	public void setRoomKey(
	String roomKey) {
		this.roomKey = roomKey;
	}

	public String getUser() {
		return user;
	}

	public void setUser(
	String user) {
		this.user = user;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(
	int roomId) {
		this.roomId = roomId;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(
	double hours) {
		this.hours = hours;
	}

}