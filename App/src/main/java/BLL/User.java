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

	int id;
	String username;
	String email;
	String password;
	String key;

	public User() {
	}

	public User(
	int id,
	String username,
	String email,
	String password,
	String key) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.key = key;
	}

	public int getId() {
		return id;
	}

	public void setId(
	int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(
	String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(
	String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(
	String password) {
		this.password = password;
	}

	public String getKey() {
		return key;
	}

	public void setKey(
	String key) {
		this.key = key;
	}


}
