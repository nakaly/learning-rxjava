package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_26a {
    public static void main(String[] args) {
        Observable.just(1 / 0)
                  .subscribe(System.out::println,
                             e -> System.out.println("Error captured:" + e));
    }
}
