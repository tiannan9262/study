package leetCode.qusBank;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2206 👎 0

import java.util.Stack;

/**
 * @Author: JinjieS
 * @Date: 2021/3/4 17:02
 */
public class Qus020 {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        res.push(')');
        res.pop();
        for (int i = 0;i < s.length();i ++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                res.push(c);
            } else {
                if (res.empty()){
                    return false;
                }
                char tmp = res.pop();
                if (c != getAnother(tmp)){
                    return false;
                }
            }
        }
        return res.empty();
    }
    // 优化：使用hashMap键值对存放
    public char getAnother(Character c){
        switch (c){
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return '!';
    }

    public static void main(String[] args) {
        Qus020 qus020 = new Qus020();
        if (qus020.isValid("]")){
            System.out.println("true");
        }
    }
}
