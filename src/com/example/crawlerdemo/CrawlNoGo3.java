package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CrawlNoGo3 extends Activity {

	public final static String FIRST_BAR = "com.example.crawlerdemo.FIRSTBAR";
	private String firstBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_no_go3);
		
		//get intent data from previous screen (CrawlNoGo2.java)
		Intent intent = getIntent();
		firstBar = intent.getStringExtra(StartCrawl.FIRST_BAR);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crawl_no_go3, menu);
		return true;
	}
	
	public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, DisplayCrawlActivity.class);
		
		//pass tour parameter string
		intent.putExtra(FIRST_BAR, firstBar);
 	    
 	    startActivity(intent);
		
	}

}
