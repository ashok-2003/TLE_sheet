import java.util.*;
public class geeks_ques_3 {
//    https://www.geeksforgeeks.org/problems/gray-code-1611215248/1
    // gery code
public ArrayList<String> graycode(int n) {
    // so now here the as we have explained in the copy about the grey code so now here writing it

    // return helper(n);

    // so now here the another code
    ArrayList<Integer> temp = helper2(n);
    // so nwo here
    ArrayList<String> ans = new ArrayList<>();
    for(int i : temp){
        // so now here get the string here
        String s = Integer.toBinaryString(i);
        // so now here here
        while(s.length() != n){
            // so now here we have to add the 0 in it
            s = "0" + s;
        }
        // so now adding this value here
        ans.add(s);
    }
    return ans;

}
    ArrayList<String> helper(int n){
        // so the base case here
        if(n == 1){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("0" );
            ans.add("1");
            return ans;
        }
        // so now here we have to get the recursion call each of hte time here
        ArrayList<String> temp  = helper(n-1); // so now here getting the result each of the time here
        // so now here getting the answer in the new Arraylist here
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < temp.size(); i++){
            ans.add("0"+temp.get(i));
        }
        // so now here for the 1 we have to add from the back here
        for(int i = temp.size()-1; i >= 0; i--){
            ans.add("1"+temp.get(i));
        }
        // so now here we have to return the answer here
        return ans;
    }
    ArrayList<Integer> helper2 (int n){
        // so now here
        int len = (int)Math.pow(2 , n);
        ArrayList<Integer> ans = new ArrayList<>();
        // so now here adding element in this
        for(int i = 0; i < len; i++){
            ans.add((i^(i>>1)));
        }
        return ans;
    }
}
