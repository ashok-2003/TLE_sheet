import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
//https://codeforces.com/problemset/problem/1791/D
public class ques_8 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            Main.FastReader in=new Main.FastReader();
            Main.FastWriter out = new Main.FastWriter();
            int testCases=in.nextInt();
            while(testCases-- > 0){
                int n = in.nextInt();
                String s = in.next();
                int[] freq = new int[26];
                for(char ch : s.toCharArray()){
                    freq[(int)ch-'a']++;
                }


                /*
                // so here we have to check also that if we have all different value or same
                boolean allsinngle = true;
                for(int i = 0; i < 26; i++){
                    if(freq[i] > 1){
                        allsinngle = false;
                        break;
                    }
                }
                if(allsinngle){
                    out.println(s.length());
                    continue;
                }

                int j = 0;
                int sum = 0;
                for(int i = 0; i < n; i++){
                    char ch = s.charAt(i);
                    if(freq[(int)ch-'a'] >= 2){
                        // so now here we have to get the value of j here
                        j = findnext(s , i);
                        int temp = count(s , j);
                        sum = Math.max(sum , temp);

                    }
                }
                out.println(sum);

                 */

                // so now we dose not have to do this all for that
                int[] pre = new int[26];
                int ans = 0;
                // so now just take the value from the both of side here
                for(char ch : s.toCharArray()){
                    --freq[(int)ch - 'a'];
                    ++pre[(int)ch - 'a'];
                    // so now here we have updated the value here
                    int curr = 0;
                    for (int i = 0; i < 26; i++){
                        curr += Math.min(1 , freq[i]) + Math.min(1 , pre[i]); // as repeted number just counted one
                    }
                    ans = Math.max(curr , ans);
                }
                out.println(ans);

            }
            out.close();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }
    static int findnext(String s , int i ){
        // so now here we have to find the next char
        for(int j = i+1; j < s.length(); j++){
            if(s.charAt(i) == s.charAt(j)){
                return j;
            }
        }
        return s.length();
    }
    static int count (String s , int j){
        int n = s.length();
        String str1 = s.substring(0 , j);
        String str2 = s.substring(j , n);
        // so now here we have to use the set to count the all diff result here
        int sum = 0;
        Set<Character> set = new HashSet<>();
        for(char ch : str1.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sum++;
            }
        }
        // so now here we have to perform the same thing on second also
        set.clear();
        for(char ch : str2.toCharArray()){
            if(!set.contains(ch)){
                sum++;
                set.add(ch);
            }
        }
        return sum;
    }
}
