import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, Text, IntWritable> { 

   
    private String preference ="DOTA2";
    private Text timestamp = new Text();
    private int viewers = 0;
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	String filter = value.toString().replaceAll(" ", "");
	String[] line = filter.split("\t");
	if(line.length==7)
	{
	  try{
	    	viewers =Integer.parseInt(line[0]);
	    }
	    catch(Exception e){}
	    
	  if(viewers!=0 && !line[6].isEmpty() )
	  {
	    
	      if(line[3].toUpperCase().equals(preference))
	      {
		String times[] = line[6].split(" ");
		String parsedTime = times[0].substring(0, 7);
	        timestamp.set(parsedTime);
		context.write(timestamp, new IntWritable(1));
		
	      }
	  }
	}
    }
}
