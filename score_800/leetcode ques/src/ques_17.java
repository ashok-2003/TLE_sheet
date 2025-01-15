import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class ques_17 {
//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
    // so now here we have to get the number of digit combo here
public static void main(String[] args) {
    // so here
    String str = "7";
    System.out.println(letterCombinations(str));
}
static List<String> ans = new ArrayList<>();
// so now here we have to store the value of the digit also so now here we can store that in the index format here
static String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
private static List<String> letterCombinations(String digit) {
    // so now here we have to get the all combo here
    // so now if digit length is zero then we have to return the list here
    if(digit.length()== 0){
        List<String> l = new ArrayList<>();
        return l;
    }
    // so now otherwise we can use the helper function here for the better here
    StringBuilder sb = new StringBuilder();
    helper(digit , 0, sb);
    return ans;
}
private static void helper(String digit , int index , StringBuilder sb){
    if(index == digit.length()){
        // so now here we have to add it
        ans.add(sb.toString());
        return;
    }
    // so now here we have to get the digit at each of the place here
    int val = (int)digit.charAt(index)-'0';
    // so now here get the value here
    String temp = arr[val];
    // so now here we have get the value so now
    for(char ch : temp.toCharArray()){
        // so now here inside of it we have to
        sb.append(ch);
        // so now here call the recursion function here
        helper(digit, index+1, sb);
        // so now here we have to backtrack here
        sb.deleteCharAt(sb.length()-1);
    }
}
}

// so here is the solution from the leetcode here
class olution {
    public List<String> letterCombinations(String digi) {
        // so now here
        List<String> ls = new ArrayList<>();
        if(digi.equals("")){
            return ls;
        }
        // so now otherwise we have to map the value here
        HashMap<Character , String > map = new HashMap<>();
        map.put('2' , "abc");
        map.put('3', "def");
        map.put('4' , "ghi");
        map.put('5' , "jkl");
        map.put('6' , "mno");
        map.put('7' , "pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");
        // so now here we have to get the all of the string here
        // so now here we can do a thing like we can iterate over the array
        // so now here we have ls here so now now in this we have to deal with
        ls.add("");
        for(int i =0; i < digi.length(); i++){
            // so now here
            char ch = digi.charAt(i);
            // so now here we have to get the char at
            String str = map.get(ch);
            // so now if our string is nul
            if(str == null){
                continue;
            }
            // so now here we have to get the list here and all the all element in the list here
            List<String> temp = new ArrayList<>();
            // so now here we have to go inside of it
            for(String s : ls){
                for(char c : str.toCharArray()){
                    temp.add(s+c);
                }
            }
            // so now here after all of this loop make the temp equal to the str here
            ls = temp;
        }
        return ls;
    }
}

// so now here we have here the 0ms solution here
class Solution {
    List<String> res = new ArrayList<>();
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return res;
        }
        map = Map.of('2',"abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7',"pqrs", '8', "tuv", '9',"wxyz");
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    public void dfs(String digits, int currIdx, StringBuilder sb){
        if (sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(currIdx)).toCharArray()){
            sb.append(c);
            dfs(digits, currIdx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
