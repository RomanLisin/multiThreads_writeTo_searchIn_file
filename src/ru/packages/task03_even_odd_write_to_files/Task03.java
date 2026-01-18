import ru.packages.FileManager;
import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() throws IOException {
    OperationManager operationManager = new OperationManager();
    FileManager fileManager = new FileManager();
    int[] allNumbers;

    allNumbers = fileManager.readNumbersFromFile("NumbersArray.txt");
    ExecutorService executor = Executors.newFixedThreadPool(2);

    Future<Integer> numEven= executor.submit(() -> {
           return fileManager.writeNumbersToFileByCleanOld("EvenNumbers.txt", operationManager.findEven(allNumbers));
    });

//    Thread oddThread =new Thread(() -> {
//        try {
//            fileManager.writeNumbersToFileByCleanOld("OddNumbers.txt", operationManager.findOdd(allNumbers));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    });
    Future<Integer> numOdd = executor.submit(() -> fileManager.writeNumbersToFileByCleanOld("OddNumbers.txt", operationManager.findOdd(allNumbers)));
    executor.shutdown();
    //evenThread.start();
    //oddThread.start();
    try {
        System.out.println("Количество четных чисел: " + numEven.get());
        System.out.println("Количество нечетных чисел: " + numOdd.get());
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } catch (ExecutionException e) {
        throw new RuntimeException(e);
    }

}