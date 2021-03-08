package learning.rxjava.ch2;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_06 {
    public static void main(String... args) {
        Observable<String> source = Observable.fromIterable(List.of("ALpha", "Beta", "Gamma"));
        source.map(String::length)
              .filter(l -> l >= 5)
              .subscribe(System.out::println);
    }
}
