/**
 * <p>
 * Класс-конвертер километров и калорий
 * </p>
 * Created on 12.09.2022
 *
 * @author VAlferov
 */

public class LocalConverter { //такое название для избежания возможных конфликтов с базовыми классами
    public double getKilometersFromSteps(int steps) {
        return steps*75/100/1000; //последовательно переводим в сантимеры, метры и километры
    }

    public double getKiloCaloriesFromSteps(int steps) {
        return steps*50/1000; //последовательно переводим в калории и килокалории
    }
}
