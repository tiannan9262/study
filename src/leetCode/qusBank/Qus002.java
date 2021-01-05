package leetCode.qusBank;

import leetCode.res.ListNode;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5417 👎 0
public class Qus002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode = new ListNode(0,null); // 用于加法运算的当前节点
        ListNode head = curNode; // 头节点，直接返回
        int carry = 0; // 进位
        while (l1 != null || l2 != null){
            int sum = carry;
            if (l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10,null);
            curNode = curNode.next;
        }
        if (carry > 0){
            curNode.next = new ListNode(carry,null);
        }
        return head.next;
    }
}
