import java.util.*;
public class geeks_ques_1 {
//    https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
    // so this is the problem of recursion and backtracking
}
class Solution{
    static ArrayList<Integer> increasingNumbers(int N){
        ArrayList<Integer> list = new ArrayList<>();
        // so now here we have to get the helper here
        StringBuilder sb = new StringBuilder();
        helper(N , list , sb , 1);
        // so now here if the length is 1 then we have to append the 0 here
        if(N == 1){
            list.add(0 ,0);
        }
        return list;
    }
    // so now here we have to solve this using the recurison here
    static void helper(int n , ArrayList<Integer> list , StringBuilder sb , int index){
        // so now here
        if(sb.length() == n){
            // so nwo convert this to the integer and append this value here
            // so for that here
            int i = Integer.parseInt(sb.toString());
            list.add(i);
            return;
        }
        // so nwo here we have to take the integer here
        for(int i = index; i < 10; i++){
            // so now here we have to add the value to the stirngbuilder i then remove it
            sb.append(i);
            // so nwo here we have to run the loop of the next digit here also
            helper(n , list , sb , i+1); // so updated the index here so nwo
            // here we have to backtrack we have to remove the last value also here so nwo
            // for that
            sb.deleteCharAt(sb.length()-1); // backtrack here
        }
    }
}
