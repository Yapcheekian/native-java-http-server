package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        final ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            final Socket socket = serverSocket.accept();
            final OutputStream outputStream = socket.getOutputStream();
            final PrintWriter printWriter = new PrintWriter(outputStream);
            System.out.println("Connected to" + socket.getRemoteSocketAddress());
            printWriter.println("HTTP/1.0 200 OK");
            printWriter.println("Content-Length: 12");
            printWriter.println("");
            printWriter.println("Hello World!");
            printWriter.flush();
            System.out.println("Sent.");
            socket.close();
        }
    }
}
