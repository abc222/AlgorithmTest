package jianzhioffer.array;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class FindDupNumber {

    public static void main(String[] args) {
        int a[] = {2, 3, 1, 0, 2, 5, 3};
        findDupNum(a);
    }

    public static void findDupNum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println(arr[i]);
                    return;
                }
                int tmp = arr[i];
                arr[i] = arr[tmp];
                arr[tmp] = tmp;
            }
        }
    }
}
