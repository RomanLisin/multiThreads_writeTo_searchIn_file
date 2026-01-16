import ru.packages.FileManager;
import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() throws IOException {
    InputManager inputManager = new InputManager();
    OperationManager operationManager = new OperationManager();
    FileManager fileManager = new FileManager();

    fileManager.writeNumbersToFileByCleanOld("NewFile.txt", fileManager.readNumbersFromFile("NumbersArray.txt"));

}