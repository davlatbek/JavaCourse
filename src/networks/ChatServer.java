package networks;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by davlet on 6/15/17.
 */
public class ChatServer {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket serverSocket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            serverSocket = new ServerSocket(6666);
            socket = serverSocket.accept();
            while (true){
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String messageReceived = dataInputStream.readUTF();
                System.out.println("Message received: " + messageReceived);

                System.out.println("Enter message: ");
                String messageSend = scanner.next();
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(messageSend);
                dataOutputStream.flush();

                if (messageSend.equals("exit")){
                    socket.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
