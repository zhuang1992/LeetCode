//直接一遍遍地扫的话，会超时
//用堆

//为了复习手写一个堆
//注意heapify时，需要自上往下一遍，再自下往上一遍


package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {    
	Comparator<ListNode>cmp = new Comparator<ListNode>(){
		public int compare(ListNode o1, ListNode o2){
			if(o1.val > o2.val)
				return 1;
			else if(o1.val == o2.val)
				return 0;
			return -1;
		}
	};
	public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists == null || lists.size()==0)
    		return null;
		PriorityQueue<ListNode>p = new PriorityQueue<ListNode>(lists.size(),cmp);
        ListNode newHead = null;
        ListNode newPtr = null;
        //Heap h = new Heap(lists.size());
        for(int i = 0; i < lists.size(); i++){
        	if(lists.get(i)!=null)
        		p.add(lists.get(i));
        }
    	while(!p.isEmpty()){
        	if(newHead==null){
        		ListNode t = p.poll();
        		if(t.next!=null)
        			p.add(t.next);
        		newPtr = t;
        		newHead = newPtr;
        	}else{
        		ListNode t = p.poll();
        		if(t.next!=null)
        			p.add(t.next);
        		newPtr.next = t;
        		newPtr = newPtr.next;
        	}
    	}
    	return newHead;
    }
	public static void main(String[] args){
		Solution test = new Solution();
		List<ListNode>t = new LinkedList<ListNode>();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(10);
		ListNode c = new ListNode(5);
		t.add(a);
		t.add(b);
		t.add(c);
		ListNode r = test.mergeKLists(t);
		while(r!=null){
			System.out.println(r.val);
			r=r.next;
		}
	}
}