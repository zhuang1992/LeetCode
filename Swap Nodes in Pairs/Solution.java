//Ô­µØµÄ
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        ListNode temp = ptr2.next;
        ListNode nH = ptr2;
        while(ptr1!=null && ptr2!=null){
        	ptr2.next = ptr1;
        	if(temp!=null){
        		if(temp.next == null){
        			ptr1.next = temp;
        			ptr1 = temp.next;
        		}        			
        		else{
        			ptr1.next = temp.next;
        			ptr1 = temp;
        			ptr2 = temp.next;
        			temp = ptr2.next;
        		}        	
        	}        		
        	else{
        		ptr1.next = null;
        		break;
        	}        		
        }
        return nH;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	ListNode r = new ListNode(1);
    	r.next = new ListNode(2);
    	r.next.next = new ListNode(3);
    	r.next.next.next = new ListNode(4);
    	r.next.next.next.next = new ListNode(5);
    	r = test.swapPairs(r);
    	while(r!=null){
    		System.out.print(r.val+" ");
    		r = r.next;
    	}
    }
}