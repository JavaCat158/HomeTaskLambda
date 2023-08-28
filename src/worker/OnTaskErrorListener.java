package src.worker;

@FunctionalInterface
public interface OnTaskErrorListener {
    void error(String result);
}
