package leetCode.qusBank;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 2945 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JinjieS
 * @Date: 2021/2/7 14:42
 */
public class Qus015 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int index = 0; index < length; index ++){
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            int i = index + 1;
            int j = length - 1;
            while (i < j){
                if (nums[i] + nums[j] + nums[index] > 0 || (j < length - 1 && nums[j] == nums[j + 1])){
                    j --;
                }
                else if (nums[i] + nums[j] + nums[index] < 0 || (i > index + 1 && nums[i] == nums[i - 1])){
                    i ++;
                }
                else if (nums[i] + nums[j] + nums[index] == 0){
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[index]);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    res.add(tmp);
                    i ++;
                    j --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
