//略恶心的字符串模拟，保持头脑清醒，代码简洁最重要
//得复习一下C++了啊!
#include <iostream>
#include <vector>
#include <string>
#include <cstdio>
#include <cstdlib>
using namespace std;
class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
		vector<string>rst;
		if(L==0 || words.size()==0){
			string line;
			for(int i = 0; i < L; i++){
				line.append(" ");
			}
			rst.push_back(line);
			return rst;
		}
		for(vector<string>::iterator iter = words.begin(); iter!=words.end();){
			int t = L;
			t -= (*iter).size();
			int cnt = 1;
			while(t>0){
				if((iter+1)==words.end())
					break;
				if(t-1 >= (*(iter+1)).size()){
					iter++;
					cnt++;
					t --;
					t -= (*(iter)).size();
				}else
					break;
			}
			t += cnt-1;
			string line;
			line.append(*(iter-(cnt-1)));
			int space = t;
			int extras;
			if(cnt!=1){
				space = t/(cnt-1);
				extras = t%(cnt-1);
			}
				
				
			
			for(int j = 1; j < cnt; j++){
				string cur = *(iter-(cnt-1-j));
				if(j == cnt-1){
					space = L - line.size() - cur.size();  //if it's the last word of a line, adjust the space number
				}
				if(iter+1 == words.end()){  //if it's the last line, left justify.
					space = 1;
				}
				for(int z = 0; z < space; z++){
					line.append(" ");
				}
				if(extras>0 && iter+1!=words.end()){  //if sapces cannot be divided evenly, spaces on the left get one more.
					line.append(" ");
					extras--;
				}
				line.append(cur);				
			}

			iter++;
			rst.push_back(line);
			if(cnt==1 || iter==words.end()){   //if it's the last line, or there's only one word in a line, we need to assure its length equas L by adding space
				while(rst.back().size()<L){
					rst.back().append(" ");
				}
			}
		}
		return rst;
    }
};
int main(){
	Solution t;
	vector<string>r;
	/*
	r.push_back("a");
	
	r.push_back("b");
	r.push_back("c");
	r.push_back("d");
	r.push_back("e");
	/*
	r.push_back("This");
	r.push_back("is");
	r.push_back("an");
	r.push_back("example");
	r.push_back("of");
	r.push_back("text");
	r.push_back("justification.");
	*/
	r.push_back("What");
	r.push_back("must");
	r.push_back("be");
	r.push_back("shall");
	r.push_back("be");
	//r.push_back("");
	vector<string>res = t.fullJustify(r,6);
	for(vector<string>::iterator iter= res.begin();iter!=res.end();iter++){
		cout << (*iter)<<endl;
	} 
	int a;
	cin>>a;
}