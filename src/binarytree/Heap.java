package binarytree;

import java.util.Arrays;

public class Heap {

    /**
     * 上浮调整
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp保存插入的叶子节点值，用于最后的赋值
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            // 无须真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) /2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param array         待调整的堆
     * @param parentIdex    要下沉的父节点
     * @param length        堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIdex, int length) {
        // temp保存父节点的信息，用于最后赋值
        int temp = array[parentIdex];
        int childIndex = 2 * parentIdex + 1;
        while (childIndex < length) {
            // 如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex ++;
            }
            // 如果父节点小于任何一个孩子的信息 直接退出
            if (temp <= array[childIndex])
                break;
            // 无须真正交换，单向赋值即可
            array[parentIdex] = array[childIndex];
            parentIdex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIdex] = temp;
    }

    /**
     * 构建堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次做下沉调整
        for (int i = (array.length - 2) / 2;i >= 0; i --) {
            downAdjust(array, i, array.length);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
        upAdjust(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{7,1,3,10,5,2,8,9,6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }
}
