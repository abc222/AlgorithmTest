package jianzhioffer.string;

// 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
// 则输出“We%20are%20happy.”。
// https://www.cnblogs.com/yongh/p/9328270.html
public class ReplaceSpaces {
    public static void main(String[] args) {
        StringBuffer sBuffer = new StringBuffer(" a b  c  ");
        String s = replaceSpaces(sBuffer);
        System.out.println(s);
    }

    public static String replaceSpaces(StringBuffer str) {
        if (str == null) {
            System.out.println("输入有误");
            return null;
        }
        int length = str.length();
        int indexOfOriginal = length - 1;
        for (int i = 0;i < str.length();i ++) {
            if (str.charAt(i) == ' ') {
                length += 2;
            }
        }
        str.setLength(length);
        int indexOfNew = length - 1;
        while (indexOfNew > indexOfOriginal) {
            if (str.charAt(indexOfOriginal) != ' ') {
                str.setCharAt(indexOfNew --, str.charAt(indexOfOriginal));
            } else {
                str.setCharAt(indexOfNew--, '0');
                str.setCharAt(indexOfNew--, '2');
                str.setCharAt(indexOfNew--, '%');
            }
            indexOfOriginal--;
        }
        return str.toString();
    }
}
