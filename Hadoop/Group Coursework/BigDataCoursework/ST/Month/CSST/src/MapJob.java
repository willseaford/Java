import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MapJob extends Mapper<LongWritable, Text, Text, IntWritable> { 

   
    private String preference ="COUNTERSTRIKE";
	private String[] sPreferences={"RIOTGAMES","NIGHTBLUE3","STARLADDER1","BEYONDTHESUMMIT","MOONDYE7","GAMEEKSTRA","GAMEBREAKERTV","BRUNKTON","HOLYPHOEN1X","NOROFFWALKER","SIXWONG","CRONICSIX"};
    private Text timestamp = new Text();
    private int viewers = 0;
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	String filter = value.toString().replaceAll(" ", "");
	String[] line = filter.split("\t");
	String outgoing = "";
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
		if(line[2].toUpperCase().contains(sPreferences[4]) ){
			String times[] = line[6].split(" ");
			String parsedTime = times[0].substring(0, 7);
	        	
			outgoing = preference + " (" + sPreferences[4] + ") :" + parsedTime; 
			context.write(new Text(outgoing), new IntWritable(1));
		}

		if(line[2].toUpperCase().contains(sPreferences[5])) {
			String times[] = line[6].split(" ");
			String parsedTime = times[0].substring(0, 7);
	        	
			outgoing = preference + " (" + sPreferences[5] + ") :" + parsedTime; 
			context.write(new Text(outgoing), new IntWritable(1));
		}
		
	      }
	  }
	}
    }
}
