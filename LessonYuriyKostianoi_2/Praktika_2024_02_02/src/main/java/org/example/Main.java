package org.example;

// Напишите два контроллера, где первый принимает имя пользователя и передает его второму контроллеру
// через редирект. Для этого
// внедрите бин RedirectAttributes в метод первого контроллера
// добавьте в бин атрибут name и его значение
// верните из метода строку по шаблону "redirect:/путь_к_методу_второго_контроллера"

// Создайте контроллер, который анализирует заголовки GET-запроса.
// Если заголовков меньше 3, то возвращает код 400.
// Если присутствует заголовок X-Error-Result, равный true, то возвращает код 500.
// Если указан заголовок X-Forward-Path, то делает редирект на указанный путь.
// В остальных случаях возвращает все заголовки в виде строки.

public class Main {
}
