//×öµÄºÃµ°ÌÛ¡£¡£
package workbench;
public class Solution {
    public int sqrt(int x) {
        if(x<=1)return x;
        if(x<4)return 1;
        
        int i = 2;
        while(true){
            if(i*i>=x || i*i>46340){
            	i=(int) Math.sqrt((int)i);
            	break;
            }
            i=i*i;
        }
        
        while(i*i<=x){
            i++;
            if(i>46340)
            	break;
        }
        return i-1;
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.sqrt(5));
    }
}