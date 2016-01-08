
package olympictweets;


import java.io.IOException;
import olympictweets.TweetParser;
import olympictweets.Tweet;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 

public class myMapper extends Mapper<Text, Tweet, Text, IntWritable>  {
    
    public void map(Text textKey, Tweet tweetValue, Context context) throws IOException , InterruptedException{ 
        
        context.write(new Text(Integer.toString((tweetValue.getTweet().toString().length()))), new IntWritable(1));
    }
    
}
