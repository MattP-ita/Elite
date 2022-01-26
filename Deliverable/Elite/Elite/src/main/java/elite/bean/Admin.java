package elite.bean;

public class Admin {
	private String email;
	
	public Admin() {}

	public Admin(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmpty() {
		return email.equals("");
	}
}
