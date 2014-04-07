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
	
	//create checkbox variables
	CheckBox checkboxAllenGrill = (CheckBox)findViewById(R.id.allenGrill);
//	CheckBox checkboxBarBlue = (CheckBox) findViewById(R.id.barBleu);
//	CheckBox checkboxBrewery = (CheckBox) findViewById(R.id.brewery);
//	CheckBox checkboxCafe = (CheckBox) findViewById(R.id.cafe);
//	CheckBox checkboxChilis = (CheckBox) findViewById(R.id.chilis);
//	CheckBox checkboxChrome = (CheckBox) findViewById(R.id.chrome);
//	CheckBox checkboxChumleys = (CheckBox) findViewById(R.id.chumleys);
//	CheckBox checkboxDarkhorse = (CheckBox) findViewById(R.id.darkhorse);
//	CheckBox checkboxGman = (CheckBox) findViewById(R.id.gman);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_no_go);
		Intent intent = getIntent();
		String firstBar = intent.getStringExtra(StartCrawl.FIRST_BAR);
		System.out.println(firstBar);
		tourParms.add(firstBar);
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
		//saveNoGoBars();		
		
		//start new activity CrawlNoGo2
 	    startActivity(intent);
		
	}
	
//	public void saveNoGoBars(){
//		//loop through each checkbox and check if the state is true then save it to tourParms array
//		if(checkboxAllenGrill.isActivated())
//			{
//				tourParms.add("allenGrill");
//			}
//		if(checkboxBarBlue.isActivated())
//		{
//			tourParms.add("barBleu");
//		}
//		if(checkboxBrewery.isActivated())
//		{
//			tourParms.add("brewery");
//		}
//		if(checkboxCafe.isActivated())
//		{
//			tourParms.add("cafe");
//		}
//		if(checkboxChilis.isActivated())
//		{
//			tourParms.add("chilis");
//		}
//		if(checkboxChrome.isActivated())
//		{
//			tourParms.add("chrome");
//		}
//		if(checkboxChumleys.isActivated())
//		{
//			tourParms.add("chumleys");
//		}
//		if(checkboxDarkhorse.isActivated())
//		{
//			tourParms.add("darkhorse");
//		}
//		if(checkboxGman.isActivated())
//		{
//			tourParms.add("gman");
//		}
//		
//		System.out.println(tourParms);
//		
//		
//	}

}
