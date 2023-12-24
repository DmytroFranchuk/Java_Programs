package org.example.Task3_Task4;

import org.example.Task3_Task4.exceptionsDate.ExceptionsDate;

public class DayInMonthValidator {
    public static void main(String[] args) {
        checkDate(1, 25);
        checkDate(13, 25);
        checkDate(2, 25);
        checkDate(2, 29);
        checkDate(4, 31);
        checkDate(4, 18);
        checkDate(0, 5);
    }

    public static void checkDate(int month, int day) {
        try {
            validate(month, day);
        } catch (ExceptionsDate e) {
            System.out.println(e.getMessage());
        }
    }

    public static void validate(int month, int day) throws ExceptionsDate {
        if (month < 1 || month > 12) throw new ExceptionsDate("номер месяца " + month +
                " невалидный. Допустимое значение от 1 до 12");
        if ((month == 2 && (day < 1 || day > 28)) ||
           (((month % 2 != 0 && month <= 7) || (month % 2 == 0 && month > 7)) && (day < 1 || day > 31)) ||
           (((month % 2 == 0 && month <= 7) || (month % 2 != 0 && month > 7)) && (day < 1 || day > 30)) )
        throw new ExceptionsDate("день месяца " + day +
                " невалидный. Допустимое значение для месяца " + month + " от 1 до " + availableDay(month));
        else System.out.println("дата корректна; месяц " + month + "; день " + day);
    }

    public static int availableDay(int month){
        if (month == 2) return 28;
        if (month ==1 || month==3 || month==5 || month ==7 || month ==8 || month==10 || month==12) return 31;
        else return 30;
    }
}
//Нужно написать class DayInMonthValidator с методом validate, который будет принимать 2 числа номер месяца и число
//месяцы должны быть в промежутке между 1 и 12, иначе выкинуть ошибку, что номер месяца невалидный
//количество дней в месяце зависит от номера месяца (считаем что в феврале всегда 28 дней), если больше или меньше 0,
//выкинуть какой-нибудь созданный свой Exception
