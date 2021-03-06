package learning.rxjava.ch1;

import io.reactivex.rxjava3.core.Observable;

public class Ch1_1 {
    public static void main(String[] args) {
        Observable<String> myStrings =
                Observable.just("Alpha", "Beta", "Gamma");
        myStrings
                .map(String::length)
                .subscribe(System.out::println);
    }
}
