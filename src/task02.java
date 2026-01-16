import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    int[] array;

    array = inputManager.getIntArray();

    Thread findSum = new Thread(() -> {
        System.out.println("Сумма всех элементов: " + operationManager.findSum(array));
    });

    Runnable average = () -> {
        System.out.printf("Среднее значение всех элементов: " + operationManager.findAverage(array));
    };
    Thread findAverage = new Thread(average);

    findSum.start();
    findAverage.start();

}