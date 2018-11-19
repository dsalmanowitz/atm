public class accountHolder {
	private int PIN;
	private String name;
	private String address;
	
	public accountHolder(int PIN, String name, String address) {
		this.PIN = PIN;
		this.name = name;
		this.address = address;
	}
	
	public int getPIN() {
		return PIN;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setPIN(int PIN) {
		this.PIN = PIN;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
