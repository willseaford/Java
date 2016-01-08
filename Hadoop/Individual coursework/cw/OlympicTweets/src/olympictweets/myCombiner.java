package olympictweets;

import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class myCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
        int maxSize = 5;
        int minSize = 1;
        String textOutput = "";
        while (minSize < 141) {
            int tweetLength = Integer.parseInt(key.toString());
            if (tweetLength < maxSize && tweetLength > minSize) {
                textOutput = minSize + ":" + maxSize;
                break;
            } 
            
            else {
                minSize = minSize + 5;
                maxSize = maxSize + 5;

                if (minSize == 141) {
                    textOutput = minSize + "+";
                    break;
                }
            }

        }

        context.write (new Text(textOutput), new IntWritable(1));
    }

    

		
    
    }
