package com.remainsoftware.store.internal;

import com.remainsoftware.model.IUser;

public class User implements IUser {

	private final String id;
	private final String name;
	private final int passwordHash;

	public User(String id, String name, int passwordHash) {
		this.id = id;
		this.name = name;
		this.passwordHash = passwordHash;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public boolean checkPassword(int passwordHash) {
		if (passwordHash == 0)
			return false;
		return this.passwordHash == passwordHash;
	}
}
