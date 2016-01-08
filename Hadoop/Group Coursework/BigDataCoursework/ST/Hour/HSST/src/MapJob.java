import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, Text, IntWritable> { 

   
    private String preference ="HEARTSTONE";
	private String[] sPreferences={"RIOTGAMES","NIGHTBLUE3","STARLADDER1","BEYONDTHESUMMIT","MOONDYE7","GAMEEKSTRA","GAMEBREAKERTV","BRUNKTON","HOLYPHOEN1X","NOROFFWALKER","SIXWONG","CRONICSIX"};
    private Text timestamp = new Text();
    private int viewers = 0;
	private String outgoing = "";
    
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
		if(line[2].toUpperCase().contains(sPreferences[8])){
			String times[] = line[6].split(" ");
			String parsedTime = times[0].substring(10, 12);
	        	outgoing = preference + " (" + sPreferences[8] + ") :" + parsedTime; 
			context.write(new Text(outgoing), new IntWritable(1));

		}
		if(line[2].toUpperCase().contains(sPreferences[9])){
			String times[] = line[6].split(" ");
			String parsedTime = times[0].substring(10, 12);
	        	outgoing = preference + " (" + sPreferences[9] + ") :" + parsedTime; 
			context.write(new Text(outgoing), new IntWritable(1));

		}
		
		
	      }
	  }
	}
    }
}
