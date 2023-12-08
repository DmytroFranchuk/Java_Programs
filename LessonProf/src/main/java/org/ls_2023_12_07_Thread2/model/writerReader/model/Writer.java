package org.ls_2023_12_07_Thread2.model.writerReader.model;
public class Writer extends Thread {
    private final SharedResource resource;
    private final int value;

    public Writer(SharedResource resource, int value) {
        this.resource = resource;
        this.value = value;
    }

    public void run() {
        try {
            resource.startWriting();
            System.out.println("Writing data: " + value);
            resource.writeData(value);
            resource.endWriting();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

