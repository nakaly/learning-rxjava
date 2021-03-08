package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Ch2_28 {
    public static void main(String... args) {
        Single.just("hello")
              .map(String::length)
              .subscribe(System.out::println,
                         e -> System.out.println(e));
        Observable.just("Alpha", "Beta")
                  .first("Nil")
                  .map(String::length)
                  .subscribe(System.out::println,
                             e -> System.out.println(e));
        Observable.just("Alpha", "Beta")
                  .firstElement()
                  .map(String::length)
                  .subscribe(System.out::println,
                             e -> System.out.println(e));
        Maybe.empty()
             .subscribe(System.out::println,
                        e -> System.out.println(e),
                        () -> System.out.println("Done!"));
        Maybe.just("yes")
             .subscribe(System.out::println,
                        e -> System.out.println(e),
                        () -> System.out.println("Done!"));
        Observable.empty()
                  .subscribe(System.out::println,
                             e -> System.out.println(e),
                             () -> System.out.println("Done!"));
    }
}
