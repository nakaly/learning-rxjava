package learning.rxjava.ch2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch2_33 {
    public static void main(String... args) {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = seconds
                .subscribe(i -> System.out.println("Received " + i));
//                           e -> System.out.println(e),
//                           () -> System.out.println("Done!"));
        sleep(3000);
        disposable.dispose();
        sleep(5000);
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
