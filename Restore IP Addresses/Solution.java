//三层循环迭代
//注意细节
package workbench;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	int ip[] = new int[4];
    	Set<String> res = new HashSet<String>();
    	StringBuffer tres = new StringBuffer();
        for(int a = 0; a < s.length(); a++){
        	if(s.charAt(0)=='0' && s.substring(0,a).length()>1)
        		continue;
        	if(s.substring(0,a).length()==0 || s.substring(0,a).length() >3)
        		continue;
        	if(Integer.valueOf(s.substring(0,a)) >255 )
        		break;
        	ip[0] = Integer.valueOf(s.substring(0,a));
        	for(int b = a+1; b < s.length(); b++){
        		if(s.charAt(a)=='0' && s.substring(a,b).length()>1)
            		continue;
        		if(s.substring(a,b).length() >3)
            		break;
            	if(Integer.valueOf(s.substring(a,b)) >255 )
            		break;
            	ip[1] = Integer.valueOf(s.substring(a,b));
        		for(int c = b+1; c < s.length(); c++){
        			if(s.charAt(b)=='0' && s.substring(b,c).length()>1)
                		continue;
        			if(s.substring(b,c).length() >3)
                		break;
                	if(Integer.valueOf(s.substring(b,c)) >255 )
                		break;

                	if(s.charAt(c)=='0' && s.substring(c,s.length()).length()>1)
                		continue;
        			if(s.substring(c,s.length()).length()>3)
        				continue;
        			if(Integer.valueOf(s.substring(c,s.length())) > 255){
        				continue;
        			}
                	ip[2] = Integer.valueOf(s.substring(b,c));
        			ip[3] = Integer.valueOf(s.substring(c,s.length()));
                	tres.append(String.valueOf(ip[0])+".");
                	tres.append(String.valueOf(ip[1])+".");
                	tres.append(String.valueOf(ip[2])+".");
                	tres.append(String.valueOf(ip[3]));        		
                	res.add(tres.toString());
                	tres.delete(0, tres.length());
        		}
        		
        	}
        }
        return new LinkedList<String>(res);
    }
    public static void main(String[] args){
    	Solution test = new Solution();
    	System.out.println(test.restoreIpAddresses("010010"));
    }
}