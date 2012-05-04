package com.remainsoftware.control;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.remainsoftware.model.IStoreService;
import com.remainsoftware.model.IUserService;

public class Control extends Dialog {

	protected Object result;
	protected Shell shell;
	private Button userService;
	private Button btnStoreService;

	public Control() {
		this(new Shell(Display.getDefault(), SWT.BORDER | SWT.CLOSE
				| SWT.RESIZE | SWT.TITLE | SWT.TOOL | SWT.DIALOG_TRIM), SWT.BORDER | SWT.CLOSE
				| SWT.RESIZE | SWT.TITLE | SWT.TOOL | SWT.DIALOG_TRIM);

	}

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public Control(Shell parent, int style) {
		super(parent, style);
		setText("Control");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public void open() {

		// TODO Auto-generated method stub
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(450, 300);
		shell.setText(getText());
		shell.setLayout(new GridLayout(1, false));

		userService = new Button(shell, SWT.CHECK);
		userService.setText("User Service");

		btnStoreService = new Button(shell, SWT.CHECK);
		btnStoreService.setText("Store Service");

	}

	public void bindStoreService(IStoreService service) {

		getParent().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				btnStoreService.setSelection(true);
			}
		});

	}

	public void unbindStoreService(IStoreService service) {
		getParent().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				btnStoreService.setSelection(false);
			}
		});
	}

	public void bindUserService(IUserService service) {

		getParent().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				userService.setSelection(true);
			}
		});

	}

	public void unbindUserService(IUserService service) {
		getParent().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				userService.setSelection(false);
			}
		});
	}

}
