package SS3;

import com.company.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Khai báo 10 Runnable, và "quăng" chúng vào Thread Pool vừa khai báo
        for (int i = 1; i <= 10; i++) {
            com.company.MyRunnable myRunnable = new MyRunnable("Runnable " + i);
            executorService.execute(myRunnable);
        }

        // Phương thức này sẽ được nói sau ở ExecutorService
        executorService.shutdown();
    }
}
