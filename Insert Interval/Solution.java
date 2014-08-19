//比Merge Interval还好做。教训就是测试要做彻底。
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if(intervals.size()==0){
    		intervals.add(newInterval);
    		return intervals;
    	}
    	int ns = newInterval.start;
    	int ne = newInterval.end;
        for(int i = 0; i < intervals.size(); i++){
        	if(ns <= intervals.get(i).end){
        		ns = Math.min(ns, intervals.get(i).start);       		
           		while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
           			ne = intervals.get(i).end;
           			intervals.remove(i);
           		}
           		ne = Math.max(newInterval.end, ne);               	
           		intervals.add(i, new Interval(ns,ne));
                return intervals;      	
        	}       	        	
        }
        intervals.add(newInterval);
        return intervals;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	List<Interval>interval = new LinkedList<Interval>();
    	interval.add(new Interval(1,5));
//    	interval.add(new Interval(5,5));
//    	interval.add(new Interval(6,7));
//    	interval.add(new Interval(8,10));
//    	interval.add(new Interval(12,16));
    	Interval newInterval = new Interval(6,7);
    	List<Interval>r = test.insert(interval, newInterval);
    	for(int i = 0; i < r.size(); i++){
    		System.out.println(r.get(i).start+" "+r.get(i).end);
    	}
    }
}