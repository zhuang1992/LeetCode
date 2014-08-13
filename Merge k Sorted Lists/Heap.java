package workbench;

public class Heap{
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
//	public static void main(String[] args){
//		Heap test = new Heap(10);
//		
//		for(int i = 0; i < 10; i++){
//			test.add(new ListNode((int)(Math.random()*100)));
//		}
//		for(int i = 0; i < 10; i++){
//			System.out.println(test.getTop().val);
//		}
//	}
}