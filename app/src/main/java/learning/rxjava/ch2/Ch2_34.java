package learning.rxjava.ch2;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.ResourceObserver;

public class Ch2_34 {
    public static void main(String... args) {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        ResourceObserver<Long> myObserver = new ResourceObserver<>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        };
        seconds.subscribeWith(myObserver);
        sleep(3000);

    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
