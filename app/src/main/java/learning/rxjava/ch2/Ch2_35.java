package learning.rxjava.ch2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch2_35 {
    private static final CompositeDisposable disposables = new CompositeDisposable();

    public static void main(String... args) {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = seconds.subscribe(l -> System.out.println("Observer1: " + l));
        Disposable disposable2 = seconds.subscribe(l -> System.out.println("Observer2: " + l));
        disposables.addAll(disposable1, disposable2);
        sleep(3000);
        disposables.dispose();
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
