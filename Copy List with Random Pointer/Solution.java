//O(n^2)的算法。。没啥好说的
package workbench;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head==null)
    		return null;
        RandomListNode nHead = new RandomListNode(head.label);
        RandomListNode ptr = head.next;
        RandomListNode nptr = nHead;
        while(ptr!=null){
        	nptr.next = new RandomListNode(ptr.label);
        	nptr = nptr.next;
        	ptr = ptr.next;        	
        }
        nptr.next = null;
        
        ptr = head;
        nptr = nHead;
        RandomListNode searchN = nHead;
        while(ptr!=null){
        	if(ptr.random!=null){
        		while(searchN!=null && searchN.label != ptr.random.label){
        			searchN = searchN.next;
        		}
        		if(nptr!=null){
        			nptr.random = searchN;
        		}
        		searchN = nHead;
        	}else{
        		nptr.random = null;
        	}
        	nptr = nptr.next;
        	ptr = ptr.next;
        }
        return nHead;
    }
}