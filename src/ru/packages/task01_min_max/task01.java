import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() throws ExecutionException, InterruptedException {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();

    int[] array;

    array = inputManager.getIntArray();
    ExecutorService executor = Executors.newFixedThreadPool(2);
    Future<Integer> futureMax = executor.submit(() -> {
        return operationManager.getMax(array);
    });
    Future<Integer> futureMin = executor.submit(() -> {
       return operationManager.getMin(array);
    });
//    Runnable max = () -> {
//        System.out.println("Максимальное число из введенных: " + operationManager.getMax(array));
//    };
//    Runnable min = () -> {
//        System.out.println("Минимальное число из введенных: " + operationManager.getMin(array));
//    };
//    Thread maxThrd = new Thread(max);
//    Thread minThrd = new Thread(min);
//    maxThrd.start();
//    minThrd.start();
    executor.shutdown();
    System.out.println("Максимальное число из введенных: " + futureMax.get());
    System.out.println("Минимальное число из введенных: " + futureMin.get());
}







