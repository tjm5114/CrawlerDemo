package com.example.crawlerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChallengePost extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_challenge_post);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.challenge_post, menu);
		return true;
	}

}
