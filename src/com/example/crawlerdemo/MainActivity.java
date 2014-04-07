package com.example.crawlerdemo;

import java.util.Calendar;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

 

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    //crawlButton = (Button) this.findViewById(R.id.buttonCrawl);
    //crawlButton.setOnClickListener(new View.OnClickListener() {
		
//		@Override
//		public void onClick(View v) {
//			setContentView(R.layout.crawlparams); 
//			
//		}
//	});
    
//	    SPINNER SPINNER = (SPINNER) FINDVIEWBYID(R.ID.SPINNERBAR);
//	 // CREATE AN ARRAYADAPTER USING THE STRING ARRAY AND A DEFAULT SPINNER LAYOUT
//	 ARRAYADAPTER<CHARSEQUENCE> ADAPTER = ARRAYADAPTER.CREATEFROMRESOURCE(THIS,
//	         R.ARRAY.BARS, ANDROID.R.LAYOUT.SIMPLE_SPINNER_ITEM);
//	 // SPECIFY THE LAYOUT TO USE WHEN THE LIST OF CHOICES APPEARS
//	 ADAPTER.SETDROPDOWNVIEWRESOURCE(ANDROID.R.LAYOUT.SIMPLE_SPINNER_DROPDOWN_ITEM);
//	 // APPLY THE ADAPTER TO THE SPINNER
//	 SPINNER.SETADAPTER(ADAPTER);
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }   
    
  	
 	
 	public void launchStart(View view) {
 		Intent intent = new Intent(this, StartCrawl.class);
 	    
 	    startActivity(intent);
 	}
 	
// 	public void addListenerOnButton() {
// 		 
//		btnChangeDate = (Button) findViewById(R.id.btnChangeDate);
// 
//		btnChangeDate.setOnClickListener(new OnClickListener() {
// 
//			@Override
//			public void onClick(View v) {
// 
//				showDialog(DATE_DIALOG_ID);
// 
//			}
// 
//		});
// 
//	}
// 
//	@Override
//	protected Dialog onCreateDialog(int id) {
//		switch (id) {
//		case DATE_DIALOG_ID:
//		   // set date picker as current date
//		   return new DatePickerDialog(this, datePickerListener, 
//                         year, month,day);
//		}
//		return null;
//	}
// 
//	private DatePickerDialog.OnDateSetListener datePickerListener 
//                = new DatePickerDialog.OnDateSetListener() {
// 
//		// when dialog box is closed, below method will be called.
//		public void onDateSet(DatePicker view, int selectedYear,
//				int selectedMonth, int selectedDay) {
//			year = selectedYear;
//			month = selectedMonth;
//			day = selectedDay;
// 
//			// set selected date into textview
//			tvDisplayDate.setText(new StringBuilder().append(month + 1)
//			   .append("-").append(day).append("-").append(year)
//			   .append(" "));
// 
//			// set selected date into datepicker also
//			dpResult.init(year, month, day, null);
// 
//		}
//	};
    
}


