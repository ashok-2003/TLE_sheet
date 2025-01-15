import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/different-ways-to-add-parentheses/
// very good question
public class ques_241 {
    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s));
        StringBuilder sb = new StringBuilder();
    }
    public static List<Integer> diffWaysToCompute(String input) {
        // so now here the logic is any time we met the operator here we have to divide our recurion call from their
        // only
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '-' || ch == '*' || ch == '+'){
                // so now here we have to divide the both string from onwards here
                List<Integer> a1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> b1 = diffWaysToCompute(input.substring(i+1));
                // so now here both of the string has been classified here so now
                for(int x : a1){
                    for(int y : b1){
                        if(ch == '+'){
                            res.add(x+y);
                        }else if(ch == '-'){
                            res.add(x-y);
                        }else if(ch == '*'){
                            res.add(x*y);
                        }
                    }
                }
            }
        }
        // so now here
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}
