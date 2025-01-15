import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ques_16 {
//    https://codeforces.com/problemset/problem/1666/D
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
                // so now here taking the input here
                String s  = in.next();
                String t = in.next();


                Map<Character, Integer> m1 = new HashMap<>();
                Map<Character, Integer> m2 = new HashMap<>();

                for (char ch : s.toCharArray()) {
                    m1.put(ch, m1.getOrDefault(ch, 0) + 1);
                }
                for (char ch : t.toCharArray()) {
                    m2.put(ch, m2.getOrDefault(ch, 0) + 1);
                }

                int i = 0, j = 0;
                while (i < s.length() && j < t.length()) {
                    if (s.charAt(i) == t.charAt(j)) {
                        if (m1.get(s.charAt(i)) < m2.get(t.charAt(j))) {
                            break;
                        }

                        if (m1.get(s.charAt(i)).equals(m2.get(t.charAt(j)))) {
                            // match!
                            m2.put(t.charAt(j), m2.get(t.charAt(j)) - 1);
                            j++;
                        }
                    }

                    m1.put(s.charAt(i), m1.get(s.charAt(i)) - 1);
                    i++;
                }

                if (j == t.length()) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

                /*
                char[] str = s.toCharArray();
                char[] target = t.toCharArray();
//                System.out.println(str + "\n" + target);


                // so now here we have taken both in the form of char array so nwo here we have to get the
                // frequency of both here so now


                int[] fstr = new int[26];
                int[] ftarget = new int[26];
                // so now here we have to get the value
                for(char ch : str){
                    fstr[ch - 'a']++;
                }
                for(char ch : target){
                    ftarget[ch - 'a']++;
                }
                // so nwo here we have count the frequency so now here
                int i = 0;
                int j = 0;
                while (i < str.length && j < target.length){
                    // so now here if we find the case in which frequency of target is greater then we have to return
                    if(target[j] == str[i]) {
                        if (ftarget[target[j] - 'a'] > fstr[str[i] - 'a']) {
                            // as we can not make that string
                            break;
                        }
                        if (ftarget[target[j] - 'a'] == fstr[str[i] - 'a']) {
                            // so we can move the j here
                            j++;
                            ftarget[target[j] - 'a']--;
                        }
                    }
                    // so now each time we have to increase the i here
                    i++;
                    fstr[str[i]-'a']--;
                }
                // so now here we have to compare the i and j
                if(j == target.length){
                    out.println("yes");
                }else{
                    out.println("no");
                }


                 */
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

}
