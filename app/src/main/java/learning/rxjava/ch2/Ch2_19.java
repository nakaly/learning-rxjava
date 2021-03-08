package learning.rxjava.ch2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class Ch2_19 {
    public static void main(String... args) {
        ConnectableObservable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).publish();
        seconds.subscribe(s -> System.out.println("1: " + s));
        seconds.connect();
        sleep(3000);
        seconds.subscribe(s -> System.out.println("2: " + s));
        sleep(3000);
        seconds.connect();

    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
