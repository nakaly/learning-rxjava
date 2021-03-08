package learning.rxjava.ch1;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_3 {
    public static void main(String[] args) {
        Observable<Long> secondIntervals =
                Observable.interval(1, TimeUnit.SECONDS);
        secondIntervals.subscribe(s -> System.out.println(s));
        /* Hold main thread for 5 seconds
           so Observable above has chance to fire */
        sleep(10000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
