
package TCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientSide {
    public static void main(String[] args) throws Exception {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        Socket socket = new Socket("localhost", 4567);
        String message = userInput.readLine();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out.writeBytes(message + "\n");
        String modifiedMessage = inServer.readLine();
        System.out.println(modifiedMessage);

        socket.close();
    }
}
