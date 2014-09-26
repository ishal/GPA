package com.bishal.android.taskmanager;

import com.bishal.android.taskmanager.ViewTasksActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SIGNUP extends Activity {
	Button register;
	private EditText etName;
	private EditText etEmail;
	//private EditText etUsername;
	private EditText etPassword;
	private DbHelper dbhelper;

	 AlertDialogManager alert = new AlertDialogManager();
			
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		dbhelper=new DbHelper(this);
		etName=(EditText)findViewById(R.id.edit_name);
		etEmail=(EditText)findViewById(R.id.edit_email);
	//	etUsername=(EditText)findViewById(R.id.edit_signup_username);
		etPassword=(EditText)findViewById(R.id.edit_signup_password);
		register=(Button)findViewById(R.id.signup);
		register.setOnClickListener(new View.OnClickListener() {
			
				
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//String UserNameValue=etUsername.getText().toString();
	        	String NameValue=etName.getText().toString();
				String EmailValue=etEmail.getText().toString();
				String PasswordValue=etPassword.getText().toString();
//				public boolean isEmailValid(String emailValue)
//				{
//			         String regExpn =
//			             "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
//			                 +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//			                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
//			                   +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
//			                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
//			                   +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
//
//			     CharSequence inputStr = emailValue;
//			     Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
//			      Matcher matcher = pattern.matcher(inputStr);
//
//			     if(matcher.matches())
//			        return true;
//			     else
//			    	 alert.showAlertDialog(LOGIN.this, "Login failed..", "Invalid Email Address", false);
//			        return false;
//			}
				
				ACCOUNT_INFO account=new ACCOUNT_INFO(NameValue,EmailValue,PasswordValue);
				if(NameValue.trim().length()>0 && EmailValue.trim().length() > 0 &&  PasswordValue.trim().length() >0)	{ 
	        	//if(dbhelper.eMailValidation(EmailValue)){
					if(dbhelper.validateregister(EmailValue)){
					dbhelper.addAccount(account);
					Intent intent=new Intent(SIGNUP.this,ViewTasksActivity.class);																
				}
				else{
//					Toast.makeText(getApplicationContext(),"Username already exists",Toast.LENGTH_SHORT).show();
//					Intent intent=getIntent();
//					finish();
//					startActivity(intent);
					alert.showAlertDialog(SIGNUP.this, "Signup failed..", "Username/Email already exists", false);
				}
	        	
				}
				else{
                    alert.showAlertDialog(SIGNUP.this, "Signup failed..", "Please enter empty fields", false);
				
		}
			}
		});
		
	}

}


