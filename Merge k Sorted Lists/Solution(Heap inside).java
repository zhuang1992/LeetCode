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
	class Heap{
		int size;
		ListNode[] h;
		int nodeNum;
		Heap(int n){
			this.size = n;
			h = new ListNode[size+1];
			nodeNum = 0;
		}
		boolean isEmpty(){
			return nodeNum==0;
		}
		void add(ListNode n){
			h[++nodeNum] = n;
			minHeapifyBotUp();
		}
		void minHeapifyBotUp(){
			int id = nodeNum;
			while(id != 0){
				int pid = id/2;
				if(pid >=1 && h[pid].val > h[id].val){
					ListNode tmp = h[pid];
					h[pid] = h[id];
					h[id] = tmp;
				}else
					break;
				id = pid;
			}
		}
		void minHeapifyTopDown(int id){
			int l = id<<1;
			int r = id <<1|1;
			int smallest = id;
			if(l<=nodeNum && h[l].val < h[id].val){
				smallest = l;
			}else{
				smallest = id;
			}    		
			if(r<=nodeNum && h[r].val < h[smallest].val){
				smallest = r;
			}
			if(smallest != id){
				ListNode t = h[smallest];
				h[smallest] = h[id];
				h[id] = t;
				minHeapifyTopDown(smallest);
			}	
		}
		ListNode getTop(){
			ListNode tmp = h[1];
			h[1] = h[nodeNum];
			h[nodeNum] = tmp;
			nodeNum--;
			minHeapifyTopDown(1);
			return h[nodeNum+1];
		}    
	}
	public ListNode mergeKLists(List<ListNode> lists) {
    	if(lists == null || lists.size()==0)
    		return null;
        ListNode newHead = null;
        ListNode newPtr = null;
        Heap h = new Heap(lists.size());
        for(int i = 0; i < lists.size(); i++){
        	if(lists.get(i)!=null)
        		h.add(lists.get(i));
        }
    	while(!h.isEmpty()){
        	if(newHead==null){
        		ListNode t = h.getTop();
        		if(t.next!=null)
        			h.add(t.next);
        		newPtr = t;
        		newHead = newPtr;
        	}else{
        		ListNode t = h.getTop();
        		if(t.next!=null)
        			h.add(t.next);
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