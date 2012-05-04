package com.remainsoftware.user.internal;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class LoginBox extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text txtUser;
	private Text txtPassword;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public LoginBox(Shell parent, int style) {
		super(parent, style);
		setText("Login Dialog");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public void open() {
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
		shell.setLayout(new GridLayout(2, false));

		Label lblUser = new Label(shell, SWT.NONE);
		lblUser.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblUser.setText("User");

		txtUser = new Text(shell, SWT.BORDER);
		txtUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblPassword.setText("Password");

		txtPassword = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(shell, SWT.NONE);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		btnNewButton.setText("Login");

	}

	public int getPasswordHash() {
		return txtPassword.getText().hashCode();
	}

	public String getUserID() {
		return txtUser.getText();
	}
}
