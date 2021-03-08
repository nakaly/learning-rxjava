package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch_08 {
    public static void main(String... args) {
        Observable<String> source = Observable.just("Alpha", "Beta", "Gamma");
        source.map(String::length)
              .filter(i -> i >= 5)
              .subscribe(i -> System.out.println("Recieved:" + i),
                         Throwable::printStackTrace,
                         () -> System.out.println("Done!"));
    }
}
