package com.popup.demo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ShowCustomDialog extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customdialog);
		Button btnCustomDialog = (Button)findViewById(R.id.Button01);
		Button btnCustomAlertDialog = (Button)findViewById(R.id.Button02);
		btnCustomDialog.setOnClickListener(this);
		btnCustomAlertDialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.Button01:	
				Dialog dialog1 = new Dialog(ShowCustomDialog.this);
				dialog1.setContentView(R.layout.dialog1);
				dialog1.setTitle("This is my custom dialog box");
				dialog1.show();
				break;
			case R.id.Button02:
				final Dialog dialog = new Dialog(ShowCustomDialog.this);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog2);
				//dialog.setTitle("This is my custom dialog box");
				
				dialog.show();
				Button btnSms = (Button)dialog.findViewById(R.id.btnSms);
				btnSms.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Uri uri = Uri.parse("smsto://13057602765");   
						Intent intent = new Intent(Intent.ACTION_SENDTO, uri);   
						intent.putExtra("sms_body", "The SMS text");   
						startActivity(intent);  

					}
				});
				
				Button btnCall = (Button)dialog.findViewById(R.id.btnCall);
				btnCall.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Uri uri = Uri.parse("tel:13057602765");   
						Intent intent = new Intent(Intent.ACTION_DIAL, uri);   
						startActivity(intent); 
						dialog.dismiss();
					}
				});
				
				Button btnEmail = (Button)dialog.findViewById(R.id.btnEmail);
				btnEmail.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						 Uri uri = Uri.parse("mailto:test@gmail.com");   
						 Intent intent = new Intent(Intent.ACTION_SENDTO, uri);   
						 startActivity(intent);   
						dialog.dismiss();
					}
				});
				break;
			default:
				break;
		}
	}

}
