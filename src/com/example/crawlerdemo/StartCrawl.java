package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class StartCrawl extends Activity implements OnItemSelectedListener {
	
	//create global variable to pass firstBar parameter
	private String firstBar;
	public final static String FIRST_BAR = "com.example.crawlerdemo.FIRSTBAR";
	
	//create seekBar variables to pass around activites
	
	private SeekBar costSeekBar = null;
	private int costProgressChanged = 1;
	public final static String Cost_PROG = "com.example.crawlerdemo.COSTPROG";
	
	private SeekBar distSeekBar = null;
	private int distProgressChanged = 1;
	public final static String DIST_PROG = "com.example.crawlerdemo.DISTPROG";
	
	private SeekBar alcSeekBar = null;
	private int alcProgressChanged = 1;
	public final static String ALC_PROG = "com.example.crawlerdemo.ALCPROG";
	
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
		
		
		costSeekBar = (SeekBar) findViewById(R.id.seekBarCost);
	    costSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
 
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                costProgressChanged = progress;
            }
 
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
 
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(StartCrawl.this,"seek bar progress:"+costProgressChanged, 
//                        Toast.LENGTH_SHORT).show();
            }
        });
	    
	    distSeekBar = (SeekBar) findViewById(R.id.distSeekBar);
	    distSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
	    	 
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                distProgressChanged = progress;
            }
 
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
 
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(StartCrawl.this,"seek bar progress:"+distProgressChanged, 
//                        Toast.LENGTH_SHORT).show();
            }
        });
	    
	    alcSeekBar = (SeekBar) findViewById(R.id.alcSeekBar);
	    alcSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            
	    	 
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                alcProgressChanged = progress;
            }
 
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
 
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(StartCrawl.this,"seek bar progress:"+distProgressChanged, 
//                        Toast.LENGTH_SHORT).show();
            }
        });
	    
		
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
 	    intent.putExtra(Cost_PROG, costProgressChanged);
 	    intent.putExtra(ALC_PROG, alcProgressChanged);
 	    intent.putExtra(DIST_PROG, distProgressChanged);
 	    startActivity(intent);
		
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
		
		firstBar = (String) parent.getItemAtPosition(pos);
		firstBar = firstBar.replace(" ", ".");
		System.out.println(firstBar);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
