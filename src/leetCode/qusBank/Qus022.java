package leetCode.qusBank;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1594 👎 0

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JinjieS
 * @Date: 2021/3/5 10:55
 */
public class Qus022 {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backTrack(ret,new StringBuilder(2 * n),0,n,n,n);
        return ret;
    }

    /**
     * 回溯方法
     * @param ret 存放结果集
     * @param sb 复用的字符串
     * @param index 动态字符串位数
     * @param n 括号对数
     * @param left 剩余左括号个数
     * @param right 剩余右括号个数
     */
    public void backTrack(List<String> ret,StringBuilder sb,int index,int n,int left,int right){
        if (index == 2 * n){
            ret.add(sb.toString());
            return;
        }
        if (left < right && right > 0){
            sb.append(')');
            backTrack(ret,sb,index + 1,n,left,right - 1);
            sb.deleteCharAt(index);
        }
        if (left > 0){
            sb.append('(');
            backTrack(ret,sb,index + 1,n,left - 1,right);
            sb.deleteCharAt(index);
        }

    }

    public static void main(String[] args) {
        Qus022 qus022 = new Qus022();
        for (String s : qus022.generateParenthesis(1)){
            System.out.println(s);
        }
    }
}
