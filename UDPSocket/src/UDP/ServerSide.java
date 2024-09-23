
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class ServerSide {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(6892);
        while(true){
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String message = new String(receivePacket.getData());
            InetAddress address = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String modifiedMessage = message.toUpperCase();
            byte[] sendData = modifiedMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
            serverSocket.send(sendPacket);
        }
    }
}
