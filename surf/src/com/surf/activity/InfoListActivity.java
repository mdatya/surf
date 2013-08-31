package com.surf.activity;

import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.surf.R;
import com.surf.util.InfoListAdapter;
import com.surf.util.TwitterUtils;

/**
 * 指定したエリアのツイートを一覧表示するクラス
 * @author maedatatsuya
 *
 */
public class InfoListActivity extends ListActivity implements View.OnClickListener{
	
	TwitterUtils tu;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_info_list);
        int searchFlg = getIntent().getIntExtra("searchFlg", 0);
        
        final String CONSUMER_KEY = getString(R.string.consumer_key);
        final String CONSUMER_SECRET = getString(R.string.consumer_secret);
        final String ACCESS_TOKEN = getString(R.string.access_token);
        final String ACCESS_TOKEN_SECRET = getString(R.string.access_token_secret);
    	tu = new TwitterUtils(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
 
        String searchWord = "鵠沼　波";

        new GetListTask().execute(searchWord);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    /**
     * 取得したデータを表示します
     * @param result
     * @return
     */
    private void setContent(List<Status> searchResultList){
    	
    	for(Status status:searchResultList){
    	    Log.d("DEBUG", "userName: " + status.getUser().getScreenName() + "text:  " + status.getText());
    	}

//    	ListView listView = (ListView) findViewById(R.id.list_view);
    	
    	InfoListAdapter adapter = new InfoListAdapter(this, R.layout.info_row, searchResultList);  
    	setListAdapter(adapter);
    	
    }

	/**
	 * ツイートの検索を行うタスク
	 * @author maedatatsuya
	 *
	 */
	private class GetListTask extends AsyncTask<String, Void, List<twitter4j.Status>>{

		@Override
		protected void onPreExecute(){
			// TODO くるくる回す
		}
		
		@Override
		protected List<twitter4j.Status> doInBackground(String... params) {
			try {
				return tu.search(params[0], 100);
			} catch (TwitterException e) {
				Log.e("ERROR", e.getMessage());
				return null;
			}
		}
		
		@Override
		protected void onPostExecute(List<twitter4j.Status> result){
			setContent(result);
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
