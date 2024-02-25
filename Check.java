
import exceptions.IncorrectValueException;

public class Check {

    /**
     * Функция проверки валидности формата введенной даты
     *
     * @param date - введенная дата
     * @throws IncorrectValueException
     */
    public static void checkDateFormat(String date) throws IncorrectValueException {
        char[] checkData = date.toCharArray();
        if (checkData.length != 10 && (checkData[2] != '.' && checkData[5] != '.')) {
            throw new IncorrectValueException(
                    "Формат даты введен не правильно. Правильный формат ввода данных dd.mm.yyyy");
        }
    }

    /**
     * Функция проверки валидности формата телефона
     *
     * @param phoneNumber - введенный телефон
     * @throws IncorrectValueException
     */
    public static void checkPhoneNumberFormat(String phoneNumber) throws IncorrectValueException {
        try {
            long check = Long.parseLong(phoneNumber); // Ошибка приведения вида
        } catch (IncorrectValueException e) {
            throw new IncorrectValueException("Формат телефона пользователя введен не правильно. " +
                    "Правильный формат ввода данных 9601234567");
        }
    }

    /**
     * Функция проверки валидности формата пола
     *
     * @param gender - введенный пол
     * @throws IncorrectValueException
     */

    public static void checkGenderFormat(String gender) throws IncorrectValueException {
        if (!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new IncorrectValueException("Вы неправильно указали пол!\n" +
                    "Правильный формат ввода данных, если вы мужчина - 'm', если женщина - 'f'.");
        }
    }
}