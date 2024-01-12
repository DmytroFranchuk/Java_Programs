package org.example.task2.connections;

import java.util.Random;

public class Connector {
    private static final Random random = new Random();
    private static final int CONNECTION_TIME_THRESHOLD = 300;

    public static Connection getConnection() {
        int connectionTime = random.nextInt(600);
        if (connectionTime < CONNECTION_TIME_THRESHOLD) {
            return new FastConnection("fast-host", 8080, "https");
        } else {
            return SlowConnection.getInstance("slow-host", 21, "ftp");
        }
    }
}
