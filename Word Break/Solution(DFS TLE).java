//�����Ķ�����ƹ�ʽ���룬dp[i] = dp[i-1]+dp[i-2] ���� dp[i-1]������s[i]�ܷ���s[i-1]ƴ��һ��
//�ؼ���0�Ĵ����ϡ�
//������Ҫ��ϸ��Ҫ����
package workbench;
public class Solution {
	int dp[];
  public int numDecodings(String s) {
  	if(s.length()==0)
  		return 0;
  	if(s.charAt(0)=='0') //�����һ����0���ǿ϶����ǺϷ���
  		return 0;
  	
      dp = new int[s.length()+1];
      
      dp[0]=1;
      for(int i = 1; i < s.length(); i++){
      	if(s.charAt(i)=='0'){  											//����0�����Ҫ�����<_<
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
  	String s ="1025011";  //������ӽ��Ӧ����0
  	Solution test = new Solution();
  	System.out.print(test.numDecodings(s));
  }
}