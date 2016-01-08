package olympictweets;

import java.lang.Math; 
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JasonCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text key, Iterable<IntWritable> value, Context context) throws IOException, InterruptedException {
		
		double numOfCharInTweet =  Double.parseDouble(key.toString());
		int groupedNumber;
		int gNum2;
		String newText = "";
		if(numOfCharInTweet<146){
			numOfCharInTweet = numOfCharInTweet/5;
			groupedNumber = (int)(Math.ceil(numOfCharInTweet));
			gNum2 = groupedNumber - 5;
			newText = Integer.toString(groupedNumber);
		} else {
			newText = "145<";
		}
		
		int sum = 0;
        for(IntWritable values: value){
		context.write(new Text(newText), new IntWritable(1));
	      }

	
	
    
    }
}