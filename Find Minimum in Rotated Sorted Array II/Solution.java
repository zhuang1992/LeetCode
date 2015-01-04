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
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
public class Solution {
    public int findMin(int[] num) {
        int left = 0;
        int right = num.length-1;
        if(num.length == 1)
        	return num[0];
        int min = num[0];
        while(left < right-1){
        	int mid = (left+right)/2;
        	if(num[left]<num[mid]){
        		min = Math.min(min,num[left]);
        		left = mid+1;
        	}else if(num[left]>num[mid]){
        		min = Math.min(min, num[mid]);
        		right = mid-1;
        	}else{
        		left++;
        	}
        }
        min = Math.min(min, num[left]);
        min = Math.min(min, num[right]);
        return min;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	int a[] = {2,0,1,1,1};
    	System.out.println(test.findMin(a));
    }
}