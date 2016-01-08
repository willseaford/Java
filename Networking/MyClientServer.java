import java.net.*;



public class MyClientServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatagramSocket skt;
        
        try{
        
            skt = new DatagramSocket();
            String msg = "x1";
            byte [] b = msg.getBytes();
           
           
            InetAddress host = InetAddress.getByName("192.168.1.86");
            int serverSocket = 6700;
            
            DatagramPacket request = new DatagramPacket(b,b.length,host,serverSocket);
            skt.send(request);
            
            byte [] buffer = new byte[1000];
            
            DatagramPacket reply = new DatagramPacket(buffer,buffer.length);
            skt.receive(reply);
            System.out.println(" client received : " + new String(reply.getData()));
            skt.close();
            
        }
        
        catch (Exception ex){
            System.out.println("error client side");
        }
    }
    
}
