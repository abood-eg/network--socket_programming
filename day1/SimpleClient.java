package edu.fee;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Socket socket = new Socket("localhost",5050);


        InputStream inputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(inputStream);
        String serverMsg = socketDIS.readUTF();
        System.out.println(serverMsg);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(outputStream);
        String clientMsg = "Client: Hi Server, How are you!!";
        socketDOS.writeUTF(clientMsg);
        System.out.println(clientMsg);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter ur message please");
        String newMessage =("client:"+sc.nextLine());

        socketDOS.writeUTF(newMessage);
        System.out.println(newMessage);

        InputStream newsocketInputStream = socket.getInputStream();
        DataInputStream newsocketDIS = new DataInputStream(newsocketInputStream);

        String newclientResponse = newsocketDIS.readUTF();
        System.out.println(newclientResponse);


        socketDOS.close();
        socketDIS.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
