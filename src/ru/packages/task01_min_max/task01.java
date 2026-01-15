import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();

    int[] array;

    array = inputManager.getIntArray();

    Runnable max = () -> {
        System.out.println("Максимальное число из введенных: " + operationManager.getMax(array));
    };
    Runnable min = () -> {
        System.out.println("Минимальное число из введенных: " + operationManager.getMin(array));
    };

    Thread maxThrd = new Thread(max);
    Thread minThrd = new Thread(min);

    maxThrd.start();
    minThrd.start();
}







