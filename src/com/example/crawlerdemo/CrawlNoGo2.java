package com.example.crawlerdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class CrawlNoGo2 extends Activity {

	public final static String FIRST_BAR = "com.example.crawlerdemo.FIRSTBAR";
	public final static String BAR_PARMS = "com.example.crawlerdemo.BAR_PARMS";
	
	private String firstBar;	
	
	ArrayList<String> tourParms = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crawl_no_go2);
		
		//get intent data from previous screen (CrawlNoGo.java)
			Intent intent = getIntent();
			firstBar = intent.getStringExtra(StartCrawl.FIRST_BAR);
			tourParms = intent.getStringArrayListExtra(BAR_PARMS);
			System.out.println(tourParms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.crawl_no_go2, menu);
		return true;
	}
	
	public void CrawlNoGo(View v) {
		Intent intent = new Intent(this, CrawlNoGo3.class);
 	    
		//pass tour parameter string
		intent.putExtra(FIRST_BAR, firstBar);
		
 	    startActivity(intent);
		
	}
	
	public void saveNoGoBars(){
		//loop through each checkbox and check if the state is true then save it to tourParms array
		
		//create checkbox variables
				CheckBox checkboxIndigo = (CheckBox)findViewById(R.id.indigo);
				CheckBox checkboxInferno = (CheckBox) findViewById(R.id.Inferno);
				CheckBox checkboxKildars = (CheckBox) findViewById(R.id.Kildares);
				CheckBox checkboxCafe = (CheckBox) findViewById(R.id.Levels);
				CheckBox checkboxChilis = (CheckBox) findViewById(R.id.LionsDen);
				CheckBox checkboxChrome = (CheckBox) findViewById(R.id.LocalWhiskey);
				CheckBox checkboxChumleys = (CheckBox) findViewById(R.id.MadMex);
				CheckBox checkboxDarkhorse = (CheckBox) findViewById(R.id.ThePhyrst);
				CheckBox checkboxGman = (CheckBox) findViewById(R.id.BillPicklesTapRoom);
				CheckBox checkboxSkellar = (CheckBox) findViewById(R.id.TheRathskellar);
		
		if(checkboxIndigo.isChecked())
			{
				tourParms.add("allenGrill");
			}
		if(checkboxInferno.isChecked())
		{
			tourParms.add("barBleu");
		}
		if(checkboxKildars.isChecked())
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
