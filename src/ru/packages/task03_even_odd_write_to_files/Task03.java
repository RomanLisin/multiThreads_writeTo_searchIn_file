import ru.packages.FileManager;
import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() throws IOException {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    FileManager fileManager = new FileManager();
    int[] allNumbers;

    allNumbers = fileManager.readNumbersFromFile("NumbersArray.txt");

    Thread evenThread = new Thread(() -> {
        try {
            fileManager.writeNumbersToFileByCleanOld("EvenNumbers.txt", operationManager.findEven(allNumbers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } );

    Thread oddThread =new Thread(() -> {
        try {
            fileManager.writeNumbersToFileByCleanOld("OddNumbers.txt", operationManager.findOdd(allNumbers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });

    evenThread.start();
    oddThread.start();


}