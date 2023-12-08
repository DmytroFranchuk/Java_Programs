package org.ls_2023_12_07_Thread2.model.writerReader.model;


public class Reader extends Thread {
    private final SharedResource resource;

    public Reader(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            resource.startReading();
            System.out.println("Reading data: " + resource.readData());
            resource.endReading();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
