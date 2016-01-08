package newservertester;

import java.net.*;
public class NewServerTester {
    
    public static void main(String[] args){
    
        
    DatagramSocket skt = null;
    
    try{
    
        skt = new DatagramSocket(6700);
        
        byte [] buffer = new byte [1000];
        
        while (true){
        DatagramPacket request = new DatagramPacket (buffer, buffer.length);
        
        skt.receive(request);
        System.out.println("message received from client");
        
        String [] arrayMsg = (new String(request.getData())).split(" ");
        
        byte [] sendMsg = (arrayMsg[0] + " server processed").getBytes();
        
        DatagramPacket reply = new DatagramPacket(sendMsg, sendMsg.length, request.getAddress(), request.getPort());
        skt.send(reply);
        }
    
    }
    
    catch (Exception ex){
        System.out.println("error server side");
    
    }
    }
}
