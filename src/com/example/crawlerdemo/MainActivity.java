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

	private Button crawlButton;
	private TextView tvDisplayDate;
	private DatePicker dpResult;
	private Button btnChangeDate;
	
	private int year;
	private int month;
	private int day;
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    crawlButton = (Button) this.findViewById(R.id.buttonCrawl);
    crawlButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			setContentView(R.layout.crawlparams); 
			
		}
	});
    
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
    
 // display current date
 	public void setCurrentDateOnView() {
  
// 		tvDisplayDate = (TextView) findViewById(R.id.tvDate);
// 		dpResult = (DatePicker) findViewById(R.id.dpResult);
  
 		final Calendar c = Calendar.getInstance();
 		year = c.get(Calendar.YEAR);
 		month = c.get(Calendar.MONTH);
 		day = c.get(Calendar.DAY_OF_MONTH);
  
 		// set current date into textview
 		tvDisplayDate.setText(new StringBuilder()
 			// Month is 0 based, just add 1
 			.append(month + 1).append("-").append(day).append("-")
 			.append(year).append(" "));
  
 		// set current date into datepicker
 		dpResult.init(year, month, day, null);
  
 	}
 	
 	public void crawlTourTab(View view) {
 		Intent intent = new Intent(this, CrawlParameters.class);
 	    
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


