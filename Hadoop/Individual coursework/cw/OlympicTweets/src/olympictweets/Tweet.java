/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olympictweets;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.hadoop.io.*;
 
public class Tweet implements WritableComparable<Tweet> {
 
    private LongWritable tweetId;
    private Text date;
    private Text hashtag;
    private Text tweet;
     
    public Tweet(){
        set(new LongWritable(), new Text(), new Text(), new Text());
    }
     
    public Tweet(Long tweetId, String date, String hashtag, String tweet){ 
        set(new LongWritable(tweetId), new Text(date), new Text(hashtag), new Text(tweet));
    }
 
    public Tweet(LongWritable tweetId, Text date, Text hashtag, Text tweet){
        set(tweetId, date, hashtag, tweet);
    }
     
    public void set(LongWritable tweetId, Text date, Text hashtag, Text tweet){
        this.tweetId = tweetId;
        this.date = date;
        this.hashtag = hashtag;
        this.tweet = tweet;
    }
     
    public LongWritable getTweetId(){
        return tweetId;
    }
     
    public Text getDate(){
        return date;
    }
 
    public Text getHashtag(){
        return hashtag;
    }
     
    public Text getTweet(){
        return tweet;
    }
     
    public void write(DataOutput out) throws IOException {
        tweetId.write(out);
        date.write(out);
        hashtag.write(out);
        tweet.write(out);
    }
     
    public void readFields(DataInput in) throws IOException {
        tweetId.readFields(in);
        date.readFields(in);
        hashtag.readFields(in);
        tweet.readFields(in);
    }

	@Override
	public String toString() {
		return null;	
	}

	@Override
	public int compareTo(Tweet t) {
		return 0;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
 
}
