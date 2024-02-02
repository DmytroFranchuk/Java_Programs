package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/truth")
    public String showTruth(){
        System.out.println("showTruth");
        return "show_truth";
    }

    @GetMapping("/lie")
    public String showLie(){
        System.out.println("showLie");
        return "show_lie";
    }


}
//1 Создайте класс FirstController и пометьте его аннотацией @Controller.
//2 В классе создайте GET-запрос, ответом на который станет ранее созданный файл
//show_truth.html. С учётом предыдущих настроек, достаточно вернуть из метода имя
//нужного представления (без пути, без расширения файла).
//3 Запустите приложение и перейдите по URL, чтобы получить страницу show_truth.html от
//сервера.
//4 В приложение нужно добавить функциональность «говорить ложь». Доработайте
//приложение.
