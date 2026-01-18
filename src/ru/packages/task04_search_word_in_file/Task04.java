import ru.packages.FileManager;
import ru.packages.InputManager;
import ru.packages.OperationManager;

void main() {
    FileManager fileManager = new FileManager();

    int[] array;

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<int[]> searchWords = null;
    searchWords = executor.submit(()-> fileManager.findWordPositions("target.txt", "hello"));
    try {

        array = searchWords.get();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    executor.shutdown();

    if (array.length == 0) {
        System.out.println("Слов не найдено");
    } else {
        System.out.println("Количество найденных слов: " + array.length / 2);
        for(int i=0;i<array.length;i+= 2){
            System.out.println("Строка: " + array[i] + ", Слово: " + array[i+1]);
        }
    }

}