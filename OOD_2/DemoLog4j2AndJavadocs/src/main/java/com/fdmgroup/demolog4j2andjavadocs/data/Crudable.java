package com.fdmgroup.demolog4j2andjavadocs.data;

import java.util.Optional;

/**
 * Crudable defines a contract of basic CRUD operations that can be performed on
 * type T instances to some persistence store.
 * 
 * @author karl.huff
 *
 * @param <T>
 *            the type to be persisted.
 * @param <U>
 *            a field type in T to search by.
 */
public interface Crudable<T, U> {
	
	/**
	 * Adds an instance of type T to some persistence store.
	 * 
	 * @param t
	 *            is the target instance to be persisted.
	 * @return true on a successful add, false otherwise.
	 */
	boolean create(T t);
	
	/**
	 * Retrieves an Optional containing an instance of type T from some persistence store.
	 * 
	 * @param u
	 *            is a field of a type T instance to search by.
	 * @return an Optional containing the target instance as its value, or empty otherwise.
	 */
	Optional<T> read(U u);
	
	/**
	 * Updates a persisted instance of type T with the state of input t. The
	 * input and stored instances are matched by the username.
	 * 
	 * @param t
	 *            is the state of the current version of the target persisted
	 *            type T instance.
	 * @return true on successful update, false otherwise.
	 */
	boolean update(T t);
	
	/**
	 * Removes an instance of type T from some persistence store.
	 * 
	 * @param u
	 *            is a field of a type T instance to search by.
	 * @return true if the target instance is deleted, false otherwise.
	 */
	boolean delete(U u);
}
