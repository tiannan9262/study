package leetCode.qusBank;

/**
 * @Author: JinjieS
 * @Date: 2021/2/2 11:04
 */
public class Qus008 {
    public static int myAtoi(String s) {
        int index = 0;
        int rtn = 0;
        boolean isNegative = false;
        while (index < s.length()){
            if (s.charAt(index) == ' ' || s.charAt(index) == '+'){
                index ++;
                continue;
            } else if (s.charAt(index) == '-'){
                if (!isNegative){
                    isNegative = true;
                    index ++;
                    continue;
                } else {
                    return rtn * -1;
                }
            } else if ((int)s.charAt(index) > (int)'9' || (int)s.charAt(index) < (int)'0'){
                return rtn;
            } else if ((int)s.charAt(index) <= (int)'9' && (int)s.charAt(index) >= (int)'0'){
                if (!isNegative && (rtn > Integer.MAX_VALUE / 10 || (rtn == Integer.MAX_VALUE / 10 && (int)s.charAt(index) > Integer.MAX_VALUE %10))){
                    System.out.println("max!!!!!");
                    return Integer.MAX_VALUE;
                } else if (isNegative && (rtn > Integer.MAX_VALUE / 10 || (rtn == Integer.MAX_VALUE / 10 && (int)s.charAt(index) > Integer.MAX_VALUE %10 + 1))){
                    System.out.println("min!!!!!");
                    return Integer.MIN_VALUE;
                }
                rtn = rtn * 10 + (int)s.charAt(index) - (int)('0');
            }
            System.out.println("nomal!!!!!!");
            index ++;
        }
        return isNegative ? rtn * -1 : rtn;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }
}
