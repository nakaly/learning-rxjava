package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_12 {
    public static void main(String... agrs) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        source.subscribe(System.out::println);
        source.map(String::length)
              .filter(i -> i >= 1)
              .subscribe(s -> System.out.println("Observer2:" + s));
    }
}
