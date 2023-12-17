package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Storage storage = new Storage();

        Manufacturer manufacturer1 = new Manufacturer(storage);
        Manufacturer manufacturer2 = new Manufacturer(storage);
        Manufacturer manufacturer3 = new Manufacturer(storage);
        manufacturer1.start();
        manufacturer2.start();
        manufacturer3.start();

        Consumer consumer1 = new Consumer(storage);
        Consumer consumer2 = new Consumer(storage);
        Consumer consumer3 = new Consumer(storage);
        consumer1.start();
        consumer2.start();
        consumer3.start();



    }
}
