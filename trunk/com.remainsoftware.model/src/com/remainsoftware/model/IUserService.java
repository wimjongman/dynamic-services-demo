package com.remainsoftware.model;

public interface IUserService {

	/**
	 * Prompts the user for name and password and checks with the store if the
	 * user is authenticated.
	 * 
	 */
	public void login();

	/**
	 * Returns if the user is authenticated.
	 * 
	 * @param userID
	 * @return true is the user is authenticated, false otherwise.
	 */
	public boolean isAuthenticated();

	/**
	 * @return the ID of the logged in user, could be null.
	 */
	public String getLoggedInUserID();

	/**
	 * Receives the store service from OSGi as soon as one becomes available.
	 * 
	 * @param storeService
	 */

	void registerStoreService(IStoreService storeService);

	/**
	 * This is a callback method which sets the {@link IUser} the
	 * {@link IUserService}
	 * 
	 * @param userID
	 *            the user id to retrieve from the store
	 */
	public void setUser(IUser userID);

}
