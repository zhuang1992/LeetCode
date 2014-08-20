//取最左边的为left，最右边的为right，所有可能比这种大的情况只能是这两个高度较小的那一端向中间移动。一直循环这个动作，最大值肯定在其中。
//注意与之前那道在柱形图中求最大矩形面积不一样。这个比较水。。
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