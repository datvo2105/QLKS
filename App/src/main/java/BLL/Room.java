package BLL;

public class Room {

	int id;
	String name;
	String status;
	double price;
	String pubKey;
	String priKey;

	public Room() {
	}

	public Room(int id, String name, String status, double price,
		String pubKey, String priKey) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.price = price;
		this.pubKey = pubKey;
		this.priKey = priKey;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public String getPriKey() {
		return priKey;
	}

	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}


}
