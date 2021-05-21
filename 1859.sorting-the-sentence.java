class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] val = new String[words.length];
        StringBuffer res = new StringBuffer();
        for(String w:words){
            String temp=w.substring(0,w.length()-1);
            val[w.charAt(w.length()-1)-'1']=temp;
        }
        for(int i=0;i<val.length-1;i++){
            res.append(val[i]);
            res.append(" ");
        }
        res.append(val[val.length-1]);
        return res.toString();
    }
}