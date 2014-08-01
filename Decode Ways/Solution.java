//基本的动规递推公式好想，dp[i] = dp[i-1]+dp[i-2] 或者 dp[i-1]，根据s[i]能否与s[i-1]拼在一起。
//关键在0的处理上。
//但是有要多细节要考虑
package workbench;
public class Solution {
	int dp[];
  public int numDecodings(String s) {
  	if(s.length()==0)
  		return 0;
  	if(s.charAt(0)=='0') //如果第一个是0，那肯定不是合法的
  		return 0;
  	
      dp = new int[s.length()+1];
      
      dp[0]=1;
      for(int i = 1; i < s.length(); i++){
      	if(s.charAt(i)=='0'){  											//出现0的情况要处理好<_<
      		if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
      			if(i==1){
      				dp[i] = 1;
      			}else{
          			dp[i] = dp[i-2];        				
      			}
      		}else{
      			dp[i] = 0;
      		}
      	}else	if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){
      		if(i==1){
      			dp[i] = dp[i-1] +1;
      		}else{
      			dp[i] = dp[i-1] + dp[i-2];
      		}        		
      	}else{
      		dp[i] = dp[i-1];
      	}
      }
      return dp[s.length()-1];
  }
  public static void main(String[] args){
  	String s ="1025011";  //这个例子结果应该是0
  	Solution test = new Solution();
  	System.out.print(test.numDecodings(s));
  }
}