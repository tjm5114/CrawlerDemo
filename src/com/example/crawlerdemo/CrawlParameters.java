package com.example.crawlerdemo;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

public class CrawlParameters extends Activity implements OnItemSelectedListener  {

	private Button crawlButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_parameters);
				
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		Spinner spinnerCover = (Spinner) findViewById(R.id.spinner2);
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.numberBars, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> adapterCover = ArrayAdapter.createFromResource(this,
		        R.array.barCover, android.R.layout.simple_spinner_item);
		
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapterCover.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinnerCover.setAdapter(adapterCover);
	
		spinner.setOnItemSelectedListener(this);
		spinnerCover.setOnItemSelectedListener(this);
		
		final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
       // return new DatePickerDialog(getActivity(), this, year, month, day);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crawl_parameters, menu);
		return true;
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
    
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
    }
    
    public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, StartCrawl.class);
 	    
 	    startActivity(intent);
		
	}
    
//    public void showDatePickerDialog(View v) {
//        DialogFragment newFragment = new DialogFragment();
//        newFragment.show(getSupportFragmentManager(), "datePicker");
//    }
}
