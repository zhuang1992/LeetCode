package workbench;

import java.util.Arrays;
import java.util.LinkedList;
public class Solution {
	int ans = -1;
	public int maximumGap(int[] num) {
		int n = num.length;
		if(n < 2)
			return 0;
		int min = num[0];
		int max = num[0];
		for(int i = 0; i < n; i++){
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		int bucketLen = (int)Math.ceil((double)(max - min)/(n-1));

		int[] bucketsMax = new int[n];
		int[] bucketsMin = new int[n];
		Arrays.fill(bucketsMax, -1);
		Arrays.fill(bucketsMin, Integer.MAX_VALUE);
		for(int i = 0; i < n; i++){
			int bucketId = (num[i]-min)/bucketLen;
			bucketsMax[bucketId] = Math.max(bucketsMax[bucketId], num[i]);
			bucketsMin[bucketId] = Math.min(bucketsMin[bucketId], num[i]);
		}
		int preMax = Integer.MAX_VALUE;
		for(int i = 0; i < bucketsMax.length; i++){
			if(bucketsMax[i] == -1)
				continue;
			if(preMax == Integer.MAX_VALUE){
				preMax = bucketsMax[i];
				continue;					
			}				
			ans = Math.max(bucketsMin[i] - preMax, ans);
			preMax = bucketsMax[i];
		}
		return ans;
	}
	public static void main(String[] args){
		Solution test = new Solution();
		int num[] = {100,2};
		System.out.println(test.maximumGap(num));
	}
}