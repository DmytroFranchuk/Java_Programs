package org.example.task2.connections;

public class FastConnection extends Connection {

    public FastConnection(String host, int port, String protocol) {
        super(host, port, protocol);
    }

    public FastConnection clone(FastConnection original) {
        return new FastConnection(original.getHost(), original.getPort(), original.getProtocol());
    }
}
