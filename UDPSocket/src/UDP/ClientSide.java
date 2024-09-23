
package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


public class ClientSide {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket(9981);
        InetAddress IPAddress = InetAddress.getByName("localhost");
        while(true){
            byte[] receiveData = new byte[1024];
            String message = sc.nextLine();
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6892);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String modifiedMessage = new String(receivePacket.getData());
            System.out.println(modifiedMessage);
            if (message.equals("quit")) {
                break;
            }
        }
        clientSocket.close();
    }
}
