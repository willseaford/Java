import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, StringPair, IntWritable> { 
    private IntWritable viewers =new IntWritable();
    private int tempScore=0;
    private StringPair pair = new StringPair();
    private Text gameName= new Text();
    private String[] preferences={"LEAGUEOFLEGENDS","DOTA2","COUNTERSTRIKE","WORLDOFWARCRAFT","HEARTSTONE","CALLOFDUTY"};
    private Text streamer = new Text();
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
	    for(int i=0; i<preferences.length; i++)
	      if(line[3].toUpperCase().equals(preferences[i]))
	      {
		gameName.set(line[3].toUpperCase());
		streamer.set(line[2].toUpperCase());
		pair.set(streamer,gameName);
		context.write(pair, viewers);
		break;
	      }
	  }
	}
    }
}