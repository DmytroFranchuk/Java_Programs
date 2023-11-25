package de.dzJava;

import de.dzJava.service.TestTask1;
import de.dzJava.service.TestTask2;
import de.dzJava.service.TestTask3;
import de.dzJava.service.TestTask4;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        // № 1
        System.out.println("===============================================================");
        System.out.println(TestTask1.toExData("Example2.json"));
        System.out.println("===============================================================");

        // № 2
        TestTask2 task2 = new TestTask2();
        task2.toJsonFile("Cars.json");
        System.out.println("===============================================================");

        // № 3
        TestTask3.printAgeFromJsonFile("Example1.json");
        System.out.println("===============================================================");

        // № 4
        List<String> imageUrls = Arrays.asList(
                "https://www.google.com/logos/doodles/2023/celebrating-allan-haozous-houser-6753651837110055.2-2x.png",
                "https://www.google.com/logos/doodles/2023/rashidi-yekinis-60th-birthday-6753651837109955.2-2x.png",
                "https://www.google.com/logos/doodles/2023/chuseok-2023-6753651837109944-2x.png",
                "https://www.google.com/logos/doodles/2023/mihaly-csikszentmihalyis-89th-birthday-6753651837109945.3-2xa.gif",
                "https://www.google.com/logos/doodles/2023/celebrating-ramon-lopez-velarde-6753651837109583-2x.png"
        );
        TestTask4.downloader(imageUrls);
        System.out.println("===============================================================");
    }
}
