/**
 * Created by Jerry Wang on 14/07/2018.
 */
public class Division {
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend<0 ^ divisor<0)?1:-1;

        long dividendAbs = Math.abs((long)dividend);
        long divisorAbs = Math.abs((long)divisor);

        int result = 0;

        while (dividendAbs >= divisorAbs) {
            long denCopy = divisorAbs;
            long multiple = 1;

            while (dividendAbs >= denCopy << 1) {
                denCopy <<= 1; // << is multiply by 2
                multiple <<= 1;
            }

            dividendAbs -= denCopy; //ex 15 - 12
            result += multiple; //ex 4, then 1
        }

        return result * sign;
    }
}
