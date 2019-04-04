package ru.bstu.it31.romashenko.lab2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import org.apache.logging.log4j.*;

/** @author Ромащенко Н.А.
 *
 * @version 1. 21.02.19
 *
 * Имя класса: Treugolnik
 *
 * Назначение: для обработки операций, связанных с треугольником.
 */

import static java.lang.Math.sqrt;

public class Treugolnik {
    static final Logger Logger = LogManager.getLogger(Treugolnik.class);

    private double a;
    private double b;
    private double c;
    private double p;
    private double s;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getP() {
        return p;
    }

    public double getS() {
        return s;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void setP(double p) {
        this.p = p;
    }

    public void setS(double s) {
        this.s = s;
    }

    public Treugolnik() {
        Logger.info("Был создан объект 'Treugolnik' с помощью конструктора 'Treugolnik()'");
        this.a = -1;
        this.b = -1;
        this.c = -1;
    }

    public Treugolnik(double a, double b, double c) {
        Logger.info("Был создан объект 'Treugolnik' с помощью конструктора 'Treugolnik(double a, double b, double c)'");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Метод для вычисления периметра
    public double getPerimatr() {
        if (!check()) {
            Logger.warn("Периметр не прошел проверку.");
            return -1;
        }
        Logger.info("Успешно посчитали периметр");
        return (this.a + this.b + this.c) / 2;
    }

    // Метод для вычисления площади треугольника
    public double getPloshad() {
        if (!check()) {
            Logger.warn("Площадь не прошел проверку.");
            return -1;
        }
        Logger.info("Успешно посчитали площадь");
        return sqrt(this.p * (this.p - this.a) * (this.p - this.b) * (this.p - this.c));
    }

    // Метод для проверки на правильность треугольника
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

    // Считываение сторон треугольника
    public void getValueFromFile() {
        Logger.info("Начало чтения из файла.");
        try (FileReader reader = new FileReader("ex1.txt")) {
            BufferedReader r = new BufferedReader(reader);
            String temp = r.readLine();
            this.a = Double.parseDouble(temp);
            temp = r.readLine();
            this.b = Double.parseDouble(temp);
            temp = r.readLine();
            this.c = Double.parseDouble(temp);

        } catch (IOException ex) {
            Logger.fatal("Файл не найден. ", ex);
        }
    }

    // Считываение сторон треугольника
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
            Logger.info("В файл записали.");
        } catch (IOException ex) {
            Logger.fatal("В файл не записали. ", ex);
        }
    }
}