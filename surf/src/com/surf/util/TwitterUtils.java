package com.surf.util;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterUtils {
	
	Twitter twitter;
	
	public TwitterUtils(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		  Configuration configuration = new ConfigurationBuilder().setOAuthConsumerKey(
		    consumerKey).setOAuthConsumerSecret(consumerSecret)
		    .setOAuthAccessToken(accessToken)
		    .setOAuthAccessTokenSecret(accessTokenSecret).build();

		  TwitterFactory factory = new TwitterFactory(configuration);
		  twitter = factory.getInstance();
	}
	
	public List<Status> search(String word, int count) throws TwitterException{
		  Query query = new Query(word);
		  query.setResultType(Query.RECENT);
		  query.setCount(count);
		  QueryResult result = twitter.search(query);
		  return result.getTweets();
	}

}
