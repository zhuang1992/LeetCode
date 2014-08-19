//本来想用线段树的，但是看了看好像没什么关系，也没有必要。
//就当学习使用Comparator了
package workbench;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class Solution {
	@SuppressWarnings("rawtypes")
	class IntervalCompare implements Comparator<Interval>{
		 public int compare(Interval a, Interval b){
		    if(a.start < b.start) return -1;
		    else if(a.start == b.start){
		        if(a.end < b.end) return -1;
		        else if(a.end >b.end)
		        	return 1;
		        else
		        	return 0;
		    }
		    else return 1;
		}
	  }
	  public List<Interval> merge(List<Interval> intervals) {
		  if(intervals == null || intervals.size()==0 || intervals.size()==1){
			  return intervals;
		  }		  
		  List<Interval> rst = new LinkedList<Interval>();
		  Collections.sort(intervals,new IntervalCompare());
	      int s1 = intervals.get(0).start;
	      int e1 = intervals.get(0).end;
	      int s2,e2;
		  for(int i = 1; i < intervals.size(); i++){  
	    	  s2 = intervals.get(i).start;
	    	  e2 = intervals.get(i).end;
	    	  if(e1 < s2){
	    		  rst.add(new Interval(s1,e1));
	    		  s1 = s2;
	    		  e1 = e2;
	    	  }else{
	    		  if(e1 <= e2){
	    			  e1 = e2;
	    		  }
	    	  }
	      }
		  rst.add(new Interval(s1,e1));
		  return rst;
	  }	
	  public static void main(String[] args){
		  Solution test = new Solution();
		  List<Interval>interval = new LinkedList<Interval>();
		  interval.add(new Interval(5,6));
		  interval.add(new Interval(1,5));
		  interval.add(new Interval(0,0));
		  List<Interval>rst = test.merge(interval);
		  for(int i = 0; i < rst.size(); i++){
			  System.out.println(rst.get(i).start+"	"+rst.get(i).end);
		  }
	  }
}