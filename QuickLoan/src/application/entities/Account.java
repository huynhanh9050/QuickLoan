package application.entities;

public class Account {
	private int id;
	private String username;
	private String fullname;
	private String email;
	private String password;
	private Boolean term;
	private String role;
	private double balance;
	private Byte photo_after;
	private Byte photo_before;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Byte getPhoto_after() {
		return photo_after;
	}
	public void setPhoto_after(Byte photo_after) {
		this.photo_after = photo_after;
	}
	public Byte getPhoto_before() {
		return photo_before;
	}
	public void setPhoto_before(Byte photo_before) {
		this.photo_before = photo_before;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getTerm() {
		return term;
	}
	public void setTerm(Boolean term) {
		this.term = term;
	}
	
	
}
