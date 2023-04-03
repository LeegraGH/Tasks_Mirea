import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        Callable<String> task = () -> Thread.currentThread().getName();
        MyExecutorService service = new MyExecutorService(3);
        for (int i = 0; i < 12; i++) {
            Future<String> result = service.submit(task);
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}