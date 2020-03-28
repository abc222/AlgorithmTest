package jianzhioffer.dp;

/**
 *
 * @Description 面试题14：剪绳子
 *
 * @author yongh
 * @date 2018年9月17日 上午9:37:41
 */

// https://www.cnblogs.com/yongh/p/9660802.html

// 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
// 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
// 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
// 时得到最大的乘积18。

public class CuttingRope {
    // ======动态规划======
    public int maxProductAfterCutting_solution1(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] product = new int[length + 1]; // 用于存放最大乘积值
        // 下面几个不是乘积，因为其本身长度比乘积大
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        // 开始从下到上计算长度为i绳子的最大乘积值product[i]
        for (int i = 4; i <= length; i++) {
            int max = 0;
            // 算不同子长度的乘积，找出最大的乘积
            for (int j = 1; j <= i / 2; j++) {
                if (max < product[j] * product[i - j])
                    max = product[j] * product[i - j];
            }
            product[i] = max;
        }
        return product[length];
    }

    // =======贪婪算法========
    public int maxProductAfterCutting_solution2(int length) {
        if (length <= 1)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;
        int timesOf2 = 0;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
            // timesOf2=2;  //错误！
        }
        timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    // =====测试代码======
    void test(String testName, int length, int expected) {
        if (testName != null)
            System.out.println(testName + ":");
        if (maxProductAfterCutting_solution1(length) == expected) {
            System.out.print("    动态规划:" + "passed  ");
        } else {
            System.out.print("    动态规划:" + "failed  ");
        }

        if (maxProductAfterCutting_solution2(length) == expected) {
            System.out.println("贪婪算法:" + "passed  ");
        } else {
            System.out.println("贪婪算法:" + "failed  ");
        }
    }

    void test1() {
        test("test1", 1, 0);
    }

    void test2() {
        test("test2", 2, 1);
    }

    void test3() {
        test("test3", 3, 2);
    }

    void test4() {
        test("test4", 4, 4);
    }

    void test5() {
        test("test5", 5, 6);
    }

    void test6() {
        test("test6", 10, 36);
    }

    void test7() {
        test("test7", 50, 86093442);
    }

    public static void main(String[] args) {
        CuttingRope demo = new CuttingRope();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
