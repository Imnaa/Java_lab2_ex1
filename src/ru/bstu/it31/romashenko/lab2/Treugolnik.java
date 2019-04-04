package ru.bstu.it31.romashenko.lab2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

import javafx.application.Application;
import org.apache.logging.log4j.*;
import sun.rmi.runtime.Log;

import static java.lang.Math.sqrt;

/**
 * <p>Класс для работы с треугольником</p>
 *
 * @author Ромащенко Н.А.
 * @version 1.0
 * Дата: 21.02.19
 * Имя класса: Treugolnik
 * Назначение: для обработки операций, связанных с треугольником.
 */
public class Treugolnik {
    /**  */
    static final Logger Logger = LogManager.getLogger(Treugolnik.class);
    /**
     * Переменная для 1й стороны треугольника
     */
    private double a;
    /**
     * Переменная для 2й стороны треугольника
     */
    private double b;
    /**
     * Переменная для 3й стороны треугольника
     */
    private double c;
    /**
     * Переменная для периметра треугольника
     */
    private double p;
    /**
     * Переменная для площади треугольника
     */
    private double s;

    /**
     * Метод для получения значения переменной a
     *
     * @return возващает значение переменной a
     */
    public double getA() {
        return a;
    }

    /**
     * Метод для получения значения переменной b
     *
     * @return возващает значение переменной b
     */
    public double getB() {
        return b;
    }

    /**
     * Метод для получения значения переменной c
     *
     * @return возващает значение переменной c
     */
    public double getC() {
        return c;
    }

    /**
     * Метод для получения значения переменной p
     *
     * @return возващает значение переменной p
     */
    public double getP() {
        return p;
    }

    /**
     * Метод для получения значения переменной s
     *
     * @return возващает значение переменной s
     */
    public double getS() {
        return s;
    }

    /**
     * Метод для установки нового значения для переменной a
     *
     * @param a 1ая сторона треугольника
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Метод для установки нового значения для переменной b
     *
     * @param b 2ая сторона треугольника
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Метод для установки нового значения для переменной c
     *
     * @param c 3ая сторона треугольника
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Метод для установки нового значения для переменной p
     *
     * @param p периметр треугольника
     */
    public void setP(double p) {
        this.p = p;
    }

    /**
     * Метод для установки нового значения для переменной s
     *
     * @param s площадь треугольника
     */
    public void setS(double s) {
        this.s = s;
    }

    /**
     * Конструктор класса
     */
    public Treugolnik() {
        Logger.debug("Был создан объект 'Treugolnik' с помощью конструктора 'Treugolnik()'");
        this.a = -1;
        this.b = -1;
        this.c = -1;

        Logger.debug("a = " + a);
        Logger.debug("b = " + b);
        Logger.debug("c = " + c);

    }

    /**
     * Конструктор класса
     *
     * @param a 1ая сторона треугольника
     * @param b 2ая сторона треугольника
     * @param c 3ая сторона треугольника
     */
    public Treugolnik(double a, double b, double c) {
        Logger.info("Был создан объект 'Treugolnik' с помощью конструктора 'Treugolnik(double a, double b, double c)'");
        this.a = a;
        this.b = b;
        this.c = c;

        Logger.debug("a = " + a);
        Logger.debug("b = " + b);
        Logger.debug("c = " + c);
    }

    /**
     * Метод для вычисления периметра
     *
     * @return возращает периметр треугольника
     */
    public double getPerimatr() {
        if (!check()) {
            Logger.warn("Периметр не прошел проверку.");
            return -1;
        }

        Logger.debug("Успешно посчитали периметр");
        return (this.a + this.b + this.c) / 2;
    }

    /**
     * Метод для вычисления площади треугольника
     *
     * @return возвращает площадь треугольника
     */
    public double getPloshad() {
        if (!check()) {
            Logger.warn("Площадь не прошел проверку.");
            return -1;
        }

        Logger.info("Успешно посчитали площадь");

        Logger.debug("s = " + sqrt(this.p * (this.p - this.a) * (this.p - this.b) * (this.p - this.c)));

        return sqrt(this.p * (this.p - this.a) * (this.p - this.b) * (this.p - this.c));
    }

    /**
     * Метод для проверки на правильность треугольника
     *
     * @return возвращает результат функции
     */
    private boolean check() {
        if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
            Logger.warn("Сторона(-ы) не могут быть <= 0. Следовательно, треугольник невозможен.");
            return false;
        } else if (this.a + this.b <= this.c || this.a + this.c <= this.b || this.b + this.c <= this.a) {
            Logger.warn("Сумма двух сторон не может быть меньше третьей. Следовательно, треугольник невозможен.");
            return false;
        }
        Logger.info("Проверка треугольника успешна.");
        return true;
    }

    /**
     * Считываение сторон треугольника
     */
    public void getValueFromFile() {
        Logger.debug("Начало чтения из файла.");

        try (FileReader reader = new FileReader("ex1.txt")) {
            BufferedReader r = new BufferedReader(reader);

            String temp = r.readLine();
            this.a = Double.parseDouble(temp);
            Logger.debug("a = " + a);

            temp = r.readLine();
            this.b = Double.parseDouble(temp);
            Logger.debug("b = " + b);

            temp = r.readLine();
            this.c = Double.parseDouble(temp);
            Logger.debug("c = " + c);

            Logger.debug("Конец чтения из файла.");
        } catch (IOException ex) {
            Logger.fatal("Файл не найден. Err:", ex);
            ex.printStackTrace();
        }
    }

    /**
     * Вывод сторон треугольника
     */
    public void printValueInFile() {
        Logger.info("Начало записи в файл.");

        try (FileWriter writer = new FileWriter("ex1_otvet.txt", false)) {
            String text = ""
                    + "a = " + a + '\n'
                    + "b = " + b + '\n'
                    + "c = " + c + '\n'
                    + "p = " + p + '\n'
                    + "s = " + s + '\n';
            writer.write(text);

            Logger.debug("a = " + a);
            Logger.debug("b = " + b);
            Logger.debug("c = " + c);
            Logger.debug("p = " + p);
            Logger.debug("s = " + s);

            Logger.info("В файл записали.");
        } catch (IOException ex) {
            Logger.fatal("В файл не записали. ", ex);
            ex.printStackTrace();
        }
    }
}