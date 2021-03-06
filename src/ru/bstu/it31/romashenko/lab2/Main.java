package ru.bstu.it31.romashenko.lab2;
import java.util.Scanner;
import org.apache.logging.log4j.*;

/**
 * <p>Главный класс программы.</p>
 *
 * @author Ромащенко Н.А.
 * @version 1.0
 * Дата: 21.02.19
 *
 * Класс: Main
 * Описание: Даны три положительных числа а, Ь, с. Проверить, будут ли они сторонами треугольника. Если да, то вычислить площадь этого треугольника
 */
public class Main {
    /** */
    static final Logger Logger = LogManager.getLogger(Main.class);

    /**
     * <p>Точка входа в программу</p>
     *
     * @param args - аргументы для метода
     */
    public static void main(String[] args) {
        Logger.debug("Lets go!");

        System.out.println("Определение площади треугольника");
        System.out.println("\t> 1. Ввести стороны треугольника с помощью клавиатуры;");
        System.out.println("\t> 2. Считать из файла значения сторон треугольника;");
        System.out.println("\t> 9. Выход.");
        // Режим ввода данных
        // 1 - клавиатура
        // 2 - файл
        // 9 - выход

        // Инициализация объекта "Сканер"
        Scanner scanner = new Scanner(System.in);

        int mode = scanner.nextInt();

        // Инициализация объекта "Треугольник"
        Treugolnik treugolnik = new Treugolnik();

        // Обработка режима работы
        switch (mode) {
            // Клавиатура
            case 1: {
                Logger.info("Пользователь выбрал режим работы 'чтение с консоли'");

                // Ввод сторон треугольника
                System.out.print("a = ");
                treugolnik.setA(scanner.nextDouble());
                Logger.debug("Пользователь ввел в a = " + treugolnik.getA());

                System.out.print("b = ");
                treugolnik.setB(scanner.nextDouble());
                Logger.debug("Пользователь ввел в b = " + treugolnik.getB());

                System.out.print("c = ");
                treugolnik.setC(scanner.nextDouble());
                Logger.debug("Пользователь ввел в c = " + treugolnik.getC());

                scanner.close();
                break;
            }

            // Файл
            case 2: {
                System.out.println("Пользователь выбрал режим работы 'чтение из файла'");
                Logger.info("Пользователь выбрал режим работы 'чтение из файла'");

                // Функция для считывания из файла
                treugolnik.getValueFromFile();
                break;
            }
            // Выход
            case 9: {
                System.out.println("Пользователь выбрал режим работы 'выход'");

                Logger.info("Пользователь выбрал режим работы 'выход'");
                Logger.debug("Program is end.");
                return;
            }
            // Ошибка ввода
            default: {
                System.out.println("Выбран не верный параметр, программа завершила свою работу.");

                Logger.warn("Выбран не верный параметр, программа завершила свою работу.");
                Logger.debug("Program is end.");
                return;
            }
        }

        // Вычисление периметра
        double p = treugolnik.getPerimatr();

        if (-1 == p) {
            System.out.println("p не посчиталось вычислить");
            Logger.error("p не посчиталось вычислить");

            // Обработка ошибки
            Logger.debug("Program is end.");
            return;
        }
        Logger.info("Вычислили p = " + p);
        System.out.println(" > P = " + p);

        treugolnik.setP(p);

        // Вычисление площади
        double s = treugolnik.getPloshad();

        if (-1 == s) {
            System.out.println("s не посчиталось вычислить");
            Logger.error("s не посчиталось вычислить");

            // Обработка ошибки
            Logger.debug("Program is end.");
            return;
        }

        Logger.info("Вычислили s = " + s);
        treugolnik.setS(s);

        System.out.println(" > S = " + s);

        treugolnik.printValueInFile();

        Logger.debug("Program is end.");
    }
}