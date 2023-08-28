package noderush.taskneto;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1,2);   // 3
        int b = calc.minus.apply(1,1);  // 0
        // int c = calc.devide.apply(a, b);    // Арифимитическая ошибка на 0 делить нельзя (а = 3 делится на b = 0)

        if (calc.isPositive.test(a) && calc.isPositive.test(b)) { // 1.Вариант, использовал метод isPositive для проверки
            int c = calc.devide.apply(a, b);                      //   значений а и b.
            calc.println.accept(c);
        } else {
            System.out.println("Ошибка!!! Деление на 0.");
        }

        // ------------------>>>>>>>>
        try {                                                     // 2.Вариант, простой перехват ошибки через try / catch
            int c = calc.devide.apply(a , b);                     // тогда возникает вопрос для чего нам лямбда isPositive
            calc.println.accept(c);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка!!! Деление на 0.");
        }

        // ------------------>>>>>>>>
        if (calc.isPositive.test(a) && calc.isPositive.test(b)) { // 3.Вариант, использовал метод isPositive для проверки
            int c = calc.devide.apply(a, b);                      //   значений а и b и перехватил ошибку в блоке кода if-else
            calc.println.accept(c);
        } else {
            throw new ArithmeticException("Ошибка!!! Деление на 0.");
        }
    }
}