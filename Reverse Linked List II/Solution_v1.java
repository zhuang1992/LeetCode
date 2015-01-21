//��reverseAll����д������
//���ƺ������ϸ��һ�����

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head == null || head.next == null)
    		return head;    	
        int cnt = 0;
        ListNode ptr = head;
        ListNode st = null;
        ListNode socket1 = null;
        ListNode socket2 = null;
        ListNode nh = null;
        while(ptr!=null){
        	cnt++;
        	if(cnt==m-1){
        		socket1 = ptr;
        		st = ptr.next;
        	}else if(m==1){
        		st = head;
        	}
        	if(cnt==n){
        		socket2 = ptr.next;
        		nh=reverseAll(st,ptr.next);
        		if(newTail!=null)
        			newTail.next = socket2;
        		break;
        	}
        	ptr = ptr.next;
        }
        if(m==1){
        	return nh;
        }else{
        	socket1.next = nh;
        	return head;
        }
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	ListNode h = new ListNode(1);
    	ListNode p = h;
    	Scanner in = new Scanner(System.in);
    	for(int i = 0; i < 1; i++){
    		p.next = new ListNode(in.nextInt());
    		p = p.next;
    	}
    	h = test.reverseBetween(h,1,2);
    	for(int i = 0; i < 2; i++){
    		System.out.println(h.val);
    		h = h.next;
    	}
    	//System.out.print(newTail.val);
    }
}