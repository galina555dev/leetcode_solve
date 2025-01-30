package EX2;

public class Program2 {
    public static void main(String[] args) {
/*
Given a positive integer num, return true if num is a perfect square or false otherwise.
A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 */
    boolean result = false;

    System.out.println(result = isPerfectSquare(25));

}

    public static boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        long left = 2;
        long right = num;

        while(left<=right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid-1;
            } else if (mid * mid < num) {
                left = mid+1;
            }
        }
        return false;

    }

}
