package org.ls_2023_11_23_json_net_url.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Server extends Thread {

    private ServerSocket socket;

    public Server(int port) throws IOException {
        this.socket = new ServerSocket(port);
        this.socket.setSoTimeout(30000);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Waiting for connection to port " + socket.getLocalPort());
            try(Socket server = socket.accept()) {
                System.out.println("Подключился клиент: " + server.getRemoteSocketAddress());
                DataInputStream inputStream = new DataInputStream(server.getInputStream());
                String str = new String(inputStream.readUTF());
                System.out.println("Получили строку от клиента: " + str);

                String outStr = switch(str.toUpperCase()) {
                    case "DATE" -> LocalDate.now().toString();
                    case "TIME" -> LocalTime.now().toString();
                    default -> LocalDateTime.now().toString();
                };
                System.out.println("Строка отправлена - " + outStr);
                server.getOutputStream().write(outStr.getBytes(StandardCharsets.UTF_8));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Запущен сервер ...");
        try {
            Server localServer = new Server(1515);
            localServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
