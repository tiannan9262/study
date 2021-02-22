package leetCode.qusBank;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2158 👎 0


import java.util.ArrayList;

/**
 * @Author: JinjieS
 * @Date: 2021/2/4 10:22
 */
public class Qus011 {
    public static int maxArea(int[] height) {
        if (height.length == 2){
            return Math.min(height[0],height[1]);
        }
        int tmp = (height.length - 1) * Math.min(height[0],height[height.length - 1]);
        int[] t1 = new int[height.length - 1];
        int[] t2 = new int[height.length - 1];
        System.arraycopy(height, 1, t1, 0, height.length - 1);
        System.arraycopy(height, 0, t2, 0, height.length - 1);
        if (height[0] <= height[height.length - 1]){
            return Math.max(tmp,maxArea(t1));
        }
        return Math.max(tmp,maxArea(t2));
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
}
