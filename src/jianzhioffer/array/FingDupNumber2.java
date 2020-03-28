package jianzhioffer.array;

/**
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3。
 */
public class FingDupNumber2 {

    public static void main(String[] args) {
        int a2[] = {2, 3, 5, 4, 3, 2, 6, 7};
        findDupNum(a2);
    }

    public static void findDupNum(int[] arr) {
        if (arr == null || arr.length < 1) {
            System.out.println("输入数组无效");
            return;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数组超出范围");
                return;
            }
        }
        int start = 1;
        int end = arr.length - 1;
        int mid, count;
        while (start <= end) {
            mid = ((end - start) / 2) + start;
            count = countRange(arr, start, mid);
            if (start == end) {
                if (count > 1) {
                    System.out.println(start);
                    return;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
    }

    public static int countRange(int[] arr, int start, int end) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int a : arr) {
            if (a >= start && a <= end) {
                count++;
            }
        }
        return count;
    }
}
