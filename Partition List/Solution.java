package workbench;

import java.util.*;

public class Solution {
    public ListNode partition(ListNode head, int x) {
    	ListNode part1DummyHead = new ListNode(-1);
        ListNode part1ptr = part1DummyHead;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode ptr = dummyHead;
        while(ptr.next!=null){
        	if(ptr.next.val < x){
        		part1ptr.next = ptr.next;
        		ptr.next = ptr.next.next;
        		part1ptr = part1ptr.next;
        		part1ptr.next = null;
        	}else
        		ptr = ptr.next;  //注意，应该只有在没有删除节点的时候才移动ptr
        	if(ptr == null)
        		break;
        }
        part1ptr.next = dummyHead.next;
        return part1DummyHead.next;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	ListNode ptr = head;
    	Scanner in = new Scanner(System.in);
    	for(int i = 0; i < 2; i++){
    		int n = in.nextInt();
    		ptr.next = new ListNode(n);
    		ptr = ptr.next;
    	}
    	Solution test = new Solution();
    	ListNode res = test.partition(head, 4);
    	System.out.println("after:");
    	while(res!=null){
    		System.out.println(res.val);
    		res = res.next;
    	}
    	in.close();
    }
}