package sort;

import java.util.Scanner;

public class printNum {

    public static void main(String[] args) {
        System.out.println("请输入小孩等级：");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String stringArray[] = inputString.split(" ");
        int num[] = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            num[i] = Integer.parseInt(stringArray[i]);
        }
        calNum(num);
    }

    public static void calNum(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("输入错误");
            return;
        }
        int num[] = new int[arr.length];
        num[0] = 1;
        num[arr.length - 1] = 1;
        for(int i = 1; i < arr.length - 1; i ++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                num[i] = Math.max(num[i - 1], num[i + 1]) + 1;
            } else if (arr[i] > arr[i - 1] || arr[i] > arr[i + 1]){
                num[i] = Math.max(num[i - 1], num[i + 1]) + 1;
            } else {
                num[i] = 1;
            }
        }
        for (int i = 0; i < num.length; i ++) {
            System.out.print(num[i] + " ");
        }
    }
}
