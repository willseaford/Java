import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.lang.*;
import java.io.*;
import java.net.*;

class TCPClientTest {
   public static void main(String args[]) {
      try {
         Socket skt = new Socket("INSERT IP ADDRESS HERE", 50005);
         BufferedReader in = new BufferedReader(new
            InputStreamReader(skt.getInputStream()));
         System.out.print("Received string: '");

         while (!in.ready()) {}
         System.out.println(in.readLine()); // Read one line and output it

         System.out.print("'\n");
         in.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}
