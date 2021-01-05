package classic;
// 动态规划算法
public class DynamicProgramming {
    public static void main(String[] args) {
        System.out.println(getMinCoins(7));

    }

    // 找零问题：对于需要找零的整数n，有1，3，4三种金额的硬币，求至少需要几枚硬币。
    public static int getMinCoins(int n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (n == 2){
            return 2;
        } else if (n == 3){
            return 1;
        } else if (n == 4){
            return 1;
        }
        return Math.min(Math.min(getMinCoins(n - 4),getMinCoins(n - 3)),getMinCoins(n - 1))+1;
    }

}
