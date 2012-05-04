package com.remainsoftware.control;

import org.osgi.framework.BundleContext;

import com.remainsoftware.model.IStoreService;
import com.remainsoftware.model.IUserService;

public class ControlControl {

	private Control ctlr;

	public void open() throws Exception {

		Runnable runner = new Runnable() {

			@Override
			public void run() {
				ctlr = new Control();
				ctlr.open();
			}
		};
		Thread thread = new Thread(runner);
		thread.setDaemon(true);
		thread.start();
	}

	public void bindStoreService(IStoreService service) {
		System.out.println("bss");
		if (ctlr != null)
			ctlr.bindStoreService(service);
	}

	public void bindUserService(IUserService service) {
		System.out.println("bus");
		if (ctlr != null)
			ctlr.bindUserService(service);
	}

	public void unbindStoreService(IStoreService service) {
		System.out.println("uss");
		if (ctlr != null)
			ctlr.unbindStoreService(service);
	}

	public void unbindUserService(IUserService service) {
		System.out.println("uus");
		if (ctlr != null)
			ctlr.unbindUserService(service);
	}

	public void dispose() {
		System.out.println("dispose");
		if (ctlr != null)
			ctlr.getParent().getDisplay().syncExec(new Runnable() {

				@Override
				public void run() {
					ctlr.getParent().dispose();
				}
			});
	}

}
