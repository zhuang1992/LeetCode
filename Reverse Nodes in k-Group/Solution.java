//¸´ÓÃÁËÖ®Ç°reverse linked listÖÐµÄreverseAllº¯Êý£¬ÕæºÃÓÃ°¡¡£
//reverseAllµÄ×÷ÓÃÊÇ·­×ª´Óh¿ªÊ¼£¬µ½tailÕâÑùÒ»ÌõÁ´±í(²»°üÀ¨tail)¡£
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
		//×¢ÒâwhileÑ­»·Ò»´ÎÉæ¼°µ½µÄ½Úµã£¬»áÓÐ¶à¸ö(ÏëÏó³ÉÒ»¸öÑ­»·½Ú)¡£Èç¹ûÕû¸öÁ´±í³¤¶È¶¼²»¹»Ò»¸öÑ­»·½Ú£¬ÄÇÃ´ÔÚwhileÇ°ÃæÓ¦¸ÃÓÐÔ¤ÅÐ£¬Ö±½Óreturn
		//Õâ¸öÂß¼­±È½ÏÖØÒªÓÐÓÃ
		if(h==null || h.next==null)
			return h;
		newTail = h;
		ListNode newHead = h;
		h = h.next;
		newHead.next = null;
		ListNode nxt;
		while(h!=tail){ //·­×ªµ½tailÎªÖ¹
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

//简洁点的
 public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(k == 0 || k == 1) return head;
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        int multi = length / k;
        if(multi == 0) return head;
        ListNode preTail = null, curHead = null, curTail = null;
        ListNode preNode = null, nextNode = null;
        cur = head;
        for(int j = 0; j < multi; j++) {
            preNode = null;
            for(int i = 0; i < k; i++) {
                if(cur != null) {
                    nextNode = cur.next;
                    cur.next = preNode;
                    preNode = cur;
                }
                if(i == 0) curTail = cur;
                if(i == (k - 1)) curHead = cur;
                cur = nextNode;
            }
            if(preTail == null) head = curHead;
            else preTail.next = curHead;
            preTail = curTail;
        }
        curTail.next = cur;
        return head;
    }
}