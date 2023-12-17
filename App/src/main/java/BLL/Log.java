/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author vogiadat
 */
public class Log {

	String user;
	String time;
	String ip;

	public Log() {
	}

	public Log(
	String user,
	String time,
	String ip) {
		this.user = user;
		this.time = time;
		this.ip = ip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(
	String user) {
		this.user = user;
	}

	public String getTime() {
		return time;
	}

	public void setTime(
	String time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(
	String ip) {
		this.ip = ip;
	}


}
