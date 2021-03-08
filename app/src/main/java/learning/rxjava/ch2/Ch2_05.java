package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_05 {
    public static void main(String... args) {
        Observable<String> source = Observable.just("ALpha", "Beta", "Gamma");
        source.map(String::length)
              .filter(l -> l >= 5)
              .subscribe(System.out::println);
    }
}
