package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class Ch2_14 {
    public static void main(String... args) {
        Observable<String> coldSource = Observable.just("Alpha", "Beta", "Gamma");
        ConnectableObservable<String> source = coldSource.publish();
        source.subscribe(System.out::println);
        source.map(String::length)
              .subscribe(System.out::println);
        source.connect();
        source.connect();
//        coldSource.subscribe(System.out::println);

    }
}
