package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CrawlParameters extends Activity implements OnItemSelectedListener {

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

}
