/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

/**
 *
 * @author vogiadat
 */
public class User {
	String user;
	String created;	

	public User() {
	}

	public User(
	String user,
	String created) {
		this.user = user;
		this.created = created;
	}

	public String getUser() {
		return user;
	}

	public void setUser(
	String user) {
		this.user = user;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(
	String created) {
		this.created = created;
	}

}
