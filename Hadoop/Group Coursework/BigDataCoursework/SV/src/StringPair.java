import java.io.*;
import org.apache.hadoop.io.*;

public class StringPair implements WritableComparable<StringPair> {

   private Text first;
   private Text second;

   public StringPair() {
      set(new Text(), new Text());
   }

   public StringPair(String first, String second) {
      set(new Text(first), new Text(second));
   }

   public void set(Text first, Text second) {
      this.first = first;
      this.second = second;
   }

   public Text getFirst() {
      return first;
   }

   public Text getSecond() {
      return second;
   }

   @Override
   public void write(DataOutput out) throws IOException {
      first.write(out);
      second.write(out);
   }

   @Override
   public void readFields(DataInput in) throws IOException {
      first.readFields(in);
      second.readFields(in);
   }
   
   @Override
   public int hashCode() {
      return first.hashCode() * 163 + second.hashCode();
   }

   @Override
   public boolean equals(Object o) {
      if (o instanceof StringPair) {
         StringPair tp = (StringPair) o;
         return first.equals(tp.first) && second.equals(tp.second);
      }
      return false;
   }

   @Override
   public String toString() {
      return first + "---------" + second;
   }

   @Override
   public int compareTo(StringPair tp) {
      int cmp = first.compareTo(tp.first);
      if (cmp != 0) {
         return cmp;
      }
      return second.compareTo(tp.second);
   }
}