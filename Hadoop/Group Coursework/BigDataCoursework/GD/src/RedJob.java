import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class RedJob extends Reducer<IntWritable, StringPair, Text, Text> {
    private String[] preferences={"LEAGUEOFLEGENDS","DOTA2","COUNTERSTRIKE","WORLDOFWARCRAFT","HEARTSTONE","CALLOFDUTY"};
    public void reduce(IntWritable key, Iterable<StringPair> values, Context context)
              throws IOException, InterruptedException {
              
        int[] sum= new int[6];
        int[] count= new int[6];
        
	for(StringPair k : values)
	  for(int i=0; i<preferences.length; i++)
	   if(k.getFirst().toString().equals(preferences[i]))
	      {
		sum[i]+=Integer.parseInt(k.getSecond().toString());
		count[i]++;
		break;
	      }
       for(int j=0; j<preferences.length; j++)
	    context.write(new Text(preferences[j]),new Text(sum[j]/count[j]+" seconds"));
    }

}
