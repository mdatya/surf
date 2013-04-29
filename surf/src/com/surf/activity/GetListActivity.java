package com.surf.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.surf.R;
import com.surf.entity.SearchResult;
import com.surf.util.HttpClient;
import com.surf.util.ResponseParser;

/**
 * 指定したエリアのツイートを一覧表示するクラス
 * @author maedatatsuya
 *
 */
public class GetListActivity extends Activity implements View.OnClickListener{

	TextView jsonText;
	String json = "";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getlist);
        
        jsonText = (TextView) findViewById(R.id.jsonText);
        int searchFlg = getIntent().getIntExtra("searchFlg", 0);
        
        //TODO: クエリ生成
        
        new GetListTask().execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    /**
     * 取得したデータを表示します
     * @param result
     * @return
     */
    private boolean setContent(SearchResult result){
    	
    	
    	return true;
    }
	
	/**
	 * ツイートの検索を行うタスク
	 * @author maedatatsuya
	 *
	 */
	private class GetListTask extends AsyncTask<Void, Void, SearchResult>{

		@Override
		protected void onPreExecute(){
			
		}
		
		@Override
		protected SearchResult doInBackground(Void... params) {
			String urlStr = "https://search.twitter.com/search.json?q=%E6%B3%A2%20%E6%B9%98%E5%8D%97&include_entities=true&result_type=recent&rpp=50";
			
			//http通信
			byte[] data = HttpClient.getByteArrayFromURL(urlStr);
			
			//レスポンスをパース
			SearchResult result = ResponseParser.getSearchResult(data);
			
			return result;
		}
		
		@Override
		protected void onPostExecute(SearchResult result){
			setContent(result);
		}
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
