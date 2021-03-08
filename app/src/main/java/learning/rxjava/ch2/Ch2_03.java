package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_03 {
    public static void main(String... args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onComplete();
        });
        Observable<Integer> lengths = source.map(String::length);
        Observable<Integer> filtered = lengths.filter(l -> l >= 5);
        filtered.subscribe(System.out::println);

    }
}
