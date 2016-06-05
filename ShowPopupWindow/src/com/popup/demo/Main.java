package com.popup.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends Activity implements View.OnClickListener{
    /** Called when the activity is first created. */
	
	Button btnShowDialog;
	Button btnPopupWindow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnShowDialog = (Button)findViewById(R.id.btnDialog);
        btnPopupWindow = (Button)findViewById(R.id.btnPopupWindow);
        btnShowDialog.setOnClickListener(this);
        btnPopupWindow.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = null;
		switch(v.getId())
		{
		case R.id.btnPopupWindow:
			intent = new Intent(Main.this, ShowPopupWindow.class);
			startActivity(intent);
			break;
		case R.id.btnDialog:
			intent = new Intent(Main.this, ShowCustomDialog.class);
			startActivity(intent);
			break;
			default:
				
				break;
		}

	}
}