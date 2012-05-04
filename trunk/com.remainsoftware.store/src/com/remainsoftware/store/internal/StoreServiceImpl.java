package com.remainsoftware.store.internal;

import java.util.HashMap;

import com.remainsoftware.model.IStoreService;
import com.remainsoftware.model.IUser;
import com.remainsoftware.model.IUserService;

// referenced in component.xml
public class StoreServiceImpl implements IStoreService {

	private HashMap<String, Object> store;
	private IUserService userService;

	@Override
	public Object retrieve(String key) {
		if (store == null)
			return null;
		return store.get(key);
	}

	@Override
	public void start() {

		System.out.println("ss-start");
		store = new HashMap<String, Object>();

		store("user.id.wim",
				new User("wim", "Wim Jongman", "secr3t".hashCode()));
	}

	@Override
	public void stop() {
		System.out.println("ss-stop");
		store = null;

	}

	@Override
	public void store(String key, Object object) {
		if (store == null)
			return;
	}

	@Override
	public void getUser(String userID) {
		userService.setUser((IUser) store.get("user.id." + userID));
	}

	@Override
	public void registerUserService(IUserService userService) {
		System.out.println("ss-rus");
		this.userService = userService;
	}
}