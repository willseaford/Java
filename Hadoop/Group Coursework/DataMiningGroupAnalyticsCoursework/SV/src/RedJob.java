import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RedJob extends Reducer<StringPair, IntWritable, Text, IntWritable> {

    private IntWritable result = new IntWritable();
    public void reduce(StringPair key, Iterable<IntWritable> values, Context context)

              throws IOException, InterruptedException {

        int sum = 0;
	for(IntWritable k:values){
	  sum+=k.get();
        }
         result.set(sum);
	 context.write(new Text(key.toString()), result); 
	      
    }

}
