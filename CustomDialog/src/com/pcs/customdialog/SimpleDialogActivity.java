package com.pcs.customdialog;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class SimpleDialogActivity extends Activity{

	private EditText userEdt;
	private EditText streamEdt;
	private EditText pwdEdt;
	private Button loginBtn;
	private Button cancelBtn;
	private  AlertDialog alert;


	private Button okBtn;
	private  Button custom_cancelBtn;


	@Override
	protected void onCreate(Bundle savedInstanceState) {						/**		//**void com.pcs.customdialog.SimpleDialogActivity.onCreate(Bundle savedInstanceState)

																				@Override

																Called when the activity is starting. This is where most initialization should go: calling 
 																setContentView(int) to inflate the activity's UI, using findViewById to programmatically interact with 
 																widgets in the UI, calling managedQuery(android.net.Uri, String[], String, String[], String) to retrieve 
 																cursors for data being displayed, etc. 	

																Parameters:
																	savedInstanceState If the activity is being re-initialized after previously being shut down then this 
	 																Bundle contains the data it most recently supplied in onSaveInstanceState			
	 **/
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);

		userEdt = (EditText)findViewById(R.id.user_edt);
		streamEdt = (EditText)findViewById(R.id.stream_edt);
		pwdEdt = (EditText)findViewById(R.id.pwd_edt);

		loginBtn=(Button)findViewById(R.id.login_btn);
		cancelBtn=(Button)findViewById(R.id.cancel_btn);

		loginBtn.setOnClickListener(new android.view.View.OnClickListener() {

			@Override
			public void onClick(View v) {				/**void com.pcs.customdialog.SimpleDialogActivity.onCreate(...).new OnClickListener() {...}.onClick(View v)

																	@Override

																	Called when a view has been clicked.
																		Specified by: onClick(...) in OnClickListener
																					Parameters:
																		v The view that was clicked.**/

				AlertDialog.Builder builder = new AlertDialog.Builder(SimpleDialogActivity.this);

				builder.setTitle(R.string.dialog_title);/**
				Builder android.app.AlertDialog.Builder.setTitle(int titleId)


													Set the title using the given resource id.
														Parameters:
														titleId 
															Returns:
	 															This Builder object to allow for chaining of calls to set 
	  															methods
				 													**/
				builder.setItems(R.array.selection, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {/**

																				oid com.pcs.customdialog.SimpleDialogActivity.onCreate(...).new OnClickListener() 
 																					{...}.onClick(...).new OnClickListener() {...}.onClick(DialogInterface dialog, int which)

																								@Override

																			This method will be invoked when a button in the dialog is clicked.
																				Specified by: onClick(...) in OnClickListener
																						Parameters:
																						dialog The dialog that received the click.
																									which The button that was clicked (e.g. DialogInterface.BUTTON1) or the position of the item 
	 																				clicked.
					 **/

						switch (which) {
						case 0: Toast.makeText(SimpleDialogActivity.this,getResources().getString( R.string.help) + userEdt.getText().toString(), Toast.LENGTH_LONG).show();
						break;
						case 1: Toast.makeText(SimpleDialogActivity.this,getResources().getString( R.string.help)+ streamEdt.getText().toString(), Toast.LENGTH_LONG).show();
						break;
						case 2: Toast.makeText(SimpleDialogActivity.this,getResources().getString( R.string.help)+ pwdEdt.getText().toString(), Toast.LENGTH_LONG).show();
						break;
						default:
							break;
						}	
					}
				});
				builder.setPositiveButton(R.string.dialog_success, new OnClickListener() {	/**
																			Builder android.app.AlertDialog.Builder.setNegativeButton(int textId, OnClickListener listener)


																		Set a listener to be invoked when the negative button of the dialog is pressed.
																			Parameters:
																					textId The resource id of the text to display in the negative button
																					listener The DialogInterface.OnClickListener to use.
																					Returns:
	 																					This Builder object to allow for chaining of calls to set methods
				 														**/

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(SimpleDialogActivity.this, R.string.success_msg, Toast.LENGTH_LONG).show();

					}
				});

				builder.setNegativeButton(R.string.dialog_cancel, new OnClickListener() {	/**Builder android.app.AlertDialog.Builder.setNegativeButton(int textId, OnClickListener listener)


																				Set a listener to be invoked when the negative button of the dialog is pressed.
																						Parameters:
																							textId The resource id of the text to display in the negative button
																								listener The DialogInterface.OnClickListener to use.
																						Returns:
	 																							This Builder object to allow for chaining of calls to set methods
				 **/

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(SimpleDialogActivity.this, R.string.cancel_msg, Toast.LENGTH_LONG).show();
					}
				});
				builder.create();
				builder.show();
			}

		});


		cancelBtn.setOnClickListener(new android.view.View.OnClickListener() {
			/**void android.view.View.setOnClickListener(OnClickListener l)


																	Register a callback to be invoked when this view is clicked. If this view is not clickable, it becomes 
 																			clickable.
																							Parameters:
																									l The callback that will run

			 **/

			@Override
			public void onClick(View v) {



				LayoutInflater inflater = LayoutInflater.from(SimpleDialogActivity.this);

				View customView = getLayoutInflater().inflate(R.layout.custom,null);

				AlertDialog.Builder build = new AlertDialog.Builder(SimpleDialogActivity.this);
				build.setView(customView);

				okBtn = (Button)customView.findViewById(R.id.ok_btn);
				custom_cancelBtn = (Button)customView.findViewById(R.id.custom_cancel_btn);


				okBtn.setOnClickListener(new android.view.View.OnClickListener() {


					public void onClick(View v) {

						Toast.makeText(SimpleDialogActivity.this, R.string.custom_ok_msg, Toast.LENGTH_LONG).show();/**

																				Toast android.widget.Toast.makeText(Context context, int resId, int duration) throws 
 																								NotFoundException


																						Make a standard toast that just contains a text view with the text from a resource.
																						Parameters:
																							context The context to use. Usually your android.app.Application or android.app.Activity 
																								object.
																										resId The resource id of the string resource to use. Can be formatted text.
																			duration How long to display the message. Either LENGTH_SHORT or LENGTH_LONG
																					Throws:
																				Resources.NotFoundException - if the resource can't be found.
						 **/
						alert.dismiss();
					}
				});

				custom_cancelBtn.setOnClickListener(new android.view.View.OnClickListener() {


					public void onClick(View v) {
						Toast.makeText(SimpleDialogActivity.this, R.string.custom_cancel_msg, Toast.LENGTH_LONG).show();
						alert.dismiss();			/**
																					void android.app.Dialog.dismiss()


																					Dismiss this dialog, removing it from the screen. This method can be invoked safely from any thread. 
 																										Note that you should not override this method to do cleanup when the dialog is dismissed, instead 
 																							implement that in onStop.
																						Specified by: dismiss() in DialogInterface
						 ***/	
					}
				});

				alert=build.create();			/**AlertDialog android.app.AlertDialog.Builder.create()


																			Creates a AlertDialog with the arguments supplied to this builder. It does not Dialog.show() the dialog. 
																		This allows the user to do any extra processing before displaying the dialog. Use show() if you don't have 
 															any other processing to do and want this to be created and displayed.
				 **/
				alert.show();/**
																					void android.app.Dialog.show()


																						Start the dialog and display it on screen. The window is placed in the application layer and opaque. Note 
 																								that you should not override this method to do initialization when the dialog is shown, instead 
 																					implement that in onStart.
				 **/

			}

		} );	

	}

}
