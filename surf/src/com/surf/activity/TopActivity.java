package com.surf.activity;

import com.surf.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

/**
 * トップページ
 * @author maedatatsuya
 *
 */
public class TopActivity extends Activity implements View.OnClickListener{

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		int searchFlg = 0;
		
		if(v == button1){
			searchFlg = 1;
		}else if(v == button2){
			searchFlg = 2;
		}else if(v == button3){
			searchFlg = 3;
		}else if(v == button4){
			searchFlg = 4;
		}else if(v == button5){
			searchFlg = 5;
		}else if(v == button6){
			searchFlg = 6;
		}
		Intent intent = new Intent(TopActivity.this, GetListActivity.class);
		intent.putExtra("searchFlg", searchFlg);
		startActivity(intent);
		
	}
}
