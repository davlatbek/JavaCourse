package networks;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by davlet on 6/15/17.
 */
public class ChatClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 6666);
            while(true){
                System.out.println("Enter message: ");
                String messageSend = scanner.next();
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(messageSend);
                dataOutputStream.flush();

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String messageReceived = dataInputStream.readUTF();
                System.out.println("Message Recieved: " + messageReceived);

                if (messageSend.equals("exit")) {
                    dataOutputStream.flush();
                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
