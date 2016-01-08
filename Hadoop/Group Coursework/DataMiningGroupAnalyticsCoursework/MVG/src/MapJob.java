import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, Text, IntWritable> { 
    private IntWritable viewers = new IntWritable();
    private Text gameName = new Text();
    private int tempScore = 0;
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	String filter = value.toString().replaceAll(" ", "");
	String[] line = filter.split("\t");
	if(line.length==7)
	{
	  try{
	    viewers.set(Integer.parseInt(line[0]));
	    tempScore=Integer.parseInt(line[0]);
	    }
	    catch(Exception e){}
	    
	  if(tempScore!=0 && !line[3].isEmpty() )
	  {
	    gameName.set(line[3].toUpperCase());
	    context.write(gameName, viewers);
	  }
	}
    }
}