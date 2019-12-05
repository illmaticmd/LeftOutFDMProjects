package com.fdmgroup.ood2jsonjacksondemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;

public class UserJsonPersistenceManager {

	public static final String JSON_PATH;

	private ObjectMapper objectMapper;

	static {
		JSON_PATH = "users.json";
	}

	public UserJsonPersistenceManager() {
		super();
		objectMapper = new ObjectMapper();
	}

	public void serialize(User user) {

		File file = new File(JSON_PATH);

		try (FileWriter fileWriter = new FileWriter(file);) {
			objectMapper.writer().forType(User.class).writeValue(fileWriter, user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public User deserialize() {

		User user = null;

		File file = new File(JSON_PATH);
		try (FileReader fileReader = new FileReader(file);) {
			user = objectMapper.reader().forType(User.class).readValue(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<User> read() {

		List<User> users = null;

		File file = new File(JSON_PATH);

		try (FileReader fileReader = new FileReader(file);
				MappingIterator<User> iterator = objectMapper.reader().forType(User.class).readValues(fileReader);) {
			users = iterator.readAll();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public void write(User... users) {

		File file = new File(JSON_PATH);

		try (FileWriter fileWriter = new FileWriter(file, true);
				SequenceWriter sequenceWriter = objectMapper.writer().forType(User.class).writeValues(fileWriter);) {
			for (User user : users) {
				sequenceWriter.write(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
