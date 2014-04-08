package com.example.crawlerdemo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;


public class DisplayCrawlActivity extends Activity  {
	
	public final static String Cost_PROG = "com.example.crawlerdemo.COSTPROG";
	public final static String DIST_PROG = "com.example.crawlerdemo.DISTPROG";
	public final static String ALC_PROG = "com.example.crawlerdemo.ALCPROG";
	
	private int costParms = 1;
	private int distParms = 1;
	private int alcParms = 1;
	
	private Handler mHandler = new Handler();
	private String _id;
	private List<String>[] _tours = new ArrayList[3];
	private String _baseUrl = "http://crawlrapi.herokuapp.com/";
	private String _networkImage;
	
	private String firstBar;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_crawl);
		
		//get intent data from previous screen (CrawlNoGo2.java)
			Intent intent = getIntent();
			firstBar = intent.getStringExtra(StartCrawl.FIRST_BAR);
			System.out.println(firstBar);
			
			costParms = intent.getIntExtra(Cost_PROG, costParms);
			System.out.println(costParms);
			
			distParms = intent.getIntExtra(DIST_PROG, distParms);
			System.out.println(distParms);
			
			alcParms = intent.getIntExtra(ALC_PROG, alcParms);
			System.out.println(alcParms);
		
		StrictMode.ThreadPolicy policy = new StrictMode.
				ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy); 
		
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("cost", Integer.toString(costParms)));
				pairs.add(new BasicNameValuePair("distance", Integer.toString(distParms)));
				pairs.add(new BasicNameValuePair("alcohol", Integer.toString(alcParms)));
		
				
				
		try {
			
			String encodeFirstBar = Uri.encode(firstBar);
			URL makeUrl = new URL(_baseUrl + "route/" + encodeFirstBar);
			
			DoPostRequest(makeUrl, makeRouteAndSaveId, pairs); //sets _id
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
    }
	
	public interface Request{
		void Process(BufferedReader reader);
	}

	Request makeRouteAndSaveId = new Request(){
		public void Process(BufferedReader reader){
			try{
				//do request and set guid
			    String line = "";
			   // List<String> barStrings = new ArrayList<String>();
			    if ((line = reader.readLine()) != null) {
			      System.out.println(line);
			      _id = line;
			      //barStrings.add(line);
			      //System.out.println("bar strings are " + barStrings);
			      try{
					mHandler.postDelayed(new Runnable() {
			            public void run() {
			            	URL getUrl = null;
							try {
								getUrl = new URL(_baseUrl + "result/" + _id);
							} catch (MalformedURLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			            	DoGetRequest(getUrl, getRouteAndSaveTours); //sets _tours[]
			            }
			        }, 5000);
			      }
			      catch(Exception e){}
				
			    }
			}
			catch(IOException e){}
		}
	};
	
	Request getRouteAndSaveTours = new Request(){


		public void Process(BufferedReader reader)
		{
			try{
				 int tourIndex = 0;
				 String line = "";
				   // List<String> barStrings = new ArrayList<String>();
				    while ((line = reader.readLine()) != null) {
				    	_tours[tourIndex] = new ArrayList<String>();
				    	do
				    	{
				    		if(line.length() == 0)
				    			break;
				    		//get tour
				    		System.out.println(line);
				    		_tours[tourIndex].add(line);
				    	}
				    	while((line = reader.readLine()) != null);
				    	tourIndex++;
				      
				      //barStrings.add(line);
				      //System.out.println("bar strings are " + barStrings);
				    }
				    
				    _networkImage = _baseUrl + _id + ".pdf";
				    new DownloadImageTask((ImageView) findViewById(R.id.imageView1))
		            .execute(_networkImage);
					GenerateListView();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	};
	
	protected void GenerateListView()
	{
		String[] array = _tours[0].toArray(new String[_tours[0].size()]);
		ArrayAdapter adapter = new ArrayAdapter<String>(this, 
		        android.R.layout.simple_list_item_1, array);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		System.out.println("Done!!");
	}

	
				
				
	public void DoGetRequest(URL url, Request req)
	{
		try {
	
			  HttpURLConnection con = (HttpURLConnection) url
			    .openConnection();
			  readStream(con.getInputStream(), req);
			  } catch (Exception e) {
			  e.printStackTrace();
			}
        
	}
	
	public void DoPostRequest(URL url, Request req, List<NameValuePair> pairs)
	{
		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost post = new HttpPost(url.toURI());
			post.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse response = client.execute(post);
			
			HttpEntity entity = response.getEntity();
		String	Str = EntityUtils.toString(entity);
			InputStream stream = new ByteArrayInputStream(Str.getBytes("UTF-8"));

		  readStream(stream, req);
			  } catch (Exception e) {
			  e.printStackTrace();
			}
        
	}
	
	private void readStream(InputStream in, Request req) {
		  BufferedReader reader = null;
		  try {
		    reader = new BufferedReader(new InputStreamReader(in));
		    req.Process(reader);
		  } finally {
		    if (reader != null) {
		      try {
		        reader.close();
		      } catch (IOException e) {
		        e.printStackTrace();
		        }
		    }
		  }
		} 	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_crawl, menu);
		return true;
	}
	
	public void DoPost()
	{
//		HttpClient httpClient = new DefaultHttpClient();
//		
//		HttpPost httpPost = new HttpPost(
//                "http://crawlr.ngrok.com/route/result/inferno");		
//     
// 
//        // Making HTTP Request
//       try {
//            HttpResponse response = httpClient.execute(httpPost);
//// 
////            // writing response to log
//            Log.d("Http Response:", response.toString());
//        } catch (ClientProtocolException e) {
////            // writing exception to log
//            e.printStackTrace();
//        } catch (IOException e) {
//            // writing exception to log
//            e.printStackTrace();
// 
//        }
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    ImageView bmImage;

	    public DownloadImageTask(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	        bmImage.setImageBitmap(result);
	    }
	}
	
	 
	public void finalize(View v) {
		Intent intent = new Intent(this, CrawlFinalize.class);
 	    
 	    startActivity(intent);
		
	}
	
}



