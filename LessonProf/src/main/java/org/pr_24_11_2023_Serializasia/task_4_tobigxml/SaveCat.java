package org.pr_24_11_2023_Serializasia.task_4_tobigxml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class SaveCat {
    public static void main(String[] args) {
        try {
            File file = new File("cat.xml");
            file.createNewFile();
            Owner owner = new Owner("Alex", "+111111");
            List<Food> foods = List.of(
                    new Food("Hills", 4),
                    new Food("Purina", 5)
            );
            Cat cat = new Cat(3, "Black", 4.56, owner, foods);
            System.out.println(cat);
            JAXBContext context = JAXBContext.newInstance(Cat.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(cat, file);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
