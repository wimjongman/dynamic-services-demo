package com.remainsoftware.user.internal;

import org.eclipse.swt.widgets.Display;

import com.remainsoftware.model.IStoreService;
import com.remainsoftware.model.IUser;
import com.remainsoftware.model.IUserService;

public class UserServiceImpl implements IUserService {

	private LoginBox loginBox;
	private IStoreService storeService;
	private IUser user;

	@Override
	public void login() {
		loginBox = new LoginBox(Display.getDefault().getActiveShell(), 0);
		loginBox.open();
	}

	@Override
	public boolean isAuthenticated() {
		storeService.getUser(getLoggedInUserID());
		return (user.checkPassword(loginBox.getPasswordHash()));
	}

	@Override
	public String getLoggedInUserID() {
		if (loginBox == null)
			return null;
		return loginBox.getUserID();
	}

	@Override
	public void registerStoreService(IStoreService storeService) {
		this.storeService = storeService;
	}

	@Override
	public void setUser(IUser userID) {
		this.user = userID;
	}
}
