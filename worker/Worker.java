package noderush.taskneto.worker;

public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            try {
                if (i == 33) {
                    throw new RuntimeException("Task " + i + " is failed");
                }
                callback.onDone("Task " + i + " is done");
            } catch (RuntimeException e) {
                errorCallback.error(e.getMessage());
            }
        }
    }
}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void error(String result);
}
