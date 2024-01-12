package org.example.task2.connections;

public class SlowConnection extends Connection {
    private static volatile SlowConnection INSTANCE;

    private SlowConnection(String host, int port, String protocol) {
        super(host, port, protocol);
    }

    public static SlowConnection getInstance(String host, int port, String protocol) {
        if (INSTANCE == null) {
            synchronized (SlowConnection.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SlowConnection(host, port, protocol);
                }
            }
        }
        return INSTANCE;
    }
}
