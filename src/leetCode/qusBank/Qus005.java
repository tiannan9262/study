package leetCode.qusBank;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2640 👎 0
public class Qus005 {
    // 动态规划
    // 状态转移方程：设p(i,j)表示i到j是否为回文，Boolean类型
    // p(i,j) = Si == Sj && p(i+1,j-1);
    // 约束条件：p(i,i) = true;
    //         p(i,i+1) = Si == Si+1;
    // 使用二维数组boolean[][] dp 保存计算过的数据
    public static String longestPalindromeDP(String s) {
        int length = s.length();
        String rtn = "";                                                            // 返回值
        boolean[][] dp = new boolean[length][length];
        for (int l = 0;l < length; ++ l){                                           // l = j - i,l+1为长度
            for (int i = 0;i < length - l; ++ i){
                int j = i + l;
                if (l == 0){
                    dp[i][j] = true;                                                // 初始化p(i,i) = true
                } else if (l == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);                          // 初始化p(i,i+1) = Si == Si+1
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);      // 其他情况：p(i,j) = Si == Sj && p(i+1,j-1);
                }
                if (dp[i][j] && l + 1 > rtn.length()){
                    rtn = s.substring(i,j + 1);                                     // 当长度大于当前rtn，替换之
                }
            }
        }
        return rtn;
    }

    // 中心扩散法
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 0){
            return "";
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for (int i = 0;i < s.length();i ++){
            int len1 = getMaxPalindromeLength(s,i,i);
            int len2 = getMaxPalindromeLength(s,i,i + 1);
            int len = Math.max(len1,len2);
            if (len > maxLength){
                start = i - (len - 1) / 2;
                end = start + len - 1;
            }
        }
        return s.substring(start,end);
    }
    public static int getMaxPalindromeLength(String s,int i,int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i --;
            j ++;
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("cbbd"));
    }

}
