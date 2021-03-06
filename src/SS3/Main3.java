package SS3;

import com.company.MyCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> listFuture = new ArrayList<Future<String>>(); // Khởi tạo danh sách các Future

        for (int i = 1; i <= 10; i++) {
            // Dùng Callable thay cho Runnable
            com.company.MyCallable myCallable = new MyCallable("Callable " + i);

            Future<String> future = executorService.submit(myCallable);
            listFuture.add(future); // Từng Future sẽ quản lý một Callable
        }

        for (Future future : listFuture) {
            try {
                // Khi Thread nào kết thúc, get() của Future tương ứng sẽ trả về kết quả mà Callable return
                System.out.println(future.get() + " kết thúc");
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Phương thức này đã nói ở trên đây rồi
        executorService.shutdown();
    }
}
