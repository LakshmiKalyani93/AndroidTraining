package com.pcs.logindemo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;

import com.pcs.constants.Constants;
import com.pcs.logindemo.LoginActivity;

public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity>{

	private LoginActivity activity;
	private EditText emailEdt,pwdEdt,userEdt,phnEdt;
	private Button loginBtn;

	public LoginTest() {
		super(LoginActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		assertNotNull(activity);
		userEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.user_edt);
		emailEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.email_edt);
		phnEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.phn_edt);
		pwdEdt = (EditText) activity.findViewById(com.pcs.logindemo.R.id.pwd_edt);
		loginBtn = (Button) activity.findViewById(com.pcs.logindemo.R.id.login_btn);
	}
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPreconditions() {
		assertNotNull("Failed in getting activity context", getActivity());
		assertNotNull("Unable to find EmailView", emailEdt);
		assertNotNull("Unable to find PhoneView", phnEdt);
		assertNotNull("Unable to find UserView", userEdt);
		assertNotNull("Unable to find PasswordView", pwdEdt);
		assertNotNull("Unable to find ButtonView", loginBtn);
	}
	public void test_login() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);

		TouchUtils.clickView(this, loginBtn);
	}
	public void test_userNull() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_pwdNull() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_phnNull() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync("");
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_emailNull() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_userInvalid() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USER_INVALID);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_pwdInvalid() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PWD_INVALID);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_emailInvalid() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL_INVALID);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE);
		TouchUtils.clickView(this, loginBtn);
	}
	public void test_phnInvalid() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.USERNAME);

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PASSWORD);

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.EMAIL);

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync(Constants.KeyExtras.PHONE_INVALID);
		TouchUtils.clickView(this, loginBtn);
	}

	public void test_allEmpty() {
		TouchUtils.tapView(this, userEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, pwdEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, emailEdt);
		getInstrumentation().sendStringSync("");

		TouchUtils.tapView(this, phnEdt);
		getInstrumentation().sendStringSync("");
		TouchUtils.clickView(this, loginBtn);
	}
}
