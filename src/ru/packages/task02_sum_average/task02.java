import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() throws ExecutionException, InterruptedException {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    ExecutorService executor = Executors.newFixedThreadPool(2);
    int[] array;

    array = inputManager.getIntArray();

    Future<BigDecimal> futureSum = executor.submit(() ->{
        return operationManager.findSum(array);
    });

    CompletableFuture<BigDecimal> futureAverage = CompletableFuture.supplyAsync(()-> operationManager.findAverage(array));
    executor.shutdown();
//    Thread calculateSum = new Thread(() -> {
//        System.out.println("Сумма всех элементов: " + operationManager.findSum(array));
//    });
//
//    Runnable average = () -> {
//        System.out.println("Среднее значение всех элементов: " + operationManager.findAverage(array));
//    };
//    Thread calculateAverage = new Thread(average);
//
//    calculateSum.start();
//    calculateAverage.start();
    System.out.println("Сумма всех элементов: " + futureSum.get());
    System.out.println("Среднее значение всех элементов: " + futureAverage.get());
}