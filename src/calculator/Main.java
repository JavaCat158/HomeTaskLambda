package src.calculator;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1,2);   // 3
        int b = calc.minus.apply(1,1);  // 0
        int c = calc.devide.apply(a, b);    // Арифимитическая ошибка на 0 делить нельзя (а = 3 делится на b = 0)

        calc.println.accept(c);

    }
}