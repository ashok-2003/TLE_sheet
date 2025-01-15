import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hackerrank_ques_1 {
//    https://www.hackerrank.com/challenges/password-cracker/problem?isFullScreen=true
    // password cracker question

    public static void main(String[] args) {
        // so now here this code is giving us the runtime error here so we required dynamic may be here
        // or i can't get the recursion solution here
    }
public static String passwordCracker(List<String> passwords, String loginAttempt) {
    // so now here we have to code it down as it have following
    // parameter here
    // so now here for the base case here if the all words of login
    // attempts are in password then we can procedd more further here
    if(chekc(passwords, loginAttempt) == false){
        return "WRONG PASSWORD";
    }
    // so now here otherwise we have to chek it
    // so storing all of the values of list in the set here
    Set<String> set = new HashSet<>();
    for(String s : passwords){
        set.add(s);
    }
    // so now here we have added alll fo the string here so nwo
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int j = 0;
    while(j <= loginAttempt.length()){
        // so now here we have to chekc of the every length here
        String str = loginAttempt.substring(i , j);
        // so now here we have to chekc if this value is contains
        // by the set or not here so nwo
        if(set.contains(str)){
            // so now we have to inclue this value to the stringbuilder
            // also here
            sb.append(" ");
            sb.append(str);
            // so now here we have to move the our i pointer also here
            i = j;
        }
        // so now in the all of the cases we have to increase the j
        j++;
    }
    // so nwo here at teh end we have to have get the ans here
    String ans = sb.toString();
    // here we have to remove the first " " space here
    ans = ans.substring(1);
    // so now comparing the both here
    String temp = ans.replace(" " , "");
    // so now here
    if(temp.equals(loginAttempt)){
        return ans;
    }else{
        return "WRONG PASSWORD";
    }

}
    static boolean chekc(List<String> passwords , String login){
        // so now here we have to store all of the characer in the
        // set first of all
        Set<Character> set = new HashSet<>();
        // so now here
        for(int i = 0; i < passwords.size(); i++){
            String s = passwords.get(i);
            // so now here we have to add all in the set here
            for(char ch : s.toCharArray()){
                set.add(ch);
            }
        }
        // so now here we have to check it
        for(int i = 0; i < login.length(); i++){
            char ch = login.charAt(i);
            if(!set.contains(ch)){
                return false;
            }
        }
        // otherwise we have to return the ture here
        return true;
    }

}

