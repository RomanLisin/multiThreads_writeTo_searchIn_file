import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    int[] array;

    array = inputManager.getIntArray();

    Thread calculateSum = new Thread(() -> {
        System.out.println("Сумма всех элементов: " + operationManager.findSum(array));
    });

    Runnable average = () -> {
        System.out.println("Среднее значение всех элементов: " + operationManager.findAverage(array));
    };
    Thread calculateAverage = new Thread(average);

    calculateSum.start();
    calculateAverage.start();

}