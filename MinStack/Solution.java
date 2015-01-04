package workbench;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import java.util.HashMap;
import java.util.ArrayList;
//与前序中序建树是完全对称的，后序序列的最后一个数为根。
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
class Solution {
    List<Integer>stack = new ArrayList<Integer>();
    List<Integer>minElem = new ArrayList<Integer>();
    List<Integer>times = new ArrayList<Integer>();
    int num = 0;
    public void push(int x) {
        stack.add(num,x);
        if(num==0){
            minElem.add(x);
            times.add(1);
        }else{
            int minSoFar = minElem.get(minElem.size()-1);
            if(minSoFar > x){
                minElem.add(x);
                times.add(1);
            }else if(minSoFar == x){
                int s = times.size()-1;
                times.set(s,times.get(s)+1);
            }
        }
        num++;
    }

    public void pop() {
        if(num==0)
            return;
//        System.out.println(stack.get(num-1));
//        System.out.println(minElem.get(minElem.size()-1));
        int n = stack.get(num-1);
        if(n==minElem.get(minElem.size()-1)){ ////// Something weird happend here!!!
            int t = times.get(times.size()-1);
            t--;
            if(t==0){
            	times.remove(times.size()-1);
            	minElem.remove(minElem.size()-1);
            }                
            else
                times.set(times.size()-1,t);
        }
        stack.remove(num-1);
        num--;
    }

    public int top() {
        if(num==0)
            return -1;
        return stack.get(num-1);
    }

    public int getMin() {
        if(num==0)
            return -1;
        return minElem.get(minElem.size()-1);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	test.push(512);
    	test.push(-1024);
    	test.push(-1024);
    	test.push(512);
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
    	test.pop();
    	System.out.println(test.getMin());
    	
    }
}