package com.fdmgroup.ood2serializationdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistUser {
	
	public static final String FILE_PATH;
	
	static {
		FILE_PATH = "user.ser";
	}

	public void serializeUser(User user) {
		
		File file = new File(FILE_PATH);
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public User deSerializeUser() {

		User user = null;
		
		File file = new File(FILE_PATH);
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			user = (User) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return user;
	}
}
