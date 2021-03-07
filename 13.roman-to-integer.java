import javax.lang.model.util.ElementScanner14;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int length = s.length();
        int num = 0;
        while(i<length-1)
        {
            char c = s.charAt(i);
            switch(c)
            {
                case 'I':
                    if(s.charAt(i+1)=='V'){
                        num+=4;
                        i+=2;
                        break;
                    }
                    if(s.charAt(i+1)=='X'){
                        num+=9;
                        i+=2;
                        break;
                    }
                    else{
                        num+=1;
                        i++;
                        break;
                    }

                case 'V':
                    num+=5;
                    i++;
                    break;

                case 'X':
                    if (s.charAt(i + 1) == 'L') {
                        num += 40;
                        i += 2;
                        break;
                    }
                    if (s.charAt(i + 1) == 'C') {
                        num += 90;
                        i += 2;
                        break;
                    } else {
                        num += 10;
                        i++;
                        break;
                    }
                case 'L':
                    num+=50;
                    i++;
                    break;
                case 'C':
                    if (s.charAt(i + 1) == 'D') {
                        num += 400;
                        i += 2;
                        break;
                    }
                    if (s.charAt(i + 1) == 'M') {
                        num += 900;
                        i += 2;
                        break;
                    } else {
                        num += 100;
                        i++;
                        break;
                    }
                case 'D':
                    num+=500;
                    i++;
                    break;
                case 'M':
                    num+=1000;
                    i++;
                    break;
            }
        }
        if(i==length){
            return num;
        }
        else{
            switch(s.charAt(i))
            {
                case 'I':
                    num+=1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
            }
        }
        return num;
    }
}
// @lc code=end

