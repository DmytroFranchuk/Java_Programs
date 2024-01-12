package org.example.task2.connections;

public class Connection {
    private int id;
    private String host;
    private int port;
    private String protocol;
    private static int newId = 0;

    public Connection(String host, int port, String protocol) {
        newId++;
        this.id = newId;
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    public Connection() {
    }

    public int getId() {
        return id;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "id=" + id +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", protocol='" + protocol + '\'' +
                '}';
    }
}
