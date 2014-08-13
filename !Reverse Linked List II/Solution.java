//这个是严格的扫一遍
//但我就纳了闷了居然会超时!WTF!
//哦。。还是程序的问题。但为什么不报WA而是报TLE，费解。
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	ListNode newTail=null;	
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null || head.next == null)
    		return head;    	
        int cnt = 0;
        ListNode ptr = head;
        ListNode socket1 = null;
        ListNode newHead = null;
        while(ptr!=null){
        	cnt++;
        	if(cnt==m-1 || m==1){
        		if(cnt==m-1){
        			socket1 = ptr;
        			ptr = ptr.next;
        			cnt++;
        		}        			
        		newTail = ptr;
        		newHead = ptr;
        		ptr = ptr.next;
        		newHead.next = null;
        		ListNode nxt;
        		while(cnt<n){ 
        			nxt = ptr.next;
        			ptr.next = newHead;
        			newHead = ptr;
        			ptr = nxt;
        			cnt++;
        		}        		
        		if(newTail!=null)
        			newTail.next = ptr;
        		break;
        	}        	
        	ptr = ptr.next;
        }
        if(m==1){
        	return newHead;
        }else{
        	socket1.next = newHead;
        	return head;
        }
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	ListNode h = new ListNode(1);
    	ListNode p = h;
    	Scanner in = new Scanner(System.in);
    	for(int i = 0; i < 4; i++){
    		p.next = new ListNode(in.nextInt());
    		p = p.next;
    	}
    	h = test.reverseBetween(h,5,5);
    	for(int i = 0; i < 5; i++){
    		System.out.println(h.val);
    		h = h.next;
    	}
    	//System.out.print(newTail.val);
    }
}