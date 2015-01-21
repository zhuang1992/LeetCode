//递归写起来更加简洁，但不知算不算一遍遍历？
package workbench;

import java.util.Scanner;


public class Solution {
	ListNode tail;
    private ListNode solve(ListNode r, int l){
    	if(l == 0){
    		tail = r;
    		return r;    		
    	}
    	ListNode t = solve(r.next, l-1);
    	r.next = tail.next;
    	tail.next = r;
    	tail = r;
    	return t;
    }
	public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode dumHead = new ListNode(-1);
    	dumHead.next = head;
    	ListNode ptr = dumHead;
		for(int i = 0 ; i < m-1 ; i++){
    		ptr = ptr.next;
    	}
		ptr.next = solve(ptr.next, n-m);
		return dumHead.next;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		ListNode h = new ListNode(1);
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		ListNode ptr = h;
		for(int i = 2; i <= n; i++){
			ptr.next = new ListNode(i);
			ptr = ptr.next;
		}
		h = test.reverseBetween(h, 2, 3);
		while(h != null){
			System.out.println(h.val);
			h = h.next;
		}
	}
}