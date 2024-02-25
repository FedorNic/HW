
import exceptions.ArrayCountElementException;
import exceptions.EmptyStringException;
import exceptions.IncorrectValueException;

import java.io.IOException;
import java.util.Scanner;

public class DataGet {

    public static Scanner scanner;
    public static String inputData;

    public static void getData()
            throws EmptyStringException, ArrayCountElementException, IncorrectValueException, IOException {

        scanner = new Scanner(System.in);
        System.out.println("Введите данные в порядке указанном ниже латиницей:\n" +
                " <Фамилия> <Имя> <Отчество> <Дата рождения> <Телефон> <Пол>\n " +
                "Пример:\n" +
                "Dmitriev Fedor Nikolaevich 04.12.1985 9601234567 m");
        inputData = scanner.nextLine();
        if (inputData.isEmpty()) {
            throw new EmptyStringException("Строка является пустой");
        }

        String[] bufferArray = inputData.trim().replaceAll("\\s+", " ").split(" ");
        if (bufferArray.length == 6) {
            Check.checkDateFormat(bufferArray[3]);
            Check.checkPhoneNumberFormat(bufferArray[4]);
            Check.checkGenderFormat(bufferArray[5]);
            DataWrite.createFile(bufferArray);
        } else {
            throw new ArrayCountElementException("Вы ввели не все данные или\n" +
                    "Вы пропустили пробел");
        }
    }
}