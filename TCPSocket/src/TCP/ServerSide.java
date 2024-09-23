
package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSide {
    public static void main(String[] args) throws Exception{
        final int port = 4567;
        ServerSocket serverSocket = new ServerSocket(port);
        while(true){
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String message = in.readLine() + "\n";
            String modifiedMessage = message.toUpperCase();
            out.writeBytes(modifiedMessage);
            return;
        }
    }
}
