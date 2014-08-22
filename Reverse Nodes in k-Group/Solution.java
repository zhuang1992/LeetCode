//������֮ǰreverse linked list�е�reverseAll����������ð���
//reverseAll�������Ƿ�ת��h��ʼ����tail����һ������(������tail)��
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	ListNode newTail;
    ListNode reverseAll(ListNode h, ListNode tail){ 
		//ע��whileѭ��һ���漰���Ľڵ㣬���ж��(�����һ��ѭ����)��������������ȶ�����һ��ѭ���ڣ���ô��whileǰ��Ӧ����Ԥ�У�ֱ��return
		//����߼��Ƚ���Ҫ����
		if(h==null || h.next==null)
			return h;
		newTail = h;
		ListNode newHead = h;
		h = h.next;
		newHead.next = null;
		ListNode nxt;
		while(h!=tail){ //��ת��tailΪֹ
			nxt = h.next;
			h.next = newHead;
			newHead = h;
			h = nxt;
		}		
		return newHead;
	}
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null || head.next == null || k==1)
    		return head;
        ListNode ptr = head;
        ListNode hptr = head;
        ListNode newH = null;
        while(hptr!=null){
        	int tk = k;
        	while(tk-- >0){
            	ptr = ptr.next;
            	if(ptr==null && tk>0){
            		if(newTail != null)
            			newTail.next = hptr;
            	    if(newH == null)
            	    	newH = head;
            	    return newH;
            	}
            }
        	if(newH == null){
        		newH = reverseAll(hptr, ptr);        		
        	}else{
        		ListNode t = newTail;
        		t.next = reverseAll(hptr, ptr);        		
        	}        	
        	hptr = ptr;
        }
        return newH;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	ListNode r = new ListNode(1);
    	r.next = new ListNode(2);
    	r.next.next = new ListNode(3);
    	r.next.next.next = new ListNode(4);
    	r.next.next.next.next = new ListNode(5);
    	ListNode rst = test.reverseKGroup(r, 5);
    	while(rst!=null){
    		System.out.println(rst.val);
    		rst = rst.next;
    	}
    }
}