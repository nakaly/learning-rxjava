package learning.rxjava.ch2;

import io.reactivex.rxjava3.core.Completable;

public class Ch2_32 {
    public static void main(String... args) {
        Completable.fromRunnable(Ch2_32::runProcess)
                   .subscribe(() -> System.out.println("Done!"));
    }

    private static void runProcess() {
        System.out.println("Run!");
    }
}
