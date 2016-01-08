import java.lang.*;
import java.io.*;
import java.net.*;

class TCPConnection {
   public static void main(String args[]) {
      String data = "Testing TCP connection handshake";
      try {
         ServerSocket srvr = new ServerSocket(50005);
         Socket skt = srvr.accept();
         System.out.print("Server has connected!\n");
         PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
         System.out.print("Sending string: '" + data + "'\n");
         out.print(data);
         out.close();
         skt.close();
         srvr.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}
