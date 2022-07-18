package learning.rxjava;

import java.util.HashMap;

class Solution {
    public static void main(String...args){
        System.out.println(new Solution().countBalls(10008765, 100000000000L));
    }

    public long countBalls(long lowLimit, long highLimit) {

        HashMap<Long, Long> map = new HashMap<>();
        long prev = -1;
        long init = -1;
        for (long i = lowLimit; i <= highLimit; i++) {

            long sum = 0;
            if (i % 10 == 0) {
                if (init == -1) {
                    long temp = i;
                    while (temp > 0) {
                        sum = sum + temp % 10;
                        temp = temp / 10;
                    }
                    init = sum;
                    prev = sum;
                } else if (i % 100 == 0) {
                    long temp = i;
                    while (temp > 0) {
                        sum = sum + temp % 10;
                        temp = temp / 10;
                    }
                    init = sum;
                    prev = sum;
                } else {
                    prev = ++init;
                    sum = prev;
                }

            } else if (prev == -1) {
                long temp = i;
                while (temp > 0) {
                    sum = sum + temp % 10;
                    temp = temp / 10;
                }
                prev = sum;
            } else {
                sum = ++prev;
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1L);
            }
        }

        long max = 0;
        long ball = 0;
        for (Long i : map.keySet()) {
            long value = map.get(i);
            if (value > max) {
                max = value;
                ball = i;
            }
        }

        return max;
    }
}
