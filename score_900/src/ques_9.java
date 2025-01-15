import java.io.*;
import java.util.StringTokenizer;

public class ques_9 {
//    https://codeforces.com/problemset/problem/1828/B
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
                // so now here we have to take the len first of all here
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                // so now here we have to get the value here
                // so now here we get the position between them and the gcd of all like that will be the result here
                int gcd = 0;
                for (int i = 1; i <= n; i++) {
                    int temp = Math.abs(i - arr[i-1]);
                    gcd = gcd(gcd , temp);
                }
                out.println(gcd);
            }
            out.close();
        } catch (Exception e) {
            return;
        }
    }
    static int gcd(int a, int b)
    {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }
}
