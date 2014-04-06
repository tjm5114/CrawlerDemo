package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class CrawlNoGo2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_no_go2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crawl_no_go2, menu);
		return true;
	}
	
	public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, CrawlNoGo3.class);
 	    
 	    startActivity(intent);
		
	}

}
