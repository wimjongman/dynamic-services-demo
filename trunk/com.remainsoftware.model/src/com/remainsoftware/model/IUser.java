package com.remainsoftware.model;

public interface IUser {

	String getName();

	String getID();

	boolean checkPassword(int passwordHash);

}
