class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int n = prices.size();
        if(!n)return 0;
        int f[n];
        int g[n];
        memset(f,0,sizeof(f));
        memset(g,0,sizeof(g));
        int vally = prices[0];
        int peak = prices[n-1];
        for(int i = 1;i < n;i++){
            vally = min(vally,prices[i]);
            f[i] = max(f[i-1],prices[i] - vally);
        }
        for(int i = n - 2; i >= 0; i--){
            peak = max(peak,prices[i]);
            g[i] = max(g[i+1],peak - prices[i]);
        }
        int res= -1;
        for(int i = 0;i < n;i++){
            res = max(res,f[i]+g[i]);
        }
        return res;
    }
};