import java.io.*;
import java.util.StringTokenizer;

public class ques_2 {
//    https://codeforces.com/problemset/problem/1883/B
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
                int s = in.nextInt();
                int d = in.nextInt();
                String str = in.next();
                // so now here we have to count the number of different
                int[] count = new int[26];
                for(char ch : str.toCharArray()){
                    count[(int)(ch - 'a')]++;
                }
                // so now here count the number of odd here
                int countOdd = 0;
                for(int i = 0; i < 26; i++){
                    if(count[i]% 2 != 0){
                        countOdd++;
                    }
                }
                // so now here if count
                if(countOdd - 1 > d){
                    out.println("No");
                }else{
                    out.println("yes");
                }
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
