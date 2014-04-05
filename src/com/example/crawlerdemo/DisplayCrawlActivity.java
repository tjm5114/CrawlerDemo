package com.example.crawlerdemo;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DisplayCrawlActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_crawl);
		
		 URL url = new URL("http://crawlr.ngrok.com/");
		   HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		   try {
		     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		     readStream(in);
		    finally {
		     urlConnection.disconnect();
		   }
		 }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_crawl, menu);
		return true;
	}

}
