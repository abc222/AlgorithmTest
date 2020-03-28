package jianzhioffer.array;

//https://www.cnblogs.com/yongh/p/9619591.html#_label2
// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class FindIn2DArray {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
        find(matrix, 7);
    }

    public static void find(int[][] matrix, int a) {
        // 假设数组输入是符合预期的
        // 这里没有做数组的检测

        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column  >= 0) {
            int x = matrix[row][column];
            if (x == a) {
                System.out.println("下标: [" + row + ", " + column + "]");
                return;
            } else if (x > a) {
                column --;
            } else {
                row ++;
            }
        }
        System.out.println("没找到");
    }
}

