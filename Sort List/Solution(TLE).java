//先来个快排..居然超时了
package workbench;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	ListNode tail;
	ListNode quickSort(ListNode head){
		if(head.next == null){
			tail = head;
			return head;
		}			
		ListNode pivot = head;
		ListNode ptr1 = null,ptr2=pivot;
		ListNode prePtr = head;
        ListNode ptr = head.next;
        while(ptr!=null){
        	if(ptr.val < pivot.val){
        		ListNode temp = ptr1;
        		ptr1 = ptr;
        		prePtr.next = ptr.next;
        		ptr = ptr.next;
        		ptr1.next = temp;
        	}else{
        		ptr2 = ptr;
        		prePtr = ptr;
        		ptr = ptr.next;
        	}        		
        }
        tail = ptr2;
        if(pivot.next != null)
        	pivot.next = quickSort(pivot.next);
        
        ListNode nh = null;
        if(ptr1 != null){
        	nh = quickSort(ptr1);
        	tail.next = pivot;
        }
        else{
        	nh = pivot;
        }        
        return nh;
	}
    public ListNode sortList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;    	
        return quickSort(head);        
    }
    public static void main(String[] args){
    	
    	Solution test = new Solution();
    	ListNode r = new ListNode(3);
    	r.next = new ListNode(1);
    	r.next.next = new ListNode(4);
    	r.next.next.next = new ListNode(1);
    	r.next.next.next.next = new ListNode(4);
    	r.next.next.next.next.next = new ListNode(9);
    	ListNode rst = test.sortList(r);
    	while(rst != null){
    		System.out.println(rst.val);
    		rst = rst.next;
    	}
    }
}