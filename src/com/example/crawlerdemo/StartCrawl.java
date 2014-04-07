package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class StartCrawl extends Activity implements OnItemSelectedListener {
	//create global variable to pass firstBar parameter
	private String firstBar;
	public final static String FIRST_BAR = "com.example.crawlerdemo.FIRSTBAR";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_crawl);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner1);		
		
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.barList, android.R.layout.simple_spinner_item);		
		
		
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
	
		spinner.setOnItemSelectedListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_crawl, menu);
		return true;
	}
	
	public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, CrawlNoGo.class);
 	    intent.putExtra(FIRST_BAR, firstBar);
 	    startActivity(intent);
		
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
		
		firstBar = (String) parent.getItemAtPosition(pos);
		System.out.println(firstBar);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
