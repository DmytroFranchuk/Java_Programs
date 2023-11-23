package org.ls_23_11_2023_json_net_url.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1515;
        try(Socket client = new Socket(host, port)){
            System.out.printf("Connection %s complite ", client.getRemoteSocketAddress());
            DataOutputStream toServer = new DataOutputStream(client.getOutputStream());
            toServer.writeUTF("DATE");
            InputStream fromServer = client.getInputStream();
            String date = new String(fromServer.readAllBytes(), Charset.defaultCharset());
            System.out.println(date);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
