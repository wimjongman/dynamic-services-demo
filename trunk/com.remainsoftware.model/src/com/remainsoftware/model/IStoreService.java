package com.remainsoftware.model;

/**
 * Simple store
 * 
 * @author Wim Jongman - Remain Software
 * 
 */
public interface IStoreService {

	/**
	 * Retrieves an object from the store with the given key.
	 * 
	 * @param key
	 * @return the object, could be null if there is no store or if there is no
	 *         object with this key.
	 */
	public Object retrieve(String key);

	/**
	 * Service is started, this is your chance to initialize.
	 */
	public void start();

	/**
	 * Service is stopped. This is your chance to clean up.
	 */
	public void stop();

	/**
	 * Stores an object in the store with the given key.
	 * 
	 * @param key
	 * @param object
	 */
	public void store(String key, Object object);

	/**
	 * This method will get a user and push it in the user service.
	 * 
	 * @param service
	 * @param userID
	 */
	public void getUser(String userID);

	/**
	 * Receive the store service from OSGi
	 * 
	 * @param userService
	 */
	void registerUserService(IUserService userService);

}
