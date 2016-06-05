package com.popup.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.view.View;
import android.view.Gravity;   
import android.view.LayoutInflater;  
import android.view.ViewGroup;
import android.view.View.OnClickListener;

public class ShowPopupWindow extends Activity implements View.OnClickListener{

	View view;
	PopupWindow pop;
	Button btnShowAsDrawDown;
	Button btnShowAsDrawDown1;
	Button btnShowAtLocation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.popup_demo);
		btnShowAsDrawDown = (Button)findViewById(R.id.btnShowAsDrawDown);
		btnShowAsDrawDown.setOnClickListener(this);
		btnShowAsDrawDown = (Button)findViewById(R.id.btnShowAsDrawDown1);
		btnShowAsDrawDown.setOnClickListener(this);
		btnShowAtLocation = (Button)findViewById(R.id.btnShowAt);
		btnShowAtLocation.setOnClickListener(this);
		initPopupWindow();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.btnShowAsDrawDown:
			if(pop.isShowing())
			{
				pop.dismiss();
			}
			else
			{ 
				pop.showAsDropDown(v); 
			}
			break;
		case R.id.btnShowAsDrawDown1:
			if(pop.isShowing())
			{
				pop.dismiss();
			}
			else
			{ 
				pop.showAsDropDown(v, 0, -160); 
			}
			break;
			default:
				if(pop.isShowing())
				{
					pop.dismiss();
				}
				else
				{
					
					 pop.showAtLocation(findViewById(R.id.main), Gravity.CENTER_HORIZONTAL, 0, 0);   
				}
				break;
		}

		

	}
	
	private void initPopupWindow()
	{
		view = this.getLayoutInflater().inflate(R.layout.popup_window, null);
		pop = new PopupWindow(view, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		pop.setOutsideTouchable(true);
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pop.dismiss();
			}
		});
	}

}
