import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    
    int[] array;

    array = inputManager.getIntArray();
    System.out.println("Максимальное число из введенных: " + operationManager.getMax(array));
    System.out.println("Минимальное число из введенных: " + operationManager.getMin(array));
}







