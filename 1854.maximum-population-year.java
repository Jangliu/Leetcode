class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] year= new int[101];
        int res=0;
        int max=0;
        for(int i=0;i<logs.length;i++){
            for(int j=logs[i][0]-1950;j<logs[i][1]-1950;j++){
                year[j]++;
            }
        }
        for(int i=0;i<year.length;i++){
            if(year[i]>max){
                max=year[i];
                res=i+1950;
            }
        }
        return res;
    }
}
