package com.fdmgroup.ood2serializationdemo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class User extends Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static int currentID;
	
	private int id;
	private Credentials credentials;
	
	public User(String firstName, String lastName, String username, String password) {
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		setCredentials(new Credentials(username, password));
	}

	private int getNextId() {
		
		return ++currentID;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException {
 
        out.defaultWriteObject();     
        out.writeUTF(this.getFirstName());
        out.writeObject(this.getLastName());
    }

    private void readObject(ObjectInputStream in) throws IOException,
                                                            ClassNotFoundException {
        in.defaultReadObject();
        
        String firstName = in.readUTF(); 
        this.setFirstName(firstName);
        
        Object lastNameObj = in.readObject(); 
        if (lastNameObj instanceof String) {
        	String lastName = (String) lastNameObj;
        	this.setLastName(lastName);
        } else {
        	throw new RuntimeException("Expecting a String!");
        }
    }

	public int getId() {
		if (id == 0) {
			id = getNextId();
		}
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}	

	@Override
	public String toString() {
		return "User [id=" + getId() + ", " + credentials + ", " + super.toString() +"]";
	}	
}
