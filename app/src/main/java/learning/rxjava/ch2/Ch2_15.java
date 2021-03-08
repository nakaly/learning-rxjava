package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Observable;

public class Ch2_15 {
    public static void main(String... agrs) {
        Observable.range(1, 3).subscribe(System.out::println);
        Observable.range(4, 3).subscribe(System.out::println);
    }
}
