package org.pr_2023_11_24_Serializasia.task_4_tobigxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class LoadCat {
    public static void main(String[] args) {
        try {
            File file = new File("cat.xml");
            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object cat = unmarshaller.unmarshal(file);
            System.out.println(cat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
