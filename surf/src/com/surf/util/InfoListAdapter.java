package com.surf.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.surf.R;
import com.surf.entity.TwitStatus;

public class InfoListAdapter extends ArrayAdapter<TwitStatus> {

	private Context context;
	private ArrayList<TwitStatus> items;  
	private LayoutInflater inflater;
	
	public InfoListAdapter(Context context, int textViewResourceId, ArrayList<TwitStatus> items) {
		super(context, textViewResourceId, items);
		this.context = context;
		this.items = (ArrayList<TwitStatus>) items;
		this.inflater = (LayoutInflater) context  
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(int position, View contentView, ViewGroup parent){
		// ビューを受け取る
		View view = contentView;
		if(view == null){
			// 受け取ったビューがnullなら新しくビューを生成 
			view = inflater.inflate(R.layout.info_row, null);
		}
		// 表示するデータの取得
		TwitStatus item = (TwitStatus)items.get(position);
		
		// 表示領域を取得
		ImageView profImgView = (ImageView)view.findViewById(R.id.profile_image);
		TextView userNameView = (TextView)view.findViewById(R.id.user_name);
		TextView userIdView = (TextView)view.findViewById(R.id.user_id);
		TextView statusView = (TextView)view.findViewById(R.id.status);
		
		// ビューにセット
		String profImgUrl = item.getProfImgUrl();
		try{
			profImgView.setTag(profImgUrl);
            // AsyncTaskは１回しか実行できない為、毎回インスタンスを生成
            GetImageTask task = new GetImageTask(profImgView);
            task.execute(profImgUrl);
        }catch(Exception e){
            // TODO エラー時の処理
        }
		
		userNameView.setText(item.getFromUserName());
		userIdView.setText(item.getFromUser());
		statusView.setText(item.getText());
		
		return view;
	}
	
	/**
	 * プロフィール画像を表示するタスク
	 * @author maedatatsuya
	 *
	 */
	class GetImageTask extends AsyncTask<String,Void,Bitmap> {

	    private ImageView imageView;
//	    private ProgressBar progress;
	    private String tag;
	    
	    public GetImageTask(ImageView _image) {
	        // 対象の項目を保持しておく
	        imageView = _image;
//	        progress = _progress;
	        tag = imageView.getTag().toString();
	    }
		
		@Override
		protected void onPreExecute(){
			// TODO なにかあれば
		}
	    
		@Override
		protected Bitmap doInBackground(String... params) {
			
			synchronized (context){
	            try {
	            	// キャッシュより画像データを取得
	                Bitmap image = ImageCache.getImage(params[0]);
	                if (image == null) {
	                    // キャッシュにデータが存在しない場合はwebより画像データを取得
	                    URL imageUrl = new URL(params[0]);
	                    InputStream imageIs;
	                    imageIs = imageUrl.openStream();
	                    image = BitmapFactory.decodeStream(imageIs);
	                    // 取得した画像データをキャッシュに保持
	                    ImageCache.setImage(params[0], image);
	                }
	            	return image;
	            } catch (MalformedURLException e) {
	                return null;
	            } catch (IOException e) {
	                return null;
	            }
			}
		}
		
		@Override
	    protected void onPostExecute(Bitmap result) {
			// Tagが同じものか確認して、同じであれば画像を設定する
	        // （Tagの設定をしないと別の行に画像が表示されてしまう）
	        if(tag.equals(imageView.getTag())){
	            if(result!=null){
	                //画像の設定
	                imageView.setImageBitmap(result);
	            }
	            else{
	            	// TODO エラー時の処理
	            }
//	            // プログレスバーを隠し、取得した画像を表示
//	            progress.setVisibility(View.GONE);
//	            image.setVisibility(View.VISIBLE);
	        }
		}
    }

}
