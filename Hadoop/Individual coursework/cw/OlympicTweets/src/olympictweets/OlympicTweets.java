/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package olympictweets;

import java.util.Arrays;
import java.io.IOException;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class OlympicTweets {

   
    public static void main(String[] args) throws Exception {
        startRunJob(Arrays.copyOfRange(args, 0, args.length - 1), args[args.length - 1]);
    }
    
    public static void startRunJob(String[] input, String output) throws Exception {
        Configuration config = new Configuration();
        Job job = new Job(config);
        job.setJarByClass(OlympicTweets.class);
        job.setMapperClass(myMapper.class);
	job.setCombinerClass(myCombiner.class);
	job.setReducerClass(myReducer.class);
        
	
        
        job.setInputFormatClass(TweetParser.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
		
        Path outputPath = new Path(output);
		
        FileInputFormat.setInputPaths(job, StringUtils.join(input, ","));
        FileOutputFormat.setOutputPath(job, outputPath);
        outputPath.getFileSystem(config).delete(outputPath, true);
        job.waitForCompletion(true);
        }
}
