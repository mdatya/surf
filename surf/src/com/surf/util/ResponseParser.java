package com.surf.util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.surf.entity.Geo;
import com.surf.entity.SearchResult;
import com.surf.entity.TwitStatus;

/**
 * JSONをパースしてSearchResultに詰めて返すクラス
 * @author maedatatsuya
 *
 */
public class ResponseParser {
	
	private static final String COMPLETED_IN = "completed_in";
	private static final String MAX_ID = "max_id";
	private static final String MAX_ID_STR = "max_id_str";
	private static final String SINCE_ID = "since_id";
	private static final String SINCE_ID_STR = "since_id_str";
	private static final String NEXT_PAGE = "next_page";
	private static final String REFRESH_URL = "refresh_url";
	private static final String PAGE = "page";
	private static final String QUERY = "query";
	private static final String RESULT_PER_PAGE = "results_per_page";
	private static final String RESULTS = "results";
	
	private static final String CREATED_AT = "created_at";
	private static final String FROM_USER = "from_user";
	private static final String FROM_USER_ID = "from_user_id";
	private static final String FROM_USER_ID_STR = "from_user_id_str";
	private static final String FROM_USER_NAME = "from_user_name";
	private static final String TO_USER = "to_user";
	private static final String TO_USER_ID = "to_user_id";
	private static final String TO_USER_ID_STR = "to_user_id_str";
	private static final String TO_USER_NAME = "to_user_name";
	private static final String ID = "id";
	private static final String ID_STR = "id_str";
	private static final String ISO_LANGUAGE_CODE = "iso_language_code";
	private static final String PROFILE_IMAGE_URL = "profile_image_url";
	private static final String PROFILE_IMAGE_URL_HTTPS = "profile_image_url_https";
	private static final String SOURCE = "source";
	private static final String TEXT = "text";
	private static final String GEO = "geo";
	private static final String COORDINATES = "coordinates";
	private static final String GEO_TYPE = "type";
	private static final String ENTITIES = "entities";
	private static final String URLS = "urls";
	private static final String URL = "url";
	private static final String EXPANDED_URL = "expanded_url";
	private static final String DISPLAY_URL = "display_url";

	public static SearchResult getSearchResult(byte[] data){
		
		SearchResult searchResult = null;
		ArrayList<TwitStatus> results = null;
		TwitStatus twitStatus = null;
		Geo geo = null;
		List<Map<String, String>> urlMapList = null;
		
		
		try {
			//レスポンス全体データ
			JSONObject json = new JSONObject(new String(data, "UTF-8"));
			
			if(json != null){
				searchResult = new SearchResult();
				
				searchResult.setProcessingTime(json.getDouble(COMPLETED_IN));
				searchResult.setMaxId(json.getLong(MAX_ID));
				searchResult.setMaxIdStr(json.getString(MAX_ID_STR));
				searchResult.setSinceId(json.getLong(SINCE_ID));
				searchResult.setSinceIdStr(json.getString(SINCE_ID_STR));
				searchResult.setNextUrl(json.getString(NEXT_PAGE));
				searchResult.setRefreshUrl(json.getString(REFRESH_URL));
				searchResult.setPage(json.getInt(PAGE));
				searchResult.setQuery(json.getString(QUERY));
				searchResult.setResultsPerPage(json.getInt(RESULT_PER_PAGE));
				
				//デバッグ用
				Log.d("DEBUG", json.toString());
				
				//ツイート全体データ
				JSONArray resultsJsonArray = json.getJSONArray(RESULTS);
				
				if(resultsJsonArray != null){
					results = new ArrayList<TwitStatus>();
					
					for(int i=0;i<resultsJsonArray.length();i++){
						twitStatus = new TwitStatus();
						
						//ツイート１件分データ
						JSONObject status = resultsJsonArray.getJSONObject(i);
						
						//日付
						if(!status.isNull(CREATED_AT)){
							SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ZZZZZ", Locale.ENGLISH);  
							format.setLenient(true);  
							Date date = format.parse(status.getString(CREATED_AT));
							twitStatus.setCreatedDate(date);
						}
						
						//fromユーザアカウント
						if(!status.isNull(FROM_USER)){
							twitStatus.setFromUser(status.getString(FROM_USER));
						}
						
						//fromユーザID
						if(!status.isNull(FROM_USER_ID)){
							twitStatus.setFromUserId(status.getLong(FROM_USER_ID));
						}
						
						//fromユーザID文字列
						if(!status.isNull(FROM_USER_ID_STR)){
							twitStatus.setFromUserIdStr(status.getString(FROM_USER_ID_STR));
						}
						
						//fromユーザ名
						if(!status.isNull(FROM_USER_NAME)){
							twitStatus.setFromUserName(status.getString(FROM_USER_NAME));
						}
						
						//toユーザアカウント
						if(!status.isNull(TO_USER)){
							twitStatus.setToUser(status.getString(TO_USER));
						}
						
						//toユーザID
						if(!status.isNull(TO_USER_ID)){
							twitStatus.setToUserId(status.getLong(TO_USER_ID));
						}
						
						//toユーザID文字列
						if(!status.isNull(TO_USER_ID_STR)){
							twitStatus.setToUserIdStr(status.getString(TO_USER_ID_STR));
						}
						
						//toユーザ名
						if(!status.isNull(TO_USER_NAME)){
							twitStatus.setToUserName(status.getString(TO_USER_NAME));
						}
						
						//id
						if(!status.isNull(ID)){
							twitStatus.setId(status.getLong(ID));
						}
						
						//id文字列
						if(!status.isNull(ID_STR)){
							twitStatus.setIdStr(status.getString(ID_STR));
						}
						
						//言語
						if(!status.isNull(ISO_LANGUAGE_CODE)){
							twitStatus.setIsoLangCd(status.getString(ISO_LANGUAGE_CODE));
						}
						
						//プロフ画像URL
						if(!status.isNull(PROFILE_IMAGE_URL)){
							twitStatus.setProfImgUrl(status.getString(PROFILE_IMAGE_URL));
						}
						
						//プロフ画像URLHttps
						if(!status.isNull(PROFILE_IMAGE_URL_HTTPS)){
							twitStatus.setProfImgUrlHttps(status.getString(PROFILE_IMAGE_URL_HTTPS));
						}
						
						//source
						if(!status.isNull(SOURCE)){
							twitStatus.setSource(status.getString(SOURCE));
						}
						
						//ツイート内容
						if(!status.isNull(TEXT)){
							twitStatus.setText(status.getString(TEXT));
						}
						
						//位置情報
						if(!status.isNull(GEO)){
							geo = new Geo();
							geo.setLat(status.getJSONObject(GEO).getJSONArray(COORDINATES).getDouble(0));
							geo.setLng(status.getJSONObject(GEO).getJSONArray(COORDINATES).getDouble(1));
							geo.setType(status.getJSONObject(GEO).getString(GEO_TYPE));
							
							twitStatus.setGeo(geo);
						}
						
						//エンティティからURL取得
						if(!status.isNull(ENTITIES)){
							if(!status.getJSONObject(ENTITIES).isNull(URLS)){
								urlMapList = new ArrayList<Map<String, String>>();
								
								JSONArray urlArray = status.getJSONObject(ENTITIES).getJSONArray(URLS);
								for(int j=0;j<urlArray.length();j++){
									Map<String, String> urlMap = new HashMap<String, String>();
									urlMap.put(URL, urlArray.getJSONObject(j).getString(URL));
									urlMap.put(EXPANDED_URL, urlArray.getJSONObject(j).getString(EXPANDED_URL));
									urlMap.put(DISPLAY_URL, urlArray.getJSONObject(j).getString(DISPLAY_URL));
									
									urlMapList.add(urlMap);
								}
								
								twitStatus.setUrlMapList(urlMapList);
							}
						}
						
						results.add(twitStatus);
					}
					searchResult.setResults(results);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return searchResult;
	}
}
