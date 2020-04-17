package binarytree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    public static void main(String[] args) {
        String str = "我abbacd";
        // firstUniqChar(str);
        findChar(str);
    }

    public static void firstUniqChar(String s) {
        char[] chars = s.toCharArray();//转成 Char 数组
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c: chars) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if((map.get(chars[i])==1))
                System.out.println(map.get(chars[i]));
                return;
        }
    }

    public static void findChar(String s) {
        Map<Character, Integer> sMap = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (!sMap.containsKey(c)) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, sMap.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> en : sMap.entrySet()) {
            if (en.getValue() == 1) {
                System.out.println(en.getKey().toString());
                return;
            }
        }
    }

}
