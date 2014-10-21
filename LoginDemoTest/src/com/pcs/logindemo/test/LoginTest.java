package com.pcs.logindemo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.logindemo.LoginActivity;

public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity>{

	private static final String USERNAME = "kalyani";
	private static final String PASSWORD = "kalyani123";

	private LoginActivity activity;

	private EditText uservalueEdt;
	private EditText pwdvalueEdt;
	private Button login_Btn;

	public LoginTest() {
		super(LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		assertNotNull(activity);
		uservalueEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.user_edt);
		pwdvalueEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.pwd_edt);
		login_Btn = (Button) activity.findViewById(com.pcs.logindemo.R.id.login_btn);
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPreconditions() {
		assertNotNull("Failed in getting activity context", getActivity());
		assertNotNull("Unable to find UserView", uservalueEdt);
		assertNotNull("Unable to find PasswordView", pwdvalueEdt);
		assertNotNull("Unable to find ButtonView", login_Btn);
	}
	public void test_login() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync(USERNAME);

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync(PASSWORD);

		TouchUtils.clickView(this, login_Btn);

}
}
