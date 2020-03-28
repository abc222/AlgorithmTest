package bitoperation;

public class PowerOf2 {

    public static boolean isPowerOf2( int num) {
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(33));
    }
}
