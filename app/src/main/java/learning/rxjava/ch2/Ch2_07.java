package learning.rxjava.ch2;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ch2_07 {
    public static void main(String... args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                // do nothing
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println("Received:" + integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        };
        source.map(String::length)
              .filter(i -> i >= 5)
              .subscribe(myObserver);
    }
}
