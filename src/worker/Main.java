package src.worker;

public class Main {
    public static void main(String[] args) {
        OnTaskDoneListener listener = System.out::println;          // статический вывод (лямбда)
        OnTaskErrorListener errorListener = System.out::println;    // статический вывод (лямбда)

        Worker worker = new Worker(listener, errorListener);        // обьект класса worker

        worker.start();                                             // метод запуска обьекта Worker
    }
}
