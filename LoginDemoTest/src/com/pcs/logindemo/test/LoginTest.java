package com.pcs.logindemo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.constants.Constants;
import com.pcs.logindemo.LoginActivity;

public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity>{

	
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
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.clickView(this, login_Btn);
	}
	public void test_userNull() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.clickView(this, login_Btn);
	}
	public void test_pwdNull() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.clickView(this, login_Btn);
	}
	public void test_userInvalid() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USER_INVALID);

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.clickView(this, login_Btn);
	}
	public void test_pwdInvalid() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PWD_INVALID);

		TouchUtils.clickView(this, login_Btn);
	}
	public void test_user_pwd_Empty() {
		TouchUtils.tapView(this, uservalueEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, pwdvalueEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.clickView(this, login_Btn);
	}
}
