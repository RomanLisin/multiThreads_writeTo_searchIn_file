import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
   // List<Integer> array = new ArrayList<>();

    int max;
    int min;

    max = operationManager.getMax(inputManager.getIntArray());
    System.out.println("Максимальное число из введенных: " + max);
    min = operationManager.getMin(inputManager.getIntArray());
    System.out.println("Минимальное число из введенных: " + min);
}





