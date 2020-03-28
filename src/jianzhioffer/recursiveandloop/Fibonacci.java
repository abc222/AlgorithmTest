package jianzhioffer.recursiveandloop;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci demo = new Fibonacci();
        System.out.println(demo.Fib(0));
        System.out.println(demo.Fib(1));
        System.out.println(demo.Fib(2));
        System.out.println(demo.Fib(8));
        System.out.println(demo.Fib(50));
        System.out.println(demo.Fib(100));
        System.out.println(demo.Fib(-5));
    }

    public long Fib(long n) {
        if (n < 0)
            throw new RuntimeException("下标错误，应从0开始！");
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long prePre = 0;
        long pre = 1;
        long result = 0;
        for (int i = 2; i <= n;i ++) {
            result = prePre + pre;
            prePre = pre;
            pre = result;
        }
        return result;
    }
}
