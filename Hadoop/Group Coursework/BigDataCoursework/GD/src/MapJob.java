import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, IntWritable, StringPair> { 
    private Text delay= new Text();
    private String[] preferences={"LEAGUEOFLEGENDS","DOTA2","COUNTERSTRIKE","WORLDOFWARCRAFT","HEARTSTONE","CALLOFDUTY"};
    private Text gameName = new Text();
    private StringPair pair = new StringPair();
    private int tempDelay = 0;
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	String filter = value.toString().replaceAll(" ", "");
	String[] line = filter.split("\t");
	if (line.length==7)
	{
	  try{
	  delay.set(line[4]);
	  tempDelay=Integer.parseInt(line[4]);   
	  } catch(Exception e){}
	//if(tempDelay>0)// && !line[3].isEmpty() )
	   for(int i=0; i<preferences.length; i++)
	   {
	      if(line[3].toUpperCase().equals(preferences[i]))
	      {
	        gameName.set(line[3].toUpperCase());
		pair.set(gameName,delay);
		context.write(new IntWritable(1),pair);
		break;
	      }
	    }
	//}
    }
    }
}
