//O(n)的时间复杂度
//O(1)的空间复杂度
//下面这种做法只需要从左到右扫一遍
//其实来回扫两遍，每遍只处理非递减序列更容易理解。
package workbench;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public int candy(int[] ratings) {
		if(ratings.length == 1){
			return 1;
		}
		int rst = 0;
		int height = 1;        //记录最近那个孩子拥有的糖果
		int conDesc = 1;	//出现连续下降的长度
		int top = 1;		//出现连续下降时，前面最高的那个孩子拥有的糖果
		for(int i = 0; i < ratings.length; i++){
			if(i == 0){
				rst += height;
				continue;
			}
			if(ratings[i] > ratings[i-1]){
				conDesc = 1;
				height++;
				rst += height;
				top = height;
			}else if(ratings[i] == ratings[i-1]){  
				conDesc = 1;												//出现相等，也要认为递减终止
				height = 1;
				rst += height;
				top = height;
			}else{
				conDesc++;
				if(conDesc > top){
					rst += conDesc;
					top = conDesc;
				}else{
					rst += conDesc-1;	
				}					
				height = 1;
			}				
		}
		return rst;
	}
	public static void main(String[] args){
		Solution test = new Solution();
		int r[] = {4,3,3,2,1};
		System.out.print(test.candy(r));
	}
}
//Two traverse. O(n) space. 
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N;
		String line = in.readLine();
		N = Integer.parseInt(line);
		int ratings[] = new int[N];
		for (int i = 0; i < N; i++) {
			ratings[i] = Integer.parseInt(in.readLine());
		}
		int[] count = new int[ratings.length];
		Arrays.fill(count, 1);
		int sum = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				count[i] = count[i - 1] + 1;
			}
		}

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i+1] && count[i + 1] >= count[i]) { 
				count[i] = count[i+1] + 1;
			}
			sum += count[i];
		}
		sum += count[ratings.length-1];
		System.out.println(sum);
	}
}