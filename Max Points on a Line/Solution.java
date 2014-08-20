//ȡ����ߵ�Ϊleft�����ұߵ�Ϊright�����п��ܱ����ִ�����ֻ�����������߶Ƚ�С����һ�����м��ƶ���һֱѭ��������������ֵ�϶������С�
//ע����֮ǰ�ǵ�������ͼ���������������һ��������Ƚ�ˮ����
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
	public double K_MAX = 9999999;
    public int maxPoints(Point[] points) {
    	int rst = 0;
        HashMap<Double, Integer> hash = new HashMap<Double, Integer>();
        for(int i = 0; i < points.length; i++){
        	hash.clear();
        	int duplicates = 1;
        	for(int j = 0; j < points.length; j++){
        		if(i == j)
        			continue;
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			duplicates ++;
        			continue;
        		}
        		double k = points[i].x == points[j].x? K_MAX : (double)(points[i].y - points[j].y)/(double)(points[i].x - points[j].x);
        		if(hash.containsKey(k)){
        			hash.put(k, hash.get(k)+1);
        		}else{
        			hash.put(k, 1);
        		}
        	}
        	Iterator iter = hash.entrySet().iterator();
        	int t = 0;
        	while(iter.hasNext()){
        		Map.Entry<Double,Integer> entry = (Map.Entry<Double, Integer>)iter.next();
        		t = Math.max(t, entry.getValue());
        	}
        	rst = Math.max(rst,t+duplicates);
        }
        return rst;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	Point points[] = new Point[3];
    	points[0] = new Point(0,0);
    	points[1] = new Point(1,1);
    	points[2] = new Point(-1,1);
    	System.out.print(test.maxPoints(points));
    }
}