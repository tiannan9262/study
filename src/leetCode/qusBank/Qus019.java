package leetCode.qusBank;
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1], n = 1
//输出：[]
//
//
// 示例 3：
//
//
//输入：head = [1,2], n = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 👍 1246 👎 0

import leetCode.resource.ListNode;

/**
 * @Author: JinjieS
 * @Date: 2021/3/3 16:57
 */
public class Qus019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }
        ListNode pre = head;
        ListNode target = head;
        ListNode current = head;
        int index = 0;
        while (current != null){
            if (index > n - 1){
                target = target.next;
            }
            if (index > n){
                pre = pre.next;
            }
            index ++;
            current = current.next;
        }
        if (index == n){
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}
