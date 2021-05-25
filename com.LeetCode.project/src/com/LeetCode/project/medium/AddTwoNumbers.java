package com.LeetCode.project.medium;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 =
 * 807.
 * 
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0] Output: [0]
 * 
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * 
 * @author 05946N744
 *
 */
public class AddTwoNumbers {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		Result result = new Result();
		int carry = 0;

		while (l1 != null || l2 != null) {
			int n1 = (l1 == null) ? 0 : l1.val;
			int n2 = (l2 == null) ? 0 : l2.val;
			int sum = n1 + n2 + carry;
			result.append(sum % 10);
			carry = (sum > 9) ? 1 : 0;

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (carry > 0)
			result.append(1);

		return result.head.next;
	}

	private class Result {
		public ListNode head;
		public ListNode tail;

		public Result() {
			this.head = new ListNode();
			this.tail = head;
		}

		public void append(int val) {
			ListNode node = new ListNode(val);
			this.tail.next = node;
			this.tail = node;
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
