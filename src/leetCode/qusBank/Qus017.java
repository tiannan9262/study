package leetCode.qusBank;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1141 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: JinjieS
 * @Date: 2021/2/24 11:20
 */
public class Qus017 {
    public static void main(String[] args) {
        Qus017 qus017 = new Qus017();
        List<String> strs = qus017.letterCombinations("23");
        for (String s : strs){
            System.out.println(s);
        }
    }
    // 遍历树的所有子节点
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.length() == 0){
            return res;
        }
        String[] phoneButtons = new String[]{"","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backTrack(res,new StringBuilder(),0,phoneButtons,digits);
        return res;
    }
    public void backTrack(List<String> combinations,StringBuilder combination,int index,String[] phoneButtons,String digits){
        if (index == digits.length()){
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneButtons[Integer.parseInt(String.valueOf(digit))];
            for (int i = 0;i < letters.length();i ++){
                combination.append(letters.charAt(i));
                backTrack(combinations,combination,index + 1,phoneButtons,digits);
                combination.deleteCharAt(index);
            }
        }
    }
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack1(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack1(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            // 子节点
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack1(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
