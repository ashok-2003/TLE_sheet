import java.util.Stack;

public class ques_394 {
//    https://leetcode.com/problems/decode-string/description/
public static void main(String[] args) {
    String s = "3[a2[c]]";
    System.out.println(decodeString(s));
}
public static String decodeString(String s) {
    // so now here it can be only solved using the stack here only
    Stack<Integer> stknum = new Stack<>();
    Stack<StringBuilder> stkstr = new Stack<>();
    // so nwo here we have to get the num here
    int rep = 0;
    StringBuilder curr = new StringBuilder();
    // so now here in the string
    for(char ch : s.toCharArray()){
        // so now here inside of it
        if(ch >='0' && ch <= '9'){
            // so now here we have to append in the num here
            rep = rep*10 + (int)ch -'0';
            // so as the number can be of the two digit also here so for that
        }
        else if (ch == '['){
            // so now here we have to push in the stack here
            stknum.push(rep);
            stkstr.push(curr);
            // so now reseting the valu of both here
            curr = new StringBuilder();
            rep = 0;
        }
        else if(ch == ']'){
            // so now here we have to get remove from the stack
            int times = stknum.pop();
            StringBuilder temp = curr;
            curr = stkstr.pop();
            // so now here we have to insert that many times
            for(int i = 0; i < times; i++){
                curr.append(temp);
            }

        }else{
            // so now here we have to append in the curr here
            curr.append(ch);
        }
    }
    return curr.toString();

}
}
