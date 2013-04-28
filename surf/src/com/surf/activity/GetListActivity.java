package com.surf.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.surf.R;
import com.surf.util.HttpClient;

public class GetListActivity extends Activity implements View.OnClickListener{

	TextView jsonText;
	String json = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getlist);
        
        jsonText = (TextView) findViewById(R.id.jsonText);
        int searchFlg = getIntent().getIntExtra("searchFlg", 0);
        
        new GetListTask().execute(searchFlg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		
	}
	
	private class GetListTask extends AsyncTask<Integer, Void, byte[]>{

		@Override
		protected void onPreExecute(){
			
		}
		
		@Override
		protected byte[] doInBackground(Integer... params) {
			String urlStr = "http://search.twitter.com/search.json?q=%E8%BE%BB%E5%A0%82%20%E6%B3%A2";
			byte[] data = HttpClient.getByteArrayFromURL(urlStr); 
			return data;
		}
		
		@Override
		protected void onPostExecute(byte[] result){
			jsonText.setText(result.toString());
		}
	}
	
}
