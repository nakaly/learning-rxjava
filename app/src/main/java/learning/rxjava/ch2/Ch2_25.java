package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_25 {
    static int start = 1;
    static int count = 3;

    public static void main(String... args) {

        Observable<Integer> num = Observable.defer(() -> Observable.range(start, count));
        num.subscribe(System.out::println);
        count = 5;
        num.subscribe(System.out::println);
    }
}
