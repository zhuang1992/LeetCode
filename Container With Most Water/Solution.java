//ȡ����ߵ�Ϊleft�����ұߵ�Ϊright�����п��ܱ����ִ�����ֻ�����������߶Ƚ�С����һ�����м��ƶ���һֱѭ��������������ֵ�϶������С�
//ע����֮ǰ�ǵ�������ͼ���������������һ��������Ƚ�ˮ����
package workbench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int rst = -1;
        while(left < right){
        	int smaller;
        	smaller = height[left]<height[right]?left:right;
        	rst = Math.max(rst, height[smaller]*(right-left-1));        	
        	int t = height[left]<height[right]?left++:right--;
        }
        return rst;
    }
}