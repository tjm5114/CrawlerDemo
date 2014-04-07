package com.example.crawlerdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CrawlNoGo extends Activity {

	ArrayList<String> tourParms = new ArrayList<String>();
	
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
	
	public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, CrawlNoGo2.class);
 	    
		//fire NoGo Bar names to array function
		saveNoGoBars();
		
		//start new activity CrawlNoGo2
 	    startActivity(intent);
		
	}
	
	public void saveNoGoBars(){
		//loop through each checkbox and check if the state is true then save it to tourParms array
		
		
	}

}
