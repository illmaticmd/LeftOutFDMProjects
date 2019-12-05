package com.fdmgroup.ood2collectionsdemos;

public class User implements Comparable<User>{
	
	public static final int START_ID;
	public static final int ID_INCREMENT;
	private static int currentId;
	
	static {
		START_ID = 0;
		ID_INCREMENT = 1;
		currentId = START_ID;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	
	public User(String firstName, String lastName, String username, String email) {
		super();
		this.id = getNextId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
	}

	private int getNextId() {
		currentId += ID_INCREMENT;
		return currentId;
	}

	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int compareTo(User u) {
		
		return this.getId() - u.getId();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == null || !(o instanceof User)) {
			return false;
		} else {
			User userObj = (User) o;
			return this.username.toLowerCase().equals(userObj.getUsername().toLowerCase());
		}
	}
	
	@Override 
	public int hashCode() {
		
		return (int) this.username.toLowerCase().charAt(0);
	}
	
	@Override
	public String toString() {
		
		return "USER [id= " + this.id + ": " 
							+ this.lastName + ", "
							+ this.firstName + ", username="
							+ this.username + ", email="
							+ this.email + "]";		
	}
}
