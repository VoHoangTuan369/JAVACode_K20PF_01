package SS2;

import com.company.NumberAccount;

public class Main {
    public static void main(String[] args) {
        com.company.NumberAccount acc = new NumberAccount();

        new Thread(()->{
            acc.sub(50000);
        }).start();

        new Thread(()->{
            acc.add(100000);
        }).start();
    }
}
