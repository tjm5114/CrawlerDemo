package com.example.crawlerdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class CrawlNoGo extends Activity {
	
	//create tour parameters array 
	ArrayList<String> tourParms = new ArrayList<String>();
	
	public final static String FIRST_BAR = "com.example.crawlerdemo.FIRSTBAR";
	public final static String BAR_PARMS = "com.example.crawlerdemo.BAR_PARMS";
	public final static String Cost_PROG = "com.example.crawlerdemo.COSTPROG";
	public final static String DIST_PROG = "com.example.crawlerdemo.DISTPROG";
	public final static String ALC_PROG = "com.example.crawlerdemo.ALCPROG";
	
	private String firstBar;
	private int costParms = 1;
	private int distParms = 1;
	private int alcParms = 1;
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_no_go);
		
		//get intent data from previous screen (StartCrawl.java)
		Intent intent = getIntent();
		
		firstBar = intent.getStringExtra(StartCrawl.FIRST_BAR);
		System.out.println(firstBar);
		tourParms.add(firstBar);
		
		costParms = intent.getIntExtra(Cost_PROG, costParms);
		System.out.println(costParms);
		
		distParms = intent.getIntExtra(DIST_PROG, distParms);
		System.out.println(distParms);
		
		alcParms = intent.getIntExtra(ALC_PROG, alcParms);
		System.out.println(alcParms);
		
		
		//System.out.println(tourParms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crawl_no_go, menu);
		return true;
	}
	
	public void newActivity(View v) {
		Intent intent = new Intent(this, CrawlNoGo2.class);
 	    
		//fire NoGo Bar names to array function
		saveNoGoBars();		
		
		//pass tour parameter string
		intent.putExtra(FIRST_BAR, firstBar);
		intent.putStringArrayListExtra(BAR_PARMS, tourParms);
		intent.putExtra(Cost_PROG, costParms);
 	    intent.putExtra(ALC_PROG, alcParms);
 	    intent.putExtra(DIST_PROG, distParms);
		
		//start new activity CrawlNoGo2
 	    startActivity(intent);
		
	}
	
	public void saveNoGoBars(){
		//loop through each checkbox and check if the state is true then save it to tourParms array
		
		//create checkbox variables
				CheckBox checkboxAllenGrill = (CheckBox)findViewById(R.id.allenGrill);
				CheckBox checkboxBarBlue = (CheckBox) findViewById(R.id.barBleu);
				CheckBox checkboxBrewery = (CheckBox) findViewById(R.id.brewery);
				CheckBox checkboxCafe = (CheckBox) findViewById(R.id.cafe);
				CheckBox checkboxChilis = (CheckBox) findViewById(R.id.chilis);
				CheckBox checkboxChrome = (CheckBox) findViewById(R.id.chrome);
				CheckBox checkboxChumleys = (CheckBox) findViewById(R.id.chumleys);
				CheckBox checkboxDarkhorse = (CheckBox) findViewById(R.id.darkhorse);
				CheckBox checkboxGman = (CheckBox) findViewById(R.id.gman);
		
		if(checkboxAllenGrill.isChecked())
			{
				tourParms.add("allenGrill");
			}
		if(checkboxBarBlue.isChecked())
		{
			tourParms.add("barBleu");
		}
		if(checkboxBrewery.isChecked())
		{
			tourParms.add("brewery");
		}
		if(checkboxCafe.isChecked())
		{
			tourParms.add("cafe");
		}
		if(checkboxChilis.isChecked())
		{
			tourParms.add("chilis");
		}
		if(checkboxChrome.isChecked())
		{
			tourParms.add("chrome");
		}
		if(checkboxChumleys.isChecked())
		{
			tourParms.add("chumleys");
		}
		if(checkboxDarkhorse.isChecked())
		{
			tourParms.add("darkhorse");
		}
		if(checkboxGman.isChecked())
		{
			tourParms.add("gman");
		}
		
		System.out.println(tourParms);
		
		
	}

}
