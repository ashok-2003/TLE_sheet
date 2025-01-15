import java.io.*;
import java.util.StringTokenizer;

public class ques_9 {
//    https://codeforces.com/problemset/problem/1765/M
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
                // so now here we have to take the value of a and b here
                /*
                int a = n/2;
                int b = n - a;
                // so b will be greater than a here
                while (b % a != 0){
                    a--;
                    b++;
                }
                // so now here we have get the b percentile a value to zero so now b is the answer here
                out.println(b + " " + (n-b));

                 */

                // so this will give you time limit exceed value so
                int a = 1;
                for(int j = 2; j * j <= n; j++){
                    if(n % j == 0){
                        a = n /j;
                        break;
                    }
                }
                // so now here we are only checking the till square root part here only
                out.println(a + " "+ (n-a));
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
}
