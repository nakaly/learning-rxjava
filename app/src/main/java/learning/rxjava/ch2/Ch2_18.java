package learning.rxjava.ch2;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_18 {
    public static void main(String... args) {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        seconds.subscribe(s -> System.out.println(LocalDateTime.now().getSecond() + ":" + s + "hi"));
        sleep(3000);
        seconds.subscribe(s -> System.out.println(LocalDateTime.now().getSecond() + ":" + s + "yeah"));
        sleep(3000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
