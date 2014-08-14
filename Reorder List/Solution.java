//先用快慢指针法将链表分成两部分。注意最后slow指针指的是中间部分
//再把第二部分翻转
//再合并
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	ListNode reverseAll(ListNode h){ //reverse a linked list
		if(h==null || h.next==null)
			return h;
		ListNode newHead = h;
		h = h.next;
		newHead.next = null;
		ListNode nxt;
		while(h!=null){ 
			nxt = h.next;
			h.next = newHead;
			newHead = h;
			h = nxt;
		}		
		return newHead;
	}
	public ListNode reorderList(ListNode head){
		if(head==null || head.next==null || head.next.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre =slow;
		while(fast!=null && fast.next!=null){
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode h2 = slow;			
		h2 = reverseAll(h2);
		ListNode h1 = head;
		int i = 0;
		ListNode dummy = new ListNode(0);
		ListNode ptr = dummy;
		while(h1!=null || h2!=null){
			if(i%2==0){
				if(h1 != null){
					ptr.next = h1;
					h1 = h1.next;			
					ptr = ptr.next;
				}
			}else{
				if(h2 != null){
					ptr.next = h2;
					h2 = h2.next;
					ptr = ptr.next;
				}				
			}			
			i++;
		}
		return dummy.next;
	}
	public static void main(String[] args){
		ListNode t = new ListNode(1);
		t.next = new ListNode(2);
		t.next.next = new ListNode(3);
		t.next.next.next = new ListNode(4);
		t.next.next.next.next = new ListNode(5);
		Solution test = new Solution();
		t=test.reorderList(t);
		while(t!=null){
			System.out.println(t.val);
			t=t.next;
		}
	}
}