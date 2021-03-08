package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_26b {
    public static void main(String[] args) {
        Observable.fromCallable(() -> 1 / 0)
                  .subscribe(System.out::println,
                             e -> System.out.println("Error captured:" + e));
        Observable.just(1)
                  .map(s -> s / 0)
                  .subscribe(System.out::println,
                             e -> System.out.println("Error captured:" + e));
    }
}
