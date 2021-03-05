package leetCode.qusBank;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1464 👎 0

/**
 * @Author: JinjieS
 * @Date: 2021/2/22 11:15
 */
public class Qus014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int index = 0;
        while (true){
            for (int i = 0; i < strs.length; i ++){
                if (index >= strs[i].length()){
                    return strs[0].substring(0,index);
                }
                if (strs[i].charAt(index) != strs[0].charAt(index)){
                    return strs[0].substring(0,index);
                }
                if (i == strs.length - 1){
                    index ++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        longestCommonPrefix(strs);
    }
}
